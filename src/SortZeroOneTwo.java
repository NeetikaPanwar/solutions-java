class SortZeroOneTwo{
	
	public static void main(String[] args) {
		int[] input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		sortArray(input);
		for(int element: input) {
			System.out.println(element);
		}
	}
	
	public static void sortArray(int[] input) {
		int low = 0;
		int high = input.length - 1;
		int mid = 0;
		
		while(mid <= high) {
		switch(input[mid]) {
			
		case 0:
		{	int temp = input[low];
			input[low] = input[mid];
			input[mid] = temp;
			low++;
			mid++;
			break;
		}
		case 1:
		{
			mid++;
			break;
		}
		case 2:
		{
			int temp = input[mid];
			input[mid] = input[high];
			input[high] = temp;
			high--;
			break;
		}
		}
		}
		
	}
	

}