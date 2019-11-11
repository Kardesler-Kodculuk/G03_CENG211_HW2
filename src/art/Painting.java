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
		return Artist;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
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
	public void tradeToBuyer(Buyer buyer, Seller seller) {
		// TODO Auto-generated method stub

	}

	@Override
	public double calculateCost() {
		// TODO Auto-generated method stub
		return 0;
	}

}
