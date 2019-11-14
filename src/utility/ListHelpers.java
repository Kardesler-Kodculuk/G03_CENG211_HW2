package utility;

import java.util.ArrayList;
import java.util.List;

import trade.ISearchable;

public class ListHelpers {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sort(List<IComparable> list, String key){
		int len = list.size();
		for(int i = 0; i < len; i++) { // i - index for main loop
			for(int j = 0; j < len - i - 1; j++) { // j - index for comparisons
				IComparable first = list.get(j);
				IComparable second = list.get(j + 1);
				if(first.compareTo(second, key) > 0) {
					swap(list, j, j+1);
				}
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	private static void swap(List<IComparable> list, int i1, int i2) {
		IComparable element1 = list.remove(i1);
		IComparable element2 = list.remove(i2);
		list.add(i1, element2);
		list.add(i2, element1);
	}
	
	public static void extendList(List<ISearchable> resultList, ISearchable[] array) {
		for (ISearchable searchable : array) {
			resultList.add(searchable);
		}
	}
}
