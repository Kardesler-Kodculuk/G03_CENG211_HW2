package utility;

import java.util.ArrayList;
import java.util.List;

import trade.ISearchable;

public class ListHelpers {
	/**
	 * It is a bubble sort algorithm for sorting the list according to a key
	 * @param list - a list contains comparable objects
	 * @param key - a string for sorting type
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sort(List<IComparable> list, String key){
		int len = list.size();
		for(int i = 0; i < len; i++) { // i - index for main loop
			for(int j = 0; j < len - i - 2; j++) { // j - index for comparisons
				IComparable first = list.get(j);
				IComparable second = list.get(j + 1);
				if(first.compareTo(second, key) > 0) { // if first > second
					swap(list, j, j+1);
				}
			}
		}
	}
	
	/**
	 * Swaps the objects' positions with each other
	 * @param list - a list which holds comparable objects
	 * @param i1 - index of first element
	 * @param i2 - index of second element
	 */
	@SuppressWarnings("rawtypes")
	private static void swap(List<IComparable> list, int i1, int i2) {
		IComparable temp = list.get(i1);
		list.set(i1, list.get(i2));
		list.set(i2, temp);
	}
	
	// TODO comment this
	public static void extendList(List<ISearchable> resultList, ISearchable[] array) {
		for (ISearchable searchable : array) {
			resultList.add(searchable);
		}
	}
}
