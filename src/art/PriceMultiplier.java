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
}
