package trade;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import art.*;
import people.*;
import utility.IComparable;
import utility.ListHelpers;

public class Vault {
	
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

	public List<String> search(String querry) {
		List<String> results = new ArrayList<String>();
		ISearchable[] arr = new ISearchable[0];
		List<ISearchable> searchIn = new ArrayList<ISearchable>();
		ListHelpers.extendList(searchIn, artists.toArray(arr.clone()));
		ListHelpers.extendList(searchIn, architects.toArray(arr.clone()));
		ListHelpers.extendList(searchIn, paintings.toArray(arr.clone()));
		ListHelpers.extendList(searchIn, architectures.toArray(arr.clone()));
		ListHelpers.extendList(searchIn, sculptures.toArray(arr.clone()));
		for (ISearchable searchable : searchIn) {
			if (searchable.search(querry)) {
				results.add(searchable.toString());
			}
		}
		return results;
	}

}
