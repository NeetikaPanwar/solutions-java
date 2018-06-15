import java.util.*;

class KnapsackDP{
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] profit = new int[] {8, 4, 0, 5, 3};
		int[] weight = new int[] {1, 2, 3, 2, 2};
		int capacity = 4;
		int[][] T = new int[profit.length][capacity+1];
		for(int i = 0; i < profit.length; i++) {
			for(int j = 0; j < capacity + 1; j++) {
				if(j == 0)
					T[i][j] = 0;
				else {
					if(j < weight[i]) {
						if(i == 0) {
							T[i][j] = 0;
						}
						else {
							T[i][j] = T[i-1][j];
							
						}
					}
					else {
						if(i == 0)
							T[i][j] = profit[i];
						else {
							T[i][j] = Math.max(T[i-1][j], profit[i] + T[i-1][j - weight[i]]);
						}
					}
				}
					
			}
				
		}
		
		for(int k=0; k <= profit.length - 1; k++) {
			for(int l = 0; l <= capacity; l++) {
				System.out.print(" element " + T[k][l]);
			}
			System.out.println();
		}
			
		int i = profit.length - 1;
		int j = capacity;
		while(i >= 0 && T[i][j] != 0) {
			if(i>0) {
			if(T[i][j] != T[i-1][j]) {
				list.add(profit[i]);
				j = j - weight[i];
			}
			i=i-1;
			}
			else if(i==0) {
			list.add(profit[i]);
			break;
		}
		
		}
		System.out.println("result" + T[profit.length - 1][capacity]);	
		System.out.println(list);

	}
}