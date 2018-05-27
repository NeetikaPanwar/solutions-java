import java.util.*;

class SortMapByKey{
	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(20, 100);
		map.put(15,  30);
		map.put(40, 50);
		map.put(10, 150);
		map.put(200,  170);
		map.put(150, 70);
		
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object obj1, Object obj2) {
				return ((Comparable)((Map.Entry)obj1).getKey()).compareTo(((Map.Entry)obj2).getKey());
			}
		});
		
		HashMap sortedMap = new LinkedHashMap();
		for(Iterator itr = list.iterator(); (itr.hasNext());) {
			Map.Entry entry = (Map.Entry)itr.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		
		for(Iterator<Map.Entry<Integer, Integer>> itr = sortedMap.entrySet().iterator(); (itr.hasNext());) {
			Map.Entry<Integer, Integer> entry = itr.next();
			System.out.print("Key:  " + entry.getKey());
			System.out.println("  Value:  " + entry.getValue());
		}
	}
}