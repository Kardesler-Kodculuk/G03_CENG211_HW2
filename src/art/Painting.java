package art;

import trade.Buyer;
import people.Artist;
import trade.Seller;

public class Painting extends Artwork {
	private Artist artist;
	private double length;
	private double width;
	
	public Painting(String name, PriceMultiplier style, Artist artist, double length, 
			double width) {
		super(name, style);
		this.artist = artist;
		this.length = length;
		this.width = width;
	}
	
	public double getSize() {
		return this.length*this.width;
	}
	
	public Artist getArtist() {
		return artist;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}
	
	@Override
	public int compareTo(Artwork other, String key) {
		if(key.equals("name") || key.equals("style")) {
			return super.compareTo(other, key);
		}
		Painting paint = (Painting) other;
		if(key.equals("artist")) {
			return this.artist.getName().compareTo(paint.artist.getName());
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public boolean isTradable() {
		if (this.getStyle().name == "Gothic") {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public void tradeToBuyer(Buyer buyer, Seller seller) {
		if (isTradable()) {
			super.tradeToBuyer(buyer, seller);
		}
		else {
			System.out.println("this item is not tradable");
		}

	}
	
	@Override
	public boolean search(String querry) {
		boolean result = false;
		if(super.search(querry)) {
			result = true;
		}
		else if(this.artist.getName().equals(querry)) {
			result = true;
		}
		return result;
	}
	
	/**
	 * Calculates the area of the painting
	 * @param length
	 * @param width
	 * @return - area of the painting
	 */
	private double calcArea(double length, double width) {
		return this.length * this.width;
	}
	
	@Override
	public double calculateCost() {
		double area = calcArea(this.length, this.width);
		switch(super.getStyle().name) {
		case "Renaissance":
			return area * 7;
		case "Baroque":
			return area * 5.5;
		default:
			return area * 4.5;
		}
	}
	
	@Override
	public String toString() {
		String str = "Architecture: ";
		str += "\n" + super.toString();
		str += "\n\tLength: " + this.length
				+ "\n\tWidth: " + this.width 
				+ "\n\tArtist: " + this.artist.toString();
		return str;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
