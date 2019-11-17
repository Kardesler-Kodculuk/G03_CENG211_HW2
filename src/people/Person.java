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
	
	/**
	 * Compares birtDates with this and other object
	 * @param otherBirthdate - a date which is int
	 * @return 1 if this bigger, 0 if they equal, -1 if other bigger
	 */
	private int compareBirthdates(int otherBirthdate) {
		int result = 0;
		if(this.birthDate < otherBirthdate) {
			result = -1;
		}
		else if(this.birthDate > otherBirthdate) {
			result = 1;
		}
		return result;
	}
	
	@Override
	public int compareTo(Person other, String key) {
		int result = 0;
		// for comparison we need lowercases of the strings
		String lowerCase = "";
		String otherLowerCase = "";
		try {
			switch(key) {
			case "name":
				lowerCase = this.name.toLowerCase();
				otherLowerCase = other.getName().toLowerCase();
				result = lowerCase.compareTo(otherLowerCase);
				break;
			case "birthday": // birthday is an int no need for lowercase
				result = this.compareBirthdates(other.getBirthDate());
				break;
			case "nationality":
				lowerCase = this.nationality.toLowerCase();
				otherLowerCase = other.getNationality().toLowerCase();
				result = lowerCase.compareTo(otherLowerCase);
				break;
			default:
				throw new InvalidParameterException();	
			}

		}
		catch(NullPointerException e) {
			throw e;
		}
		catch(ClassCastException e) {
			throw e;
		}
		return result;
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
	
	public String toStringLite() {
		return this.name;
	}
}
