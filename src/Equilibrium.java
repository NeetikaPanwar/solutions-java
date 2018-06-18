/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Equilibrium {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcases = scan.nextInt();
		int i = 0;
		while(i < testcases){
		    int n = scan.nextInt();
		    int[] array = new int[n];
		    int sum = 0;
		    for(int j = 0; j < n; j++){
		        array[j] = scan.nextInt();
		        if(j != 0)
		            sum += array[j];
		    }
		    int result = getEquilibrium(array, sum);
		    System.out.println(result);
		    i++;
		}
	}
	public static int getEquilibrium(int[] array, int sum){
	    int prevSum, afterSum = sum, result = -1;
	    if(sum == 0)
	        result = 1;
	    else{
	        prevSum = array[0];
	        int i = 1; 
	        while(i < array.length){
	            afterSum = afterSum - array[i];
	            if(afterSum == prevSum){
	                result = i+1;
	                break;
	            }
	            else{
	                prevSum += array[i];
	            }
	            i++;
	        }
	    }
	    return result;
	}
}