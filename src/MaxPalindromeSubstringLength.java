/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class MaxPalindromeSubstringLength {
    public static HashMap<Integer, ArrayList<PalindromeIndex>> allPalDetails = new HashMap<Integer, ArrayList<PalindromeIndex>>();
	
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcases = scan.nextInt();
		scan.nextLine();
		for(int i = 0; i < testcases; i++){
			int maxLength = Integer.MIN_VALUE;
			int maxStart = 0;
			int maxEnd = 0;
		    String input = scan.nextLine();	
		    //String[] inputSeq = input.split(" ");
		    int maxPalLength = getLongestPalindromeLength(input);
		    System.out.println("max pal length" + maxPalLength);
		    if(maxPalLength == 1)
		    	System.out.println(input.charAt(0));
		    else {
		    	ArrayList<PalindromeIndex> result = allPalDetails.get(maxPalLength);
		    	//System.out.println();
		    	
		    	char[] longestPalindrome = new char[maxPalLength];
		    	input.getChars(result.get(0).start, result.get(0).end+1, longestPalindrome, 0);
		    	System.out.println(longestPalindrome);
		    }
		  
		}
	    scan.close();
	}
	public static int getLongestPalindromeLength(String input){
	    int inputSize = input.length();
	    int maxPalLength = 0;
	    if(inputSize > 0){
	        maxPalLength = 1;
	        int start = 1;
	        ArrayList<PalindromeIndex> palListEven = new ArrayList<PalindromeIndex>();
	        ArrayList<PalindromeIndex> palListOdd = new ArrayList<PalindromeIndex>();
	        
	        palListEven = checkPalindromeOfLength(input, 2);
	        palListOdd = checkPalindromeOfLength(input, 3);
	        if(palListEven.size() > 0 && palListOdd.size() > 0)
	        	maxPalLength = 3;
	        else if(palListEven.size() > 0)
	        	maxPalLength = 2;
	        else if(palListOdd.size() > 0)
	        	maxPalLength = 3;
	        if(palListEven.size() > 0){
	        	maxPalLength = 2;
	            int i = 4;
	            while(i <= inputSize){
	                ArrayList<PalindromeIndex> palListTemp = new ArrayList<PalindromeIndex>();
	                palListTemp = checkPalindromeOfLength(input, i);
	                if(palListTemp.size() > 0){
	                    i+=2;
	                }
	                 else{
	                    maxPalLength = maxPalLength > (i-2)? maxPalLength: i-2;
	                    break;
	                }
	            }
	        }
	        if(palListOdd.size() > 0){
	        	
	            int i = 5;
	            while(i <= inputSize){
	                ArrayList<PalindromeIndex> palListTemp = new ArrayList<PalindromeIndex>();
	                palListTemp = checkPalindromeOfLength(input, i);
	                if(palListTemp.size() > 0){
	                    i+=2;
	                }
	                else{
	                	
	                    maxPalLength = maxPalLength > (i-2)? maxPalLength: (i-2);
	                    break;
	                }
	            }
	        }
	       
	        
	    }
	    
	    return maxPalLength;
	}
	
	public static ArrayList<PalindromeIndex> checkPalindromeOfLength(String input, int length){
	    
	    int inputLength = input.length();
	  
	    ArrayList<PalindromeIndex> list = new ArrayList<PalindromeIndex>();
	    
	    if(length == 2){
	        for(int i = 0; i < inputLength-1; i++){
	            if(input.charAt(i) == input.charAt(i + 1)){
	                list.add(new PalindromeIndex(i, i+1));
	            }
	        }
	        allPalDetails.put(2, list);
	    }
	    else if(length == 3){
	        for(int i = 1; i < inputLength - 1; i++){
	            if(input.charAt(i-1) == input.charAt(i+1)){
	                list.add(new PalindromeIndex(i-1, i+1));
	            }
	        }
	        allPalDetails.put(3, list);
	    }
	    else{
	    	boolean found = false;
	        ArrayList<PalindromeIndex> prevList = allPalDetails.get(length-2);
	        if(prevList.size() > 0) {
	        for(PalindromeIndex onePalindrome: prevList){
	        	if(onePalindrome.start-1 < inputLength && onePalindrome.end+1 < inputLength && onePalindrome.start-1 >= 0 &&  onePalindrome.end+1 >= 0) {
	        		
	            if(input.charAt(onePalindrome.start-1) == input.charAt(onePalindrome.end+1)){
	            	found = true;
	            	System.out.println("came to update  for higher number");
	                list.add(new PalindromeIndex(onePalindrome.start-1, onePalindrome.end+1));
	            }
	        	}
	        }
	        if(found)
	        	allPalDetails.put(length, list);
	        }
	    }
	    return list;
	}
}
class PalindromeIndex{
    int start;
    int end;
    public PalindromeIndex(int start, int end){
        this.start = start;
        this.end = end;
    }
}