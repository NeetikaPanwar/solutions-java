import java.util.*;

public class WaveArray {
    public static ArrayList<Integer> wave(ArrayList<Integer> A) {
        int i = 0, prevIndex = 0;
        boolean prevSame = false;
        Collections.sort(A);
        for(Integer a : A) {
        	System.out.print(a + "  ");
        }
        while(i < A.size()-1){
            //if((i+1) < A.size()){
            if(A.get(i) != A.get(i + 1)){
                if(!prevSame){
                    int temp = A.get(i);
                    A.set(i, A.get(i+1));
                    A.set(i+1, temp);
                    i += 2;
                }
                else{
                    
                    prevSame = false;
                    i++;
                }
            }
            //}
            else{
                if(!prevSame){
                    prevSame = true;
                    //prevIndex = i;
                }
                i++;
            }
        }
        return A;
    }
    public static void main(String[] args) {
    	ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList( 95, 19, 54, 23, 89, 60, 5, 26, 23, 6, 13, 70, 38, 94, 20, 44, 66, 34, 26, 94, 63, 38, 44, 90, 50, 59, 23, 47, 85, 17, 72, 39, 47, 85, 96, 85, 23, 20, 44, 68, 35, 15, 25, 34, 42, 11, 79, 52, 44));
    	ArrayList<Integer> result = wave(list);
    	System.out.println("-------------------------result------------------------");
    	for(Integer r: result) {
    		System.out.println(r);
    	}
    }
}
