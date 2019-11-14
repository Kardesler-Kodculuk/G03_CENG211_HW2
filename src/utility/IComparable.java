package utility;

public interface IComparable<T extends IComparable<? extends T>> {
	/**
	 * Compares the object with another with respect to a key
	 * @param other - other object
	 * @param key - compare according to this
	 * @return
	 * @throws IllegalArgumentException - when it takes invalid argument
	 */
	public int compareTo(T other, String key) throws IllegalArgumentException;
}
