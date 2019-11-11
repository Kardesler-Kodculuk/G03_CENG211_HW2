package art;

import people.Architect;

public class Sculpture extends Artwork {

	private Architect[] architects;
	private double length;
	private double width;
	private double height;
	
	public Sculpture(String name, PriceMultiplier style, Architect[] architects, 
			double length, double width, double height) {
		super(name, style);
		this.architects = architects;
		this.length = length;
		this.width = width;
		this.height = height;
	}
	
	public Architect[] getArchitects() {
		return architects;
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

	@Override
	public int compareTo(Artwork other, String key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isTradable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double calculateCost() {
		// TODO Auto-generated method stub
		return 0;
	}

}
