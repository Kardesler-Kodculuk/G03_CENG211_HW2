package trade;

public interface ISearchable {
	/**
	 * Searchs for the querry
	 * @param querry - searches according to querry
	 * @return - true if found, false if not
	 */
	public boolean search(String querry);
}
