package DynamicProgramming;
import java.util.*;

class SubsetSum{
	public static void main(String[] arg) {
		int[] array = new int[]{2, 3, 7, 8, 10};
		int sum = 11;
		SubsetSum subsetSumObj = new SubsetSum();
		boolean result = subsetSumObj.subsetExists(array, sum);
		System.out.println(result);
	}
	public boolean subsetExists(int[] array, int sum) {
		boolean result = false;
		boolean[][] T = new boolean[array.length][sum + 1];
		for(int  i = 0; i < array.length; i++) {
			for(int  j = 0; j <= sum; j++) {
				if(j == 0)
					T[i][j] = true;
				else {
					if(i == 0) {
						if(array[i] == j)
							T[i][j] = true;
						else
							T[i][j] = false;
					}
					else {
						if(j < array[i]) {
							T[i][j] = T[i - 1][j];
						}
						else {
							T[i][j] = T[i - 1][j] || T[i - 1][j - array[i]];
						}
					}
				}
			}
		}
		result = T[array.length - 1][sum];
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		if(result) {
			int i = array.length - 1, j = sum;
			while(i >= 0 && j>=0) {
				if(i == 0 && j == 0)
					break;
				if(i == 0 && j > 0 && T[i][j]) {
					resultList.add(array[i]);
					break;
				}
				
				if(T[i][j] == T[i-1][j]) {
					i = i - 1;
				}
				else {
					resultList.add(array[i]);
					j = j - array[i];
					i = i - 1;
				}
			
			}
			System.out.println("Subset with sum equal to given sum is " + resultList);
		}
		return result;
	}
}