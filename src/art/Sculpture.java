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
		if(key.equals("name") || key.equals("style")) {
			return super.compareTo(other, key);
		}
		Sculpture scu = (Sculpture) other;
		
		if(key.equals("artist")) {
			return this.artist.getName().compareTo(scu.artist.getName());
		}
		else if(key.equals("material")) {
			return this.material.getName().compareTo(scu.artist.getName());
		}
		else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public boolean isTradable() {
		if(this.getStyle().getName().equals("Baroque")) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public double calculateCost() {
		if(this.material.getName().equals("Marble")) {
			return this.weight * 15;
		}
		else if(this.material.getName().equals("Bronze")){
			return this.weight * 180;
		}
		return -1;
	}
	
	@Override 
	public String toBill() {
		String output = "Sculpture: ";
		output += "\n" + super.toBill();
		return output;
	}
	
	@Override
	public boolean search(String querry) {
		boolean equality = (this.artist.getName().equals(querry) || this.material.getName().equals(querry));
		return equality || super.search(querry);
	}
	
	@Override
	public String toString() {
		String stringRepresentation = "Sculpture:\n";
		stringRepresentation += super.toString();
		stringRepresentation += "\n\tArtist: " + artist.toString() +
				"\n\tMaterial: " + material.toString() +
				"\n\tWeight: " + new Double(weight).toString(); 
		return stringRepresentation;
		
	}

}
