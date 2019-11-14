package art_vault;

import java.util.List;

import art.Painting;
import people.Artist;
import trade.Buyer;
import trade.Seller;
import trade.Vault;
import utility.CSVReader;

import java.util.ArrayList;
import java.util.Arrays;
public class ArtVaultApp {

	private static List<Buyer> createBuyersList(Integer numberOfBuyers) {
		List<Buyer> buyers = new ArrayList<Buyer>();
		for (int i = 0; i < numberOfBuyers; i++) {
			buyers.add(new Buyer());
		}
		return buyers;
	}
	
	public static void main(String[] args) {
		CSVReader.readFile("CENG211_HW2_ArtVaultData.csv");
		Vault artVault = new Vault(CSVReader.getArchitects(), CSVReader.getArtists(),
				CSVReader.getPaintings(), CSVReader.getSculptures(),
				CSVReader.getArchitectures(), new Seller(0, null), createBuyersList(5)); //TO-DO: Fix null to empty.

		ArtVaultAppMenu.mainMenu(artVault);
	}
}
