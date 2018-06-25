package DynamicProgramming;
class CoinChanging{
	public static void main(String[] args) {
		int[] coins = new int[]{7, 2, 3, 6};
		int total = 13;
		CoinChanging coinChangingObj = new CoinChanging();
		coinChangingObj.solveCoinChangingProblem(coins, total);
	}
	public void solveCoinChangingProblem(int[] coins, int total) {
		int[] T = new int[total + 1];
		int[] trace = new int[total + 1];
		for(int i = 0; i <= total; i++) {
			if(i == 0) {
				T[i] = 0;
				trace[i] = -1;
				continue;
			}
			T[i] = Integer.MAX_VALUE;
			trace[i] = -1;
		}
		
		for(int j = 0; j < coins.length; j++){
			for(int i = 0; i <= total; i++) {
				if(i >= coins[j]) {
					if(T[i - coins[j]] < Integer.MAX_VALUE) {
						if(1 + T[i - coins[j]] < T[i]) {
							T[i] = 1 + T[i - coins[j]];
							trace[i] = j;
						}
					}
				}
				
			}
		}
		System.out.println("Number of coins required: " + T[total]);
		System.out.print("The coins required are: ");
		while(total > 0) {
			System.out.print(coins[trace[total]] + " ");
			total = total - coins[trace[total]];
			if(total == 0)
				break;
		}
	}
}