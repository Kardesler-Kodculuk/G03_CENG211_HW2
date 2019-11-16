package trade;

import java.util.ArrayList;
import java.util.List;

import art.Artwork;

public class Buyer extends Merchant {
	
	/**
	 * Initiate a Buyer object.
	 * @param wallet
	 */
	public Buyer(double wallet) {
		this.wallet = wallet;
		this.privateCollection = new ArrayList<Artwork>();
	}
	
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
