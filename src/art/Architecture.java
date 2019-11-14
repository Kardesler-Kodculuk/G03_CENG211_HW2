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
		if(key == "name" || key == "style") {
			return super.compareTo(other, key);
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public double calculateCost() {
		return this.volume * this.getStyle().price;
	}

	@Override
	public boolean isTradable() {
		return (this.getStyle().name != "Renaissance");
	}
	
	@Override
	public boolean search(String querry) {
		boolean result = false;
		if(super.search(querry)) {
			result = true;
		}
		else {
			for(Architect arc : this.architects) {
				if(arc.getName().equals(querry)) {
					result = true;
					break;
				}
			}
		}
		return result;
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
