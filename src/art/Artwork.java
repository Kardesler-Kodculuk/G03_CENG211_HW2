package art;

import trade.Buyer;
import trade.ITradable;
import trade.Seller;
import utility.IComparable;

public abstract class Artwork implements IComparable<Artwork>, ITradable {
	private String name;
	private PriceMultiplier style;
	
	public Artwork(String name, PriceMultiplier style) {
		this.name = name;
		this.style = style;
	}
	
	public String getName() {
		return this.name;
	}
	public PriceMultiplier getStyle() {
		return this.getStyle();
	}
	/**
	 * Accessed from Vault, this trades this artifact to a buyer from a seller.
	 */
	public void tradeToBuyer(Buyer buyer, Seller seller) {
		if (isTradable()) {
			if (calculateCost() <= buyer.getWalletValue()) {
				seller.removeFromCollection(this);
				buyer.removeFromWallet(calculateCost());
				buyer.addToCollection(this);
				seller.addToWallet(calculateCost());
			}
		}
	}
	
	/**
	 * Calculate the cost of an artwork.
	 * @return
	 */
	public abstract double calculateCost();
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
