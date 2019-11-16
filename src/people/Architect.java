package people;


public class Architect extends Person {

	/**
	 * Initiate an architect.
	 * @param name Name of the architect.
	 * @param birthDate Date of the architect's birth.
	 * @param deathDate Date of the architect's death.
	 * @param nationality Nationality of the architect.
	 */
	public Architect(String name, int birthDate, int deathDate, String nationality) {
		super(name, birthDate, deathDate, nationality);
	}
	
	@Override
	public String toString() {
		return "Architect: \n" + super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
}
