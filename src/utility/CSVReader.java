package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import art.Architecture;
import art.Painting;
import art.PriceMultiplier;
import art.Sculpture;
import people.Architect;
import people.Artist;

public class CSVReader {
	private static ArrayList<Painting> paintings = new ArrayList<Painting>();
	private static ArrayList<Sculpture> sculptures = new ArrayList<Sculpture>();
	private static ArrayList<Architecture> architectures = new ArrayList<Architecture>();
	private static ArrayList<Artist> artists = new ArrayList<Artist>();
	private static ArrayList<Architect> architects = new ArrayList<Architect>();
	
	private static PriceMultiplier decideMultiplier(String key) {return null;}

	/**
	 * Create an artist.
	 * @param args
	 */
	private static void createArtist(String[] args) {
		String[] periods = new String[args.length - 5];
		for (int i = 5; i < args.length; i++) {
			periods[i - 5] = args[i];
		}
		artists.add(new Artist(args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]), args[4], periods));
	}
	
	/**
	 * Create an architect.
	 * @param args
	 */
	private static void createArchitect(String[] args) {
		architects.add(new Architect(args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]), args[4]));
	}
	
	/**
	 * Find the architect reference in the lists
	 * @param name
	 * @return
	 */
	private static Architect findArchitect(String name) {
		for (Architect arc : architects) {
			if (arc.getName().equals(name))
				return arc;
		}
		return null;
	}
	
	/**
	 * Find the reference to an artist inside the list
	 * @param name of the artist
	 * @return Artist object.
	 */
	private static Artist findArtist(String name) {
		for (Artist artist : artists) {
			if (artist.getName().equals(name))
				return artist;
		}
		return null;
	}
	
	/**
	 * Categorise artists and architects.
	 * @param line
	 * @return True if architect or artist found or if the line is empty.
	 */
	private static boolean categoriseFirstPass(String line) {
		if (line.equals("")) {
			return true;
		}
		String[] args = line.split(",");
		switch (args[0]) {
		case "4":
			createArtist(args);
			return true;
		case "5":
			createArchitect(args);
			return true;
		default:
			return false;
		}
	}
	
	private static void createPainting(String[] args) {
		paintings.add(new Painting(args[1], decideMultiplier(args[2]), findArtist(args[3]), Double.parseDouble(args[4]), Double.parseDouble(args[5])));
	}
	
	private static void createSculpture(String[] args) {
		sculptures.add(new Sculpture(args[1], decideMultiplier(args[2]), findArtist(args[3]), decideMultiplier(args[4]), Double.parseDouble(args[5])));
	}

	private static void createArchitecture(String[] args) {
		Architecture arch = new Architecture(args[1], decideMultiplier(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]), Double.parseDouble(args[5]));
		for (int i = 5; i < args.length; i++) {
			arch.addArchitect(findArchitect(args[i]));
		}
		architectures.add(arch);
	}
	
	private static void categoriseSecondPass(String line) {
		if (line.equals("")) {
			return;
		}
		String[] args = line.split(",");
		switch(args[0]) {
		case "1":
			createPainting(args);
			break;
		case "2":
			createSculpture(args);
			break;
		case "3":
			createArchitecture(args);
			break;
		default:
			break;
		}
		
	}
	public static void readFile(String fileName) {
		ArrayList<String> lines = new ArrayList<String>();
		try {
			Scanner fileReader = new Scanner(new File(fileName));
			while (fileReader.hasNextLine()) {
				lines.add(fileReader.nextLine());
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (String line : lines) {
			if (categoriseFirstPass(line)) {
				lines.remove(line);
			}
		}
		
		for (String line : lines) {
			categoriseSecondPass(line);
		}
	}
	
	/**
	 * Return the paintings array list.
	 * @return
	 */
	public static ArrayList<Painting> getPaintings() {
		return paintings;
	}

	/**
	 * Return the sculptures array list.
	 * @return
	 */
	public static ArrayList<Sculpture> getSculptures() {
		return sculptures;
	}

	/**
	 * Return the architectures array list.
	 * @return
	 */
	public static ArrayList<Architecture> getArchitectures() {
		return architectures;
	}

	/**
	 * Return the artists array list.
	 * @return
	 */
	public static ArrayList<Artist> getArtists() {
		return artists;
	}

	/**
	 * Return the architects array list.
	 * @return
	 */
	public static ArrayList<Architect> getArchitects() {
		return architects;
	}
	
}
