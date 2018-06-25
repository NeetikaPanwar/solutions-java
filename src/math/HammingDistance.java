package math;
import java.util.*;
public class HammingDistance {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int hammingDistance(final List<Integer> A) {
        int length = A.size(), sum = 0;
        if(length < Integer.MAX_VALUE){
        int[][] T = new int[length][length];
        int i = 0, j = 0, start = 0;
        while(i < length && j < length){
            if(i == j)
                T[i][j] = 0;
            else{
                T[i][j] = Integer.bitCount(A.get(i) ^ A.get(j));
                sum += T[i][j];
            }
            if(j == length - 1){
                i = 0;
                start++;
                j = start;
            }
            else{
                i++;
                j++;
            }
        }
        }
        return sum*2;
    }
    
}
