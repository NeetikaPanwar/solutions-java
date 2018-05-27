import java.util.*;

public class MaxContiguousSum {
   
    public int maxSubArray(final List<Integer> A) {
        HashMap<String, Integer> map = new HashMap<>();
        int maxSum = Integer.MIN_VALUE;
        int continuous = 0;
        
        for(int k = 0; k < A.size(); k++){
            for(int i = 0; i < A.size(); i++){
                if(continuous < A.size()){
                    int startIndex = i;
                    int endIndex = i + continuous;
                    int sum = 0;
                    
                    if(endIndex < A.size()){
                        for(int j = startIndex; j <= endIndex; j++){
                            sum = sum + A.get(j);
                        }
                        if(maxSum < sum){
                        	maxSum = sum;
                            map.put("maxSum", maxSum);
                            map.put("maxLowIndex", startIndex);
                            map.put("maxHighIndex", endIndex);
                        }
                    }
                }
            }
            continuous++;
        }
        return map.get("maxSum");
    }
    public static void main(String[] args) {
    	List<Integer> list = new ArrayList<Integer>(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4));
    	
    	MaxContiguousSum  maxSumObj = new MaxContiguousSum();
    	System.out.println("Max Sum of Contiguous Subarray is: " + maxSumObj.maxSubArray(list));
    }
}

