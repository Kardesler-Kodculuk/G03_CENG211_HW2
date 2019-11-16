package art_vault;

import java.util.Scanner;

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
	private static final String askForSearch = "Please enter your search querry: ";
	private static final String[][] searchMethods = {{"name", "birthday", "nationality"}, {"name", "birthday", "nationality"}, {"name", "style", "artist"},
			{"name", "style", "artist", "matherial"}, {"name", "style"}};
	
	/**
	 * Take the input from the user.
	 * @param querry - What question to ask to user.
	 * @return The user input.
	 */
	private static String input(String querry) {
		System.out.println(querry);
		String output = userIO.nextLine(); // Consume the End of Line operator.
		if (output.endsWith("\n")){
			output = output.substring(0, output.length() - 1);
		}
		return output;
		
	}
	
	/**
	 * Print the lists sorted via a certain method.
	 * @param vault Vault to search in.
	 * @param arr Array to hold the comparables.
	 * @param method Method to sort by.
	 */
	@SuppressWarnings("rawtypes")
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
	
	/**
	 * Print the list sorted, ask for method to userç
	 * @param vault Vault to search in
	 * @param arr Array to put them in.
	 * @param options Options for which methods are available per object class.
	 */
	private static void printTheListSorted(Vault vault, @SuppressWarnings("rawtypes") IComparable[] arr, String[] options) {
		String querry = "";
		int index = 1;
		for (String option : options) {
			querry += Integer.toString(index) + ") Sort by " + option + "\n"; 
		}
		querry += "0) Exit\n";
		String prompt = input(querry);
		try {
			int optionIndex = Integer.parseInt(prompt);
			if (optionIndex == 0) System.exit(0);
			else {
				printTheListSortedWithMethod(vault, arr, options[optionIndex - 1]);
			}
		} catch (NumberFormatException e) {
			System.out.println("Please enter a number");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Please enter a number inside the range");
		}
	}

	/**
	 * Search for a querry and print the results
	 * @param vault Vault to search in.
	 */
	private static void printSearch(Vault vault) {
		String querry = input(askForSearch);
		List<String> results = vault.search(querry);
		for (String result : results) {
			System.out.println(result);
		}
	}
	
	/**
	 * Print the lists.
	 * @param vault Vault to search in.
	 */
	@SuppressWarnings("rawtypes")
	private static void printTheLists(Vault vault) {
		IComparable[] guideArray = new IComparable[0];
		IComparable[] comparableArray = new IComparable[0];
		String prompt = input(chooseListPrompt);
		boolean invalid = false;
		switch (prompt) {
		case "1":
			comparableArray = vault.getArtists().toArray(guideArray);
			break;
		case "2":
			comparableArray = vault.getArchitects().toArray(guideArray);
			break;
		case "3":
			comparableArray = vault.getPaintings().toArray(guideArray);
			break;
		case "4":
			comparableArray = vault.getSculptures().toArray(guideArray);
			break;
		case "5":
			comparableArray = vault.getArchitectures().toArray(guideArray);
			break;
		case "0":
			System.exit(0);
			break;
		default:
			System.out.println("Invalid argument entered");
			invalid = true;
			break;
		}
		if (!invalid) {
			try {
				printTheListSorted(vault, comparableArray, searchMethods[Integer.parseInt(prompt) -1]);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number");
			}
		}
	}
	
	/**
	 * Initiate a trade, reset each turn.
	 * @param mainVault Vault to trade by.
	 */
	private static void trade(Vault mainVault) {
		String tradeResult = mainVault.trade();
		System.out.println(tradeResult);
	}

	/**
	 * Entrance to main menu.
	 * @param mainVault Vault to operate on.
	 */
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
				trade(mainVault);
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
