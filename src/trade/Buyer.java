package trade;

import java.util.ArrayList;

import art.Artwork;

public class Buyer extends Merchant {
	
	/**
	 * Initiate a Buyer object.
	 * @param wallet
	 */
	public Buyer(double wallet) {
		super(wallet, new ArrayList<Artwork>());
	}
	
	/**
	 * Add artwork to collection
	 * @param artwork to add.
	 */
	public void addToCollection(Artwork artwork) {
		getCollection().add(artwork);
	}
	
	/**
	 * Remove money from wallet.
	 * @param amount Amount to remove.
	 * @throws AssertionError Wallet balance must stay positive.
	 */
	public void removeFromWallet(double amount) throws AssertionError {
		assert (getWalletValue() >= amount);
		setWallet(getWalletValue() - amount);
	}
}
