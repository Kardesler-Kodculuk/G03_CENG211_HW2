package art;

import java.util.ArrayList;

import people.Architect;


public class Architecture extends Artwork {
	
	private final double length;
	private final double width;
	private final double height;
	private final double volume;
	private ArrayList<Architect> architects;
	
	public Architecture(String name, PriceMultiplier style, double length, double width, double height) {
		super(name, style);
		this.length = length;
		this.width = width;
		this.height = height;
		this.volume = length * width * height;
		this.architects = new ArrayList<Architect>();
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
	
	/**
	 * Add an architect to the architects list of the Architecture.
	 * @param architect
	 */
	public void addArchitect(Architect architect) {
		this.architects.add(architect);
	}
	
	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

}
