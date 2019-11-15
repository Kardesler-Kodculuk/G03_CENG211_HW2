package art_vault;

import java.util.Scanner;

import art.Artwork;
import people.Person;

import java.util.ArrayList;
import java.util.List;

import trade.Vault;
import utility.IComparable;
import utility.ListHelpers;

public final class ArtVaultAppMenu {
	private static final Scanner userIO = new Scanner(System.in);
	private static final String mainMenuPrompt = "1) Print the lists\n"
			+ "2) Search the Vault\n"
			+ "3) Trade\n"
			+ "0) Exit";
	private static final String chooseListPrompt = "1) Print the list of artists\n"
			+ "2) Print the list of architects\n"
			+ "3) Print the list of paintings\n"
			+ "4) Print the list of sculptures\n"
			+ "5) Print the list of architectures\n"
			+ "0) Exit";
	private static final String sortingMethodPrompt = "1) Sort by name\n"
			+ "2) Sort by artist\n"
			+ "3) Sort by style\n"
			+ "0) Exit";
	
	private static final String askForSearch = "Please enter your search querry: ";
	
	private static String input(String querry) {
		System.out.println(querry);
		String output = userIO.nextLine();
		if (output.endsWith("\n")){
			output = output.substring(0, output.length() - 1);
		}
		return output;
		
	}
	private static void printTheListSortedWithMethod(Vault vault, IComparable[] arr, String method) {
		List<IComparable> list = new ArrayList<IComparable>();
		for (IComparable comparable : arr) {
			list.add(comparable);
		}
		ListHelpers.sort(list, method);
		for (IComparable comparable : list) {
			System.out.println(comparable);
		}
	}
	
	private static void printTheListSorted(Vault vault, IComparable[] arr) {
		String prompt = input(sortingMethodPrompt);
		switch(prompt) {
		case "1":
			printTheListSortedWithMethod(vault, arr, "name");
			break;
		case "2":
			printTheListSortedWithMethod(vault, arr, "artist");
			break;
		case "3":
			printTheListSortedWithMethod(vault, arr, "style");
			break;
		case "0":
			System.exit(0);
			break;
		default:
			System.out.println("Illegal argument entered.");
			break;
		}
	}

	private static void printSearch(Vault vault) {
		String querry = input(askForSearch);
		List<String> results = vault.search(querry);
		for (String result : results) {
			System.out.println(result);
		}
	}

	private static void printTheLists(Vault vault) {
		String key = "";
		IComparable[] arr = new IComparable[5];
		String prompt = input(chooseListPrompt);
		switch (prompt) {
		case "1":
			printTheListSorted(vault, vault.getArtists().toArray(arr));
			break;
		case "2":
			printTheListSorted(vault, vault.getArchitects().toArray(arr));
			break;
		case "3":
			printTheListSorted(vault, vault.getPaintings().toArray(arr));
			break;
		case "4":
			printTheListSorted(vault, vault.getSculptures().toArray(arr));
			break;
		case "5":
			printTheListSorted(vault, vault.getArchitectures().toArray(arr));
			break;
		case "0":
			System.exit(0);
			break;
		default:
			System.out.println("Invalid argument entered");
			break;
		}
	}
	
	private static void trade(Vault mainVault) {
		String tradeResult = mainVault.trade();
		System.out.println(tradeResult);

	}
	public static void mainMenu(Vault mainVault) {
		String userInput;
		do {
			userInput = input(mainMenuPrompt);
			switch (userInput) {
			case "1":
				printTheLists(mainVault);
				break;
			case "2":
				printSearch(mainVault);
				break;
			case "3":
				break;
			case "0":
				break;
			default:
				System.out.println("Invalid input.");
				break;
			}
		} while(!userInput.equals("0"));
	}
}
