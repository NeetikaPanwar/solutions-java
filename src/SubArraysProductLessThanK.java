/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class SubArraysProductLessThanK {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcases = scan.nextInt();
		int i  = 0;
		while(i < testcases){
		   
		    int n = scan.nextInt();
		    int k = scan.nextInt();
		    int[] array = new int[n];
		    for(int j = 0; j < n; j++){
		        array[j] = scan.nextInt();
		    }
		    int subArrays = countSubArrays(array, k);
		    System.out.println("result" + subArrays);
		    i++;
		}
		scan.close();
	}
	public static int countSubArrays(int[] array, int k){
	    int count = 0, product = 1, subArrayLength = 0, allSubArrays = 0;
	    
	    for(int i = 0; i < array.length; i++){
	    	int[] tempArr = new int[100];
	        int curr_product = product * array[i];
	        
	        if(curr_product < k){
	        	
	            subArrayLength++;
	            product = curr_product;
	            if(i == array.length - 1)
	            	allSubArrays = allSubArrays + 1;
	        }
	        else{ 
	        	if(subArrayLength > 1){
	        		if(array[i] * array[i-1] < k)
	        			allSubArrays = allSubArrays + 1 + (subArrayLength - 1) * 3;
	        		else
	        			allSubArrays = allSubArrays + (subArrayLength - 1) * 3;
	            }
	            else if(subArrayLength == 1){
	                allSubArrays = allSubArrays + 1;
	               
	            }
	            if(array[i] < k) {
	            	subArrayLength = 1;
	            	product = array[i];
	            	if(i == array.length - 1)
		            	allSubArrays = allSubArrays + 1;
	            }
	            else {
	            	subArrayLength = 0;
	            	product = 1;
	            }
	            
	        }
	    }
	   
	    return allSubArrays;
	}
}