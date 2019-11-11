package people;

public abstract class Person {
	private String name;
	private int birthDate;
	private int deathDate;
	private String nationality;
	
	public Person(String name, int birthDate, int deathDate, String nationality) {
		this.name = name;
		this.birthDate = birthDate;
		this.deathDate = deathDate;
		this.nationality = nationality;
	}
	
	public String getName() {
		return name;
	}
	public int getBirthDate() {
		return birthDate;
	}
	public int getDeathDate() {
		return deathDate;
	}
	public String getNationality() {
		return nationality;
	}
}
