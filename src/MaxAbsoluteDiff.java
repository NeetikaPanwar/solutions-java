import java.util.*;
public class MaxAbsoluteDiff {
    public int maxArr(ArrayList<Integer> A) {
        int maxDiff = Integer.MIN_VALUE;
        if(A.size() > 0){
        for(int i = 0; i < A.size(); i++){
            for(int j = 0; j < A.size(); j++){
                int functionValue = Math.abs(A.get(i) - A.get(j)) + Math.abs(i - j);
                if(maxDiff < functionValue){
                    maxDiff = functionValue;
                }
            }
        }
        }
        return maxDiff;
    }
}
