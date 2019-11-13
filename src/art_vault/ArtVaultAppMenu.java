package art_vault;

import java.util.Scanner;

import art.Artwork;
import people.Person;

import java.util.List;

import trade.Vault;
import utility.IComparable;

public class ArtVaultAppMenu {
	private static Scanner userIO;
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
	
	private static void printTheListSortedWithMethod(Vault vault, Object[] list, String method) {
		;
	}
	
	private static void printTheListSorted(Vault vault, IComparable[] arr) {
		System.out.println(sortingMethodPrompt);
		switch(userIO.nextLine()) {
		case "1":
			
		}
	}
	
	private static void printTheLists(Vault vault) {
		System.out.println(chooseListPrompt);
		String key = "";
		IComparable[] arr = new IComparable[5];
		switch (userIO.nextLine()) {
		case "1":
			printTheListSorted(vault, vault.getArtists().toArray(arr));
			break;
		case "2":
			key = "architect";
			break;
		case "3":
			key = "painting";
			break;
		case "4":
			key = "sculpture";
			break;
		case "5":
			key = "architecture";
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
		userIO = new Scanner(System.in);
		String userInput;
		do {
			System.out.println(mainMenuPrompt);
			userInput = userIO.next();
			switch (userInput) {
			case "1":
				printTheLists(mainVault);
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
