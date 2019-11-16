package trade;

import java.util.ArrayList;
import java.util.List;

import art.Artwork;


/**
 * Base class for Seller and Buyer classes
 *
 */
public abstract class Merchant {
	private double wallet;
	private List<Artwork> privateCollection;
	private final double initialWallet;
	
	public Merchant(double wallet, List<Artwork> privateCollection) {
		this.wallet = wallet;
		this.initialWallet = wallet;
		if (privateCollection == null) {
			privateCollection = new ArrayList<Artwork>();
		}
		this.privateCollection = privateCollection;
		
	}
	
	/**
	 * 
	 * @return the money value of the vallet.
	 */
	public double getWalletValue() {
		return wallet;
	}
	
	/**
	 * Get the private collection.
	 * @return private collection of the Merchant.
	 */
	protected List<Artwork> getCollection() {
		return this.privateCollection;
	}
	
	/**
	 * Set the wallet value to the new value;
	 * @param newValue - newValue to set.
	 */
	protected void setWallet(double newValue) {
		this.wallet = newValue;
	}
	
	/**
	 * Reset the wallet value of the merchant.
	 */
	protected void reset() {
		this.wallet = this.initialWallet;
		this.privateCollection = new ArrayList<Artwork>(); // Leave the former ArrayList to Garbace Collector.
	}
}
