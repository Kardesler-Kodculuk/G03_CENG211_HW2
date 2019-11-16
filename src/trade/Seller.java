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
		super(wallet, artworks);
	}

	public Seller() {
		this(0, null);
	}
	/**
	 * Remove an artwork from the collection.
	 * @param artwork to remove.
	 */
	public void removeFromCollection(Artwork artwork) {
		if (getCollection().contains(artwork))
			getCollection().remove(artwork);
	}
	
	/**
	 * Add an amount of money to the collection.
	 * @param amount to add.
	 */
	public void addToWallet(double amount) {
		setWallet(getWalletValue() + amount);
	}
	
	/**
	 * Extend the privateCollection with elements of the given Array.
	 * @param extensionArray
	 */
	public void extendCollection(Artwork[] extensionArray) {
		for (Artwork artwork : extensionArray) {
			getCollection().add(artwork); // Reason we take an array is due to the casting issues with List. 
		}
	}
}
