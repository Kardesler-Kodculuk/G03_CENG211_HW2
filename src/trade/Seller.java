package trade;

import java.util.List;

import art.Artwork;

public class Seller extends Merchant {

	
	/**
	 * Initiate a Seller object.
	 * @param wallet
	 * @param artworks
	 */
	public Seller(double wallet, List<Artwork> artworks) {
		this.wallet = wallet;
		this.privateCollection = artworks;
	}

	/**
	 * Remove an artwork from the collection.
	 * @param artwork to remove.
	 */
	public void removeFromCollection(Artwork artwork) {
		if (this.privateCollection.contains(artwork))
			this.privateCollection.remove(artwork);
	}
	
	/**
	 * Add an amount of money to the collection.
	 * @param amount to add.
	 */
	public void addToWallet(double amount) {
		this.wallet += amount;
	}
	
	public void extendCollection(Artwork[] extensionArray) {
		for (Artwork artwork : extensionArray) {
			this.privateCollection.add(artwork);
		}
	}
}
