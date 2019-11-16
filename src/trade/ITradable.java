package trade;

public interface ITradable {
	/**
	 * Determine if a certain item is tradable.
	 * @return true if tradable, false otherwise.
	 */
	public boolean isTradable();
	
	/**
	 * Trade an item, in the sellers inventory to the buyer.
	 * @param buyer Buyer to trade to.
	 * @param seller Seller to sell from.
	 */
	public void tradeToBuyer(Buyer buyer, Seller seller);
}
