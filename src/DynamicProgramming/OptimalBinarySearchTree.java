package DynamicProgramming;
class OptimalBinarySearchTree{
	int[][] rootDetails;
	public static void main(String[] args) {
		int[] keys = new int[]{10, 12, 16, 21};
		int[] freq = new int[]{4, 2, 6, 3};
		OptimalBinarySearchTree obj = new OptimalBinarySearchTree();
		int result = obj.getOptimalCost(keys, freq);
		System.out.println(result);
		//obj.printTree(keys, 0, keys.length - 1);
	}
	public int getOptimalCost(int[] keys, int[] freq) {
		int[][] T = new int[freq.length][freq.length];
		rootDetails = new int[freq.length][freq.length];
		int i = 0, j = 0, start = 0;
		while(i < freq.length && j < freq.length) {
			if(i == j) {
				T[i][j] = freq[i];
				rootDetails[i][j] = keys[i];
			}
			else {
				int k, sum = 0, min = Integer.MAX_VALUE;
				for(k = i; k <= j; k++) {
					sum += freq[k];
				}
				k = i;
				int root = -1;
				while(k <= j) {
					if(k == i) {
						if(min > T[k+1][j]) {
							min = T[k+1][j];
							root = k;
						}
					}
					else {
						if(k - 1 < freq.length && k + 1 < freq.length) {
						int cost = T[i][k - 1] + T[k + 1][j];
						if(min > cost) {
							min = cost;
							root = k;
						}
						}
					}
					k++;
				}
				T[i][j] = sum + min;
				rootDetails[i][j] = root;
			}
			if(j == freq.length - 1) {
				i = 0;
				start++;
				j = start;
			}
			else {
				i++;
				j++;
			}
		}
		return T[0][freq.length - 1];
	}
//	public void printTree(int[] keys, int l, int r) {
//		int rootIndex = rootDetails[l][r];
//		System.out.println(keys[rootIndex]);
//		printTree(keys, l, r - 1);
//		printTree(keys, r + 1, );
//		rootDetails[0][rootIndex - 1];
//		rootDetails[rootIndex + 1][0];
//	}
}