package people;

import java.security.InvalidParameterException;

import trade.ISearchable;
import utility.IComparable;

public abstract class Person implements IComparable<Person>, ISearchable{
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
	
	@Override
	public boolean search(String querry) {
		boolean result = false;
		if(querry.equals(this.name) || querry.equals(new Integer(birthDate).toString())
				|| querry.equals(new Integer(deathDate).toString()) 
				|| querry.equals(this.nationality)) {
			result = true;
		}
		return result;
	}
	
	@Override
	public int compareTo(Person other, String key) {
		try {
			if(key.equals("name")) {
				return this.name.toLowerCase().compareTo(other.getName().toLowerCase());
			}
			else if(key.equals("birthDate")) {
				if(this.birthDate < other.getBirthDate()) {return -1;}
				else if(this.birthDate > other.getBirthDate()) {return 1;}
				else {return 0;}
			}
			else if(key.equals("nationality")) {
				return this.nationality.compareTo(other.getNationality());
			}
			else {
				throw new InvalidParameterException();
			}

		}
		catch(NullPointerException e) {
			throw e;
		}
		catch(ClassCastException e) {
			throw e;
		}
	}
	
	@Override
	public String toString() {
		String str = "";
		str += "\tBirth Date: " + this.birthDate 
				+ "\n\tDeath Date: " + this.deathDate 
				+ "\n\tName: " + this.name 
				+ "\n\tNationality: " + this.nationality;
		return str;
	}

	@Override
	public boolean equals(Object obj) {
		return this.name.equals(obj);
	}
}
