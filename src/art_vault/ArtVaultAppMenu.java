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
	
	private static void printTheListSortedWithMethod(Vault vault, IComparable[] arr, String method) {
		List<IComparable> list = new ArrayList<IComparable>();
		for (IComparable comparable : arr) {
			list.add(comparable);
		}
		ListHelpers.sort(list, method);
		System.out.println(list);
	}
	
	private static void printTheListSorted(Scanner userIO, Vault vault, IComparable[] arr) {
		System.out.println(sortingMethodPrompt);
		String prompt = userIO.next();
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
	
	private static void printSearch(Scanner userIO, Vault vault, String querry) {
		vault.search(querry);
	}
	
	private static void printTheLists(Scanner userIO, Vault vault) {
		System.out.println(chooseListPrompt);
		String key = "";
		IComparable[] arr = new IComparable[5];
		String prompt = userIO.next();
		switch (prompt) {
		case "1":
			printTheListSorted(userIO, vault, vault.getArtists().toArray(arr));
			break;
		case "2":
			printTheListSorted(userIO, vault, vault.getArchitects().toArray(arr));
			break;
		case "3":
			printTheListSorted(userIO, vault, vault.getPaintings().toArray(arr));
			break;
		case "4":
			printTheListSorted(userIO, vault, vault.getSculptures().toArray(arr));
			break;
		case "5":
			printTheListSorted(userIO, vault, vault.getArchitectures().toArray(arr));
			break;
		case "0":
			System.exit(0);
			break;
		default:
			System.out.println("Invalid argument entered");
			break;
		}
	}
	
	public static void mainMenu(Vault mainVault) {
		Scanner userIO = new Scanner(System.in);
		String userInput;
		do {
			System.out.println(mainMenuPrompt);
			userInput = userIO.next();
			switch (userInput) {
			case "1":
				printTheLists(userIO, mainVault);
				break;
			case "2":
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
