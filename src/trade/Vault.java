package trade;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import art.*;
import people.*;
import utility.ListHelpers;

public class Vault {
	
	private List<Architect> architects;
	private List<Artist> artists;
	private List<Painting> paintings;
	private List<Sculpture> sculptures;
	private List<Architecture> architectures;
	private Seller seller;
	private List<Buyer> buyers;
	
	public Vault(List<Architect> architects, List<Artist> artists, List<Painting> paintings, List<Sculpture> sculptures,
			List<Architecture> architectures, Seller seller, List<Buyer> buyers) {
		this.architects = architects;
		this.artists = artists;
		this.paintings = paintings;
		this.sculptures = sculptures;
		this.architectures = architectures;
		this.seller = seller;
		this.buyers = buyers;
		initialiseSellersBuyers();
	}

	public List<Architect> getArchitects() {
		return architects;
	}
	public List<Artist> getArtists() {
		return artists;
	}
	public List<Painting> getPaintings() {
		return paintings;
	}
	public List<Sculpture> getSculptures() {
		return sculptures;
	}

	public List<Architecture> getArchitectures() {
		return architectures;
	}
	public Seller getSeller() {
		return seller;
	}
	public List<Buyer> getBuyers() {
		return buyers;
	}

	private void initialiseSellersBuyers() {
		List<ISearchable> artworks = new ArrayList<ISearchable>();
		Artwork[] artworkGuide = new Artwork[0];
		ListHelpers.extendList(artworks, paintings.toArray(artworkGuide));
		ListHelpers.extendList(artworks, architectures.toArray(artworkGuide));
		ListHelpers.extendList(artworks, sculptures.toArray(artworkGuide));
		seller.reset();
		seller.extendCollection(artworks.toArray(artworkGuide));
		for (Buyer buyer : buyers) {
			buyer.reset();
		}
	}
	
	public List<String> search(String querry) {
		List<String> results = new ArrayList<String>();
		ISearchable[] arr = new ISearchable[0];
		List<ISearchable> searchIn = new ArrayList<ISearchable>();
		ListHelpers.extendList(searchIn, artists.toArray(arr.clone()));
		ListHelpers.extendList(searchIn, architects.toArray(arr.clone()));
		ListHelpers.extendList(searchIn, paintings.toArray(arr.clone()));
		ListHelpers.extendList(searchIn, architectures.toArray(arr.clone()));
		ListHelpers.extendList(searchIn, sculptures.toArray(arr.clone()));
		for (ISearchable searchable : searchIn) {
			if (searchable.search(querry)) {
				results.add(searchable.toString());
			}
		}
		return results;
	}
	
	/**
	 * Generates random integer between 0 (inclusive) and given bound (exclusive)
	 * @param bound - upper limit as a integer
	 * @return random integer
	 */
	private int genRandInt(int bound) {
		Random ran = new Random();
		int result = ran.nextInt(bound);
		return result;
	}
	
	/**
	 * It picks random tradable artwork from collection
	 * @return An artwork object which is tradable
	 */
	private Artwork randomTradableArtwork() {
		int len = seller.getCollection().size();
		Artwork art = seller.getCollection().get(genRandInt(len));
		boolean isTradable = art.isTradable();
		while(!isTradable) {
			art = seller.getCollection().get(genRandInt(len));
			isTradable = art.isTradable();
		}
		return art;
	}
	
	/**
	 * It performs one random buyer between buyer and seller
	 * @param buyer - A buyer object
	 * @param seller - A seller object
	 * @return sale info as a string
	 */
	private String performOneTrade(Buyer buyer, Seller seller) {
		Artwork art = randomTradableArtwork();
		art.tradeToBuyer(buyer, seller);
		String output = art.toBill();
		return output;
	}
	
	/**
	 * It calculates all the merchants' balance
	 * @return All balances of the merchants as a String object
	 */
	private String calculateBalances() {
		String output = "";
		String sellerMoney = String.format("%.2f", seller.getWalletValue()) + " " + "TL";
		output += "Seller's money: " + sellerMoney + "\n";
		String buyerMoney;
		Buyer buyer;
		for(int i = 0; i < 4; i++) {
			buyer = buyers.get(i);
			buyerMoney = String.format("%.2f", buyer.getWalletValue()) + " " + "TL";
			output += "Buyer" + (i+1) + "'s money: " + buyerMoney + " \n";
		}
		return output;
		
	}
	
	/**
	 * Performs random trade operations between buyers and seller
	 * @return String - info about sales (initial moneys of the merchants, sales, last moneys)
	 */
	public String trade() {
		initialiseSellersBuyers();
		String output = "";
		output += calculateBalances();
		output += "\nTrade started:";
		String saledArt = "";
		for(int i = 0; i < 4; i++) {
			Buyer buyer = buyers.get(i);
			saledArt = performOneTrade(buyer, seller);
			output += "\n\nBuyer " + (i+1) + " bought:\n\n"
					+ saledArt;
		}
		output += "\n\nTrade completed: \n\n";
		output += calculateBalances();
		return output;
	}

}
