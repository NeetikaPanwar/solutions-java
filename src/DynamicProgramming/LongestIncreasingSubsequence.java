package DynamicProgramming;

class LongestIncreasingSubsequence{
	public static void main(String[] args) {
		int[] arr = new int[]{3, 4, -1, 0, 6, 2, 3};
		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
		int result = obj.getLongestIncSubsequenceLength(arr);
		System.out.println(result);
	}
	public int getLongestIncSubsequenceLength(int[] arr) {
		int[] T = new int[arr.length];
		int j = 0, i, max = Integer.MIN_VALUE;
		
		for(i = 0; i < arr.length; i++)
			T[i] = 1;
		i = 1;
		
		while(i < T.length) {
			if(arr[j] < arr[i]) {
				T[i] = Math.max(T[i], T[j] + 1);
			}
			if(j+1 == i) {
				j = 0;
				i++;
			}
			else
				j++;
		}
		for(i = 0; i < T.length; i++) {
			max = (max < T[i])? T[i]: max;
		}
		return max;
	}
}