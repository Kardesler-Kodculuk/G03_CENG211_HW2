package art_vault;

import java.util.List;

import trade.Buyer;
import trade.Seller;
import trade.Vault;
import utility.CSVReader;

import java.util.ArrayList;

/**
 * Entrance to the app.
 */
public class ArtVaultApp {

	/**
	 * Create the list of buyers.
	 * @param numberOfBuyers Number of buyers to create.
	 * @return A list of buyers.
	 */
	private static List<Buyer> createBuyersList(Integer numberOfBuyers) {
		List<Buyer> buyers = new ArrayList<Buyer>();
		for (int i = 0; i < numberOfBuyers; i++) {
			buyers.add(new Buyer(5000000.00));
		}
		return buyers;
	}
	
	public static void main(String[] args) {
		CSVReader.readFile("CENG211_HW2_ArtVaultData.csv");
		Vault artVault = new Vault(CSVReader.getArchitects(), CSVReader.getArtists(),
				CSVReader.getPaintings(), CSVReader.getSculptures(),
				CSVReader.getArchitectures(), new Seller(), createBuyersList(4)); //TO-DO: Fix null to empty.

		ArtVaultAppMenu.mainMenu(artVault);
	}
}
