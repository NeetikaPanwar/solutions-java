package DynamicProgramming;
class MatrixChainMultiplication{
	static String parenthesized = "";
	static String openingBracket = "(";
	public static void main(String[] args) {
		int[] input = new int[]{2, 3, 6, 4, 5};
		int[][] M = new int[input.length - 1][input.length - 1];
		int[][] bracket  = new int[input.length - 1][input.length - 1];
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
		int start = 0;
		int kTaken = -1;;
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
							}
							k++;
						}
						M[i][j] = min;
						bracket[i][j] = kTaken;
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
		printParenthesis(bracket, 0, input.length - 2);
		System.out.println("min no. of multiplications: " + M[0][input.length - 2]);
		System.out.println(parenthesized);
	}
	public static void printParenthesis(int[][] bracket, int i, int j){
		if(i >= 0 && j >= 0) {
			int k = bracket[i][j];
			openingBracket = openingBracket + "(";
			parenthesized = openingBracket;
			for(int l = i; l <= k; l++) {
				if(parenthesized == "(")
					parenthesized = parenthesized + l;
				else
					parenthesized = parenthesized + " " + l;
			}
			parenthesized = parenthesized + ")";
			if(Math.abs(k - 0) > 1)
				printParenthesis(bracket, 0, k);
			parenthesized = parenthesized + "" + j + ")";
		}
	}
}