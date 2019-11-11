package art;

import utility.IComparable;

/**
 * Material class represents the material an object is made of.
 *
 */
public class PriceMultiplier implements IComparable<PriceMultiplier>{
	public final double price;
	public final String name;

	public PriceMultiplier(String name, double price) {
		/**
		 * Define a material.
		 */
		this.name = name;
		this.price = price;
	}

	@Override
	public int compareTo(PriceMultiplier other, String key) {
		return this.name.compareTo(other.name);
	}
}
