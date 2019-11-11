package trade;

import art.Artwork;

public class Seller extends Merchant {
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
}
