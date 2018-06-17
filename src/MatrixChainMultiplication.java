class MatrixChainMultiplication{
	public static void main(String[] args) {
		int[] input = new int[]{2, 3, 6, 4, 5};
		int[][] M = new int[input.length - 1][input.length - 1];
		int[] row = new int[input.length - 1];
		int[] col = new int[input.length - 1];
		for(int k = 0; k < input.length; k++) {
			if(k != input.length - 1)
				row[k] = input[k];
			if(k != 0)
				col[k-1] = input[k];
		}
		int i = 0;
		int j = 0;
		int diff = 0;
		int start = 0;
		int kTaken, iTaken, jTaken;
		Integer[] indices = new Integer[3];
		//ArrayList<indices> trackingDetails = new ArrayList<indices>();
		while(i < input.length - 1 && j < input.length - 1) {
				if(i <= j) {
					if(i == j)
						M[i][j] = 0;
					else {
						int k = i;
						int min = Integer.MAX_VALUE;
						while(k < j) {
							int noOfProducts = M[i][k] + M[k+1][j] + row[i] * col[k] * col[j];
							if(noOfProducts < min) {
								min = noOfProducts;
								kTaken = k;
								iTaken = i;
								jTaken = j;
							}
							k++;
						}
						M[i][j] = min;
					}
			if(j == input.length - 2) {
				start++;
				if(start > input.length -2)
					break;
				i = 0;
				j = start;
			}
			else {
				i++;
				j++;
			}
		}
		}
		System.out.println("min no. of multiplications: " + M[0][input.length - 2]);
	}
}