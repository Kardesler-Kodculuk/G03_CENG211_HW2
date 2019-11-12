package art;

import people.Artist;

public class Sculpture extends Artwork {

	private Artist artist;
	private PriceMultiplier material;
	private double weight;
	
	public Sculpture(String name, PriceMultiplier style, Artist artist,
			PriceMultiplier material, double weight) {
		super(name, style);
		this.artist = artist;
		this.material = material;
		this.weight = weight;
	}

	public Artist getArtist() {
		return artist;
	}

	public PriceMultiplier getMaterial() {
		return material;
	}

	public double getWeight() {
		return weight;
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
