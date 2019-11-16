package art;

import utility.IComparable;

/**
 * Anything that affect's an artwork's price.
 */
public class PriceMultiplier implements IComparable<PriceMultiplier>{
	private final double price;
	private final String name;

	/**
	 * Initialise a priceModifier.
	 * @param name Name of the priceModifier.
	 * @param price Price of the price modifier.
	 */
	public PriceMultiplier(String name, double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public int compareTo(PriceMultiplier other, String key) {
		return this.getName().compareTo(other.getName());
	}
	
	private static PriceMultiplier parseArchitectureMultiplier(String value) {
		switch(value.toLowerCase()) {
		case "gothic":
			return new PriceMultiplier("Gothic", 1.0);
		case "baroque":
			return new PriceMultiplier("Baroque", 0.8);
		default:
			return new PriceMultiplier(value, 0.6);
		}
	}
	
	/**
	 * Parse the value from a painting and return its corresponding object.
	 * @param value
	 * @return
	 */
	private static PriceMultiplier parsePaintingMultiplier(String value) {
		switch(value.toLowerCase()) {
		case "renaissance":
			return new PriceMultiplier(value, 7);
		case "baroque":
			return new PriceMultiplier(value, 5.5);
		default:
			return new PriceMultiplier(value, 4.5);
		}
	}
	
	private static PriceMultiplier parseSculptureMultiplier(String value) {
		switch (value.toLowerCase()) {
		case "bronze":
			return new PriceMultiplier(value, 180);
		case "marble":
			return new PriceMultiplier(value, 15);
		default:
			return new PriceMultiplier(value, 0);
		}
	}
	
	
	public static PriceMultiplier decideMultiplier(String value, String key) {
		switch (key) {
		case "architecture":
			return parseArchitectureMultiplier(value);
		case "painting":
			return parsePaintingMultiplier(value);
		case "sculpture":
			return parseSculptureMultiplier(value);
		case "sculpture-style":
			return new PriceMultiplier(value, -1);
		}
		return null;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}

	/**
	 * Get the name of the priceModifier
	 * @return the name of the priceModifier
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the price of the priceModifier.
	 * @return the name of the priceModifier.
	 */
	public double getPrice() {
		return price;
	}
}
