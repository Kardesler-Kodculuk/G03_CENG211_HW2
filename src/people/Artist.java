package people;


/**
 * Reperesentation of an artist.
 */
public class Artist extends Person {
	private String[] periods;
	
	/**
	 * Insantitate an artist Object.
	 * @param name of the artist
	 * @param birthDate of the artist
	 * @param deathDate of the artist
	 * @param nationality of the artist
	 * @param periods that the artist was active during.
	 */
	public Artist(String name, int birthDate, int deathDate, String nationality, String[] periods) {
		super(name, birthDate, deathDate, nationality);
		this.periods = periods;
	}
	
	/**
	 * Get the periods artist was active in.
	 * @return
	 */
	public String[] getPeriods() {
		return periods.clone();
	} 

	@Override
	public String toString() {
		String periods = "\n\tPeriods: ";
		for (String period : this.periods) {
			periods += period + ", ";
		}
		return "Artist: \n" + super.toString() + periods.substring(0, periods.length() - 2);
	}

	@Override
	public boolean search(String querry) {
		boolean result = false;
		if(super.search(querry) || periods.toString().equals(querry)) {
			result = true;
		}
		return result;
	}
}
