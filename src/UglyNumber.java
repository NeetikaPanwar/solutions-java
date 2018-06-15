class UglyNumber{
	public static void main(String[] args) {
		int n = 150;
		UglyNumber obj = new UglyNumber();
		int nthUglyNumber = obj.getNthUglyNumber(n);
		System.out.println(nthUglyNumber);
	}
	
	public int getNthUglyNumber(int n) {
		int i = 0, i2 = 0, i3 = 0, i5 = 0;
		int[] uglyNumbers = new int[n]; 
		uglyNumbers[0] = 1;
		
		while(i < n-1) {
			int nextMultipleOf2 = uglyNumbers[i2] * 2;
			int nextMultipleOf3 = uglyNumbers[i3] * 3;
			int nextMultipleOf5 = uglyNumbers[i5] * 5;
			uglyNumbers[i+1] = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
			
			if(uglyNumbers[i+1] == uglyNumbers[i2] * 2)
				i2++;
			if(uglyNumbers[i+1] == uglyNumbers[i3] * 3)
				i3++;
			if(uglyNumbers[i+1] == uglyNumbers[i5] * 5)
				i5++;
			i++;
		}
		return uglyNumbers[i];
	}
	
}