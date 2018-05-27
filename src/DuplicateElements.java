import java.util.*;

class DuplicateElements{
	public static void main(String[] args) {
		findDuplicate("I am am a java learner java");
		System.out.println();
		findDuplicateChars("javaj2ee");
	}
	public static void findDuplicate(String str) {
		String[] splittedElements = str.split(" ");
		Map<String, Integer> map = new HashMap<>();
		for(String s: splittedElements) {
			if(map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			}
			else {
				map.put(s, 1);
			}
		}
		for(Iterator itr = map.entrySet().iterator(); itr.hasNext();) {
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)itr.next();
			if(entry.getValue() > 1) {
			System.out.println("String " + entry.getKey() + " is repeating " + entry.getValue() + " times.");
			
			}
		}
	}
	public static void findDuplicateChars(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < str.length(); i++) {
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			}
			else {
				map.put(str.charAt(i), 1);
			}
			
		}
		for(Iterator itr = map.entrySet().iterator(); itr.hasNext();) {
			Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>)itr.next();
			
			if(entry.getValue() > 1) {
				System.out.println("Character " + entry.getKey() + " is repeating " + entry.getValue() + " times.");
			}
		}
	}
}