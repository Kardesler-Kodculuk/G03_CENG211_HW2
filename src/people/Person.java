package people;

import utility.Date;

public abstract class Person {
	private String name;
	private Date birthDate;
	private Date deathDate;
	private String nationality;

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
