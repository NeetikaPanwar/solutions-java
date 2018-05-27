import java.util.*;


class CustomSort{
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
			public int compare(Object entry1, Object entry2) {
				return ((Comparable)((Map.Entry)entry1).getValue()).compareTo(((Map.Entry)entry2).getValue());
			}
		});
		
		HashMap sortedMap = new LinkedHashMap();
		for(Iterator itr = list.iterator(); itr.hasNext();) {
			Map.Entry entry = (Map.Entry)itr.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		
		for(Iterator<Map.Entry<Integer, Integer>>itr = sortedMap.entrySet().iterator(); (itr.hasNext());) {
			Map.Entry<Integer, Integer> e = itr.next(); 
			System.out.print("key: " + e.getKey());
			System.out.println(" Value: " + e.getValue());
		}
	}
}