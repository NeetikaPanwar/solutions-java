package DynamicProgramming;

class LongestBitonicSubsequence{
	public static void main(String[] args) {
		int[] arr = new int[]{1, 11, 2, 10, 4, 5, 2, 1};
		LongestBitonicSubsequence obj = new LongestBitonicSubsequence();
		int result = obj.getLongestBitonicSubsequence(arr);
		System.out.println(result);
	}
	public int getLongestBitonicSubsequence(int[] arr) {
		int[] increasingSequence = new int[arr.length];
		int[] decreasingSequence = new int[arr.length];
	    int maxBitonicLength = Integer.MIN_VALUE;
		LongestBitonicSubsequence obj1 = new LongestBitonicSubsequence();
		
		increasingSequence = obj1.getIncreasingSequence(arr);
		decreasingSequence = obj1.getDecreasingSequence(arr);
		for(int i = 0; i < arr.length; i++) {
			int bitonicLength = increasingSequence[i] + decreasingSequence[i] - 1;
			maxBitonicLength = (maxBitonicLength < bitonicLength)? bitonicLength: maxBitonicLength;
		}
		return maxBitonicLength;
	}
	public int[] getIncreasingSequence(int[] arr) {
		int i = 1, j = 0;
		int[] increasingSequence = new int[arr.length];
		
		for(int k = 0; k < arr.length; k++)
			increasingSequence[k] = 1;
	
		while(i < increasingSequence.length) {
			if(arr[j] < arr[i]) {
				increasingSequence[i] = Math.max(increasingSequence[i], increasingSequence[j] + 1);
			}
			if(j+1 == i) {
				j = 0;
				i++;
			}
			else
				j++;
		}
		return increasingSequence;
	}
	public int[] getDecreasingSequence(int[] arr) {
		int i = arr.length - 2, j = arr.length - 1;
		int[] decreasingSequence = new int[arr.length];
		
		for(int k = 0; k < arr.length; k++)
			decreasingSequence[k] = 1;
	
		while(i >= 0) {
			if(arr[j] < arr[i]) {
				decreasingSequence[i] = Math.max(decreasingSequence[i], decreasingSequence[j] + 1);
			}
			if(j-1 == i) {
				j = arr.length - 1;
				i--;
			}
			else
				j--;
		}
		return decreasingSequence;
	}
}