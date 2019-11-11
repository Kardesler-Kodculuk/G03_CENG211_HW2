package trade;

import art.Artwork;

public class Seller extends Merchant {
	public void removeFromCollection(Artwork artwork) {
		if (this.privateCollection.contains(artwork))
			this.privateCollection.remove(artwork);
	}
}
