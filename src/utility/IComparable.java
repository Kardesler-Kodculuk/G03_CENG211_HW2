package utility;

public interface IComparable<T extends IComparable<? extends T>> {
	/**
	 * Compares the object with another with respect to a key which is
	 * @param other
	 * @param key
	 * @return
	 * @throws IllegalArgumentException
	 */
	public int compareTo(T other, String key) throws IllegalArgumentException;
}
