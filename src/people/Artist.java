package people;


public class Artist extends Person {
	private String[] periods;
	
	public Artist(String name, int birthDate, int deathDate, String nationality, String[] periods) {
		super(name, birthDate, deathDate, nationality);
		this.periods = periods;
	}
	
	public String[] getPeriods() {
		return periods.clone();
	} 

	public String toString() {
		return this.getName();
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
