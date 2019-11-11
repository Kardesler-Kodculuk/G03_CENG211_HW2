package art;

import trade.Buyer;
import trade.Seller;

public class Architecture extends Artwork {
	
	private final double length;
	private final double width;
	private final double height;
	private final double volume;
	
	public Architecture(String name, PriceMultiplier style, double length, double width, double height) {
		this.name = name;
		this.style = style;
		this.length = length;
		this.width = width;
		this.height = height;
		this.volume = length * width * height;
	}

	@Override
	public int compareTo(Artwork other, String key) {
		Architecture architecture = (Architecture) other;
		if (architecture.equals(this)) {
			return 0;
		}
		switch (key) {
		case "name":
			return this.name.compareTo(architecture.name);
		case "style":
			return this.style.compareTo(architecture.style, "name");
		}
		
		return 1;
	}

	@Override
	public double calculateCost() {
		return this.volume * this.style.price;
	}

	@Override
	public boolean isTradable() {
		return (this.style.name != "Renaissance");
	}

}
