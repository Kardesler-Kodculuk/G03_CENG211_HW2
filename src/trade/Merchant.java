package trade;

import java.util.List;

import art.Artwork;


/**
 * Base class for Seller and Buyer classes
 *
 */
public abstract class Merchant {
	protected double wallet;
	protected List<Artwork> privateCollection;
	
	/**
	 * 
	 * @return the money value of the vallet.
	 */
	public double getWalletValue() {
		return wallet;
	}
}
