import java.util.*;

public class MaxDiff {
    public static int maxArr(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxIndex = -1;
        int minIndex = -1;
        int maxDiff = 0;
        if(A.size() > 0){
        for(int i = 0; i < A.size(); i++){
            if(max < A.get(i)){
                max = A.get(i);
                maxIndex = i;
            }
            if(min > A.get(i)){
                min = A.get(i);
                minIndex = i;
            }
            if(min == A.get(i)) {
            	int existingDiff = Math.abs(maxIndex - minIndex);
            	if(existingDiff < Math.abs(maxIndex - i)) {
            		minIndex = i;
            	}
            }
            if(max == A.get(i)) {
            	int existingDiff = Math.abs(maxIndex - minIndex);
            	if(existingDiff < Math.abs(i - minIndex)) {
            		maxIndex = i;
            	}
            }
        }
        if(Math.abs(max - min) > A.size() - 1){
            maxDiff = Math.abs(max - min) + Math.abs(maxIndex - minIndex);
            System.out.println("maxdiff  " + maxDiff);
            System.out.println("max index "+ maxIndex);
            System.out.println("min index "+ minIndex);
            int low = 0;
            int high = A.size() - 1;
            while(low < A.size() && high < A.size() && low != high && low >= 0 && high >=0){
                int diff = Math.abs(A.get(high) - A.get(low)) + Math.abs(high - low);
                if(diff > maxDiff){
                    maxDiff = diff;
                }
                if(Math.abs(A.get(low)) < Math.abs(A.get(high)))
                    low++;
                else
                    high--;
            }
        }
        else{
            maxDiff = Math.abs(A.get(A.size() - 1) - A.get(0)) + A.size() - 1;
        }
        }
        return maxDiff;
    }
    public static void main(String[] args) {
    	ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(-2, -41, -68, -32, -25, -9, -96, -43, 1, 90, 74, -97, 64, 10, -48, -3, -100, 86, 43, -12, 80, 21, 78, -13, 35, -35, -56, 64, 12, -48, 55, 77, 36, -82, -84, 73, -64, -72, 7, -53, 52, -37, -3, 74, -32, -83, -35, -64, -61, 28));
    	int result = maxArr(list);
    	System.out.println("result " + result);
    }
}
