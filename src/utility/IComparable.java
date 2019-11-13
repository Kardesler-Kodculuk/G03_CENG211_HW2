package utility;

public interface IComparable<T extends IComparable<? extends T>> {
	public int compareTo(T other, String key) throws IllegalArgumentException;
}
