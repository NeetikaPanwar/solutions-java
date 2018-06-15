/*package whatever //do not write package name here */

import java.util.*;

class SecondRepeatedStr {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcases = scan.nextInt();
		int i = 0;
		
		while(i < testcases){
		    
		    int n = scan.nextInt();
		    String[] array  = new String[n];
		    for(int j = 0; j < n; j++){
		        array[j] = scan.next();
		    }
		    getSecondRepeatedStr(array);
		  i++;
		}
		scan.close();
	}
	public static void getSecondRepeatedStr(String[] arr){
	    HashMap<String, Integer> map = new HashMap<>();
	    for(int i = 0; i < arr.length; i++){
	        if(map.containsKey(arr[i])){
	            map.put(arr[i], map.get(arr[i]) + 1);
	        }
	        else{
	            map.put(arr[i], 1);
	        }
	    }
	    List list = new LinkedList(map.entrySet());
	    Collections.sort(list, new Comparator(){
	        public int compare(Object obj1, Object obj2){
	            return ((Comparable)((Map.Entry)obj1).getValue()).compareTo(((Map.Entry)obj2).getValue());
	        }
	    });
	    Map.Entry result = (Map.Entry<String, Integer>)list.get(list.size() -2);
	    System.out.println(result.getKey());
	}
}