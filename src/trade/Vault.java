package trade;

import java.util.List;

import art.*;
import people.*;

public class Vault implements ISearchable {
	
	private List<Architect> architects;
	private List<Artist> artists;
	private List<Painting> paintings;
	private List<Sculpture> sculptures;
	private List<Architecture> architectures;
	private Seller seller;
	private List<Buyer> buyers;
	
	public Vault(List<Architect> architects, List<Artist> artists, List<Painting> paintings, List<Sculpture> sculptures,
			List<Architecture> architectures, Seller seller, List<Buyer> buyers) {
		this.architects = architects;
		this.artists = artists;
		this.paintings = paintings;
		this.sculptures = sculptures;
		this.architectures = architectures;
		this.seller = seller;
		this.buyers = buyers;
	}

	public List<Architect> getArchitects() {
		return architects;
	}
	public List<Artist> getArtists() {
		return artists;
	}
	public List<Painting> getPaintings() {
		return paintings;
	}
	public List<Sculpture> getSculptures() {
		return sculptures;
	}

	public List<Architecture> getArchitectures() {
		return architectures;
	}
	public Seller getSeller() {
		return seller;
	}
	public List<Buyer> getBuyers() {
		return buyers;
	}

	@Override
	public boolean search(String type, String querry) {
		// TODO Auto-generated method stub
		return false;
	}

}
