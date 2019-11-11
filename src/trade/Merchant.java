package trade;

import java.util.ArrayList;

import art.Artwork;


/**
 * Base class for Seller and Buyer classes
 *
 */
public abstract class Merchant {
	protected double wallet;
	protected ArrayList<Artwork> privateCollection;
	
	/**
	 * 
	 * @return the money value of the vallet.
	 */
	public double getWalletValue() {
		return wallet;
	}
}
