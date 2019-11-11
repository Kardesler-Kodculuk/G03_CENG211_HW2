package trade;

import art.Artwork;

public class Buyer extends Merchant {
	
	/**
	 * Add artwork to collection
	 * @param artwork to add.
	 */
	public void addToCollection(Artwork artwork) {
		this.privateCollection.add(artwork);
	}
	
	/**
	 * Remove money from wallet.
	 * @param amount Amount to remove.
	 * @throws AssertionError Wallet balance must stay positive.
	 */
	public void removeFromWallet(double amount) throws AssertionError {
		assert (this.wallet >= amount);
		this.wallet -= amount;
	}
}
