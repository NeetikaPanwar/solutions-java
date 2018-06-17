class SubArrayWithGivenSum{
	public static void main(String[] args) {
		int[] array = new int[] {1, 2, 3, 7, 5};
		int expectedSum = 12, sum = 0, l = 0;
		boolean found = false;
		for(int i = 0; i < array.length; i++) {
			if(sum < expectedSum)
				sum += array[i];
			while(sum > expectedSum) {
				sum -= array[l];
				l++;
			}
			if(sum == expectedSum) {
				int end = i+1;
				System.out.println(l+1 + " " + end);
				found = true;
				break;
			}
		}
		if(!found)
			System.out.println(-1);
	}
}