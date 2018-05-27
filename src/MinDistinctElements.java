import java.util.*;
import java.lang.*;
import java.io.*;

class MinDistinctElements{
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		for(int i = 0; i < testcases; i++) {
			int arraySize = sc.nextInt();
			int[] elements = new int[arraySize];
			for(int j = 0; j < arraySize; j++) {
				elements[j] = sc.nextInt();
			}
			int m = sc.nextInt();
			getResult(elements, m);
			sc.close();
		}
	}
	
	public static void getResult(int[] array, int m) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < array.length; i++) {
			if(map.containsKey(array[i])) {
				map.put(array[i], map.get(array[i]) + 1);
			}
			else {
				map.put(array[i], 1);
			}
			if(m > array.length) {
				System.out.println(0);
				continue;
			}
		}
		
		Map<Integer, Integer> sortedMap = sortByValues(map);
		for(Iterator<Map.Entry<Integer, Integer>> it = sortedMap.entrySet().iterator(); (it.hasNext());) {
			Map.Entry<Integer, Integer> entry = it.next();
			int key = entry.getKey();
			int value = entry.getValue();
			if(value > m) {
				value = value - m;
				sortedMap.put(key, value);
			}
			else {
				m = m - value;
				it.remove();
			}
		}
		
	}
	
	public static HashMap sortByValues(HashMap map) {
		List list = new LinkedList(map.entrySet());
		//Define custom comparator here
		Collections.sort(list, new Comparator() {
			public int compare(Object obj1, Object obj2) {
				return ((Comparable)((Map.Entry)(obj1)).getValue()).compareTo(((Map.Entry)(obj2)).getValue());
			}
		});
		HashMap sortedHashMap = new LinkedHashMap();
		for(Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}
}