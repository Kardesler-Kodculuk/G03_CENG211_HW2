package art_vault;

import java.util.List;

import art.Painting;
import people.Artist;
import utility.CSVReader;

public class ArtVaultApp {

	public static void main(String[] args) {
		CSVReader.readFile("CENG211_HW2_ArtVaultData.csv");
		List<Painting> paintings = CSVReader.getPaintings();
		List<Artist> artists = CSVReader.getArtists();
		for (Painting painting : paintings) {
			System.out.println(painting);
		}
		
		System.out.println("\n------------------------------------------\n");
		
		for (Artist artist : artists) {
			System.out.println(artist);
		}

	}

}
