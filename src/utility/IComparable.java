package utility;

public interface IComparable<T extends IComparable<? extends T>> {
	/**
	 * Compares the object with another with respect to a key
	 * @param other - other object
	 * @param key - compare according to this
	 * @return - 1 if this object bigger, 0 if they equal, -1 if other object bigger
	 * @throws IllegalArgumentException - when it takes invalid argument
	 */
	public int compareTo(T other, String key) throws IllegalArgumentException;
}
