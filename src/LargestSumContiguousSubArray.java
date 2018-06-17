class LargestSumContiguousSubArray{
	public static void main(String[] args) {
		LargestSumContiguousSubArray obj = new LargestSumContiguousSubArray();
		int[] input = new int[] {-2, -3, 4, -1, -2, 1, 5, -3};
		int maxContiguousSum = obj.findLargestContiguousSum(input);
		System.out.println(maxContiguousSum);
	}
	public int findLargestContiguousSum(int[] array) {
		int maxSoFar = 0, maxEndingHere = 0;
		for(int i = 0; i < array.length - 1; i++) {
			maxEndingHere += array[i];
			if(maxEndingHere < 0)
				maxEndingHere = 0;
			if(maxSoFar < maxEndingHere)
				maxSoFar = maxEndingHere;
		}
		return maxSoFar;
	}
}