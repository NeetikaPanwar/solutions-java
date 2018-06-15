import java.util.*;
class NobleInteger{
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(-4, 2, 8, 9, -5, -10, -8, 7, 2, -2, -9, 7, -3, -1, 7, -1, 8, -2, 9, 8, 0, -5, 2, -10, -8, 4, 3, -3, -7, -10, 0, -9, -5, -2, -10, 0, -10, 4, -3, -5, -7, -9, 4, -8, 0, 1, -7, -10, -10, 4, 8, -8, 2, 0, -8, 4, -5, -2, 4, -10, -2, -6, -8, -5, -6, -8, -3, -5, 7, 5, -8, 2, -2, 6, -4, 0, -10, -1, 1, 2, 6, -1, 4, -2, 2, -2, -8, 7, -2, 6, 7 ));
		Collections.sort(list);
		for(Integer i: list) {
			System.out.println(i);
		}
		int result = solve(list);
		System.out.println("result======" + result);
	}
	public static int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        boolean found = false;
        for(int i = 0; i < A.size(); i++){
        	
            if(A.get(i) >= 0){
            	int k = i + 1; 
            	while(k < A.size()) {
            		if(A.get(i) == A.get(k))
            			k++;
            		else
            			break;
            	}
            	int start = k;
            
            int lastIndex = start + A.get(i) - 1;
          
            if(lastIndex == (A.size() - 1)){
                found = true;
                break;
            }
            }
        }
        if(found)
            return 1;
        else
            return -1;
    }
}
