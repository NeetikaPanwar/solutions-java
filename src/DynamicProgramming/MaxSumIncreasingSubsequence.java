package DynamicProgramming;

class MaxSumIncreasingSubsequence{
	public static void main(String[] args) {
		int[] arr = new int[]{1, 101, 2, 3, 100, 4, 5};
		MaxSumIncreasingSubsequence obj = new MaxSumIncreasingSubsequence();
		int maxSum = obj.getMaxSumIncreasingSubsequence(arr);
		System.out.println(maxSum);
	}
	public int getMaxSumIncreasingSubsequence(int[] arr) {
		int j = 0, i = 1, maxSum = Integer.MIN_VALUE, sum = 0;
		
		while(i < arr.length) {
			if(arr[j] < arr[i]) 
				sum += arr[j];
			
			if(j+1 == i) {
				if(sum != 0) {
					sum += arr[i];
					maxSum = (sum > maxSum)? sum: maxSum;
					sum = 0;
				}
				j = 0;
				i++;
			}
			else
				j++;
		}
		
		return maxSum;
	}
}