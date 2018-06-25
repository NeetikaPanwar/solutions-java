package search;
class AdjacentDiff1{
	public static void main(String[] args) {
		int[] input = new int[]{-1, -2, -3, -2, -1, 0, 1, 2};
		AdjacentDiff1 obj = new AdjacentDiff1();
		System.out.println(obj.search(input, 1));
	}
	public int search(int[] input, int elementToSearch) {
		int i = 0, resultIndex = -1;
		while(i < input.length) {
			if(input[i] == elementToSearch) {
				resultIndex = i;
				break;
			}
			int diff = Math.abs(input[i] - elementToSearch);
			i += diff;
		}
		return resultIndex;
	}
}