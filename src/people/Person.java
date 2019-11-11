package people;

import utility.Date;

public abstract class Person {
	private String name;
	private Date birthDate;
	private Date deathDate;
	private String nationality;
	
	public Person(String name, Date birthDate, Date deathDate, String nationality) {
		this.name = name;
		this.birthDate = birthDate;
		this.deathDate = deathDate;
		this.nationality = nationality;
	}
	
	public String getName() {
		return name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public Date getDeathDate() {
		return deathDate;
	}
	public String getNationality() {
		return nationality;
	}
}
