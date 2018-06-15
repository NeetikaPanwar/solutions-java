class LongestCommonSubsequence{
	public static void main(String[] args) {
		String str1 = "abcdaf";
		String str2 = "acbcf";
		LongestCommonSubsequence obj = new LongestCommonSubsequence();
		StringBuilder longestCommonSubsequence = obj.getLongestCommonSubsequence(str1, str2);
		System.out.println(longestCommonSubsequence.reverse());
	}
	public StringBuilder getLongestCommonSubsequence(String str1, String str2) {
		int strLength1 = str1.length() + 1;
		int strLength2 = str2.length() + 1;
		int[][] L = new int[strLength1][strLength2];
		int i, j;
		for(i = 0; i < strLength1; i++) {
			for(j = 0; j < strLength2; j++) {
				if(i == 0 || j == 0)
					L[i][j] = 0;
				else {
					if(str1.charAt(i-1) == str2.charAt(j-1)) {
						L[i][j] = L[i-1][j-1] + 1;
					}
					else {
						L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
					}
				}
			}
		}
		i = strLength1 - 1;
		j = strLength2 - 1;
		StringBuilder longestSubsequence = new StringBuilder();
		while(i > 0 && j > 0) {
			if(L[i][j] != Math.max(L[i-1][j], L[i][j-1])) {
				longestSubsequence.append(Character.toString(str1.charAt(i-1)));	
				i = i -1;
				j = j - 1;
			}
			else {
				if(L[i][j] == L[i-1][j]) {
					i = i - 1;
				}
				else {
					j = j -1;
				}
			}
		}
		return longestSubsequence;
	}
}