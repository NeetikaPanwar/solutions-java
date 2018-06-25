package math;

import java.util.ArrayList;

class FindPrimeForSumN{
	public static void main(String[] args) {
		int n = 10;
		FindPrimeForSumN checkPrime = new FindPrimeForSumN();
		ArrayList<Integer> result = checkPrime.findElements(n);
		System.out.println(result);
	}
	public ArrayList<Integer> findElements(int n){
		ArrayList<Integer> result = new ArrayList<Integer>();
		FindPrimeForSumN obj = new FindPrimeForSumN();
		for(int i = 2; i <= n; i++) {
			if(obj.isPrime(i) && obj.isPrime(n-i)) {
				result.add(i);
				result.add(n-i);
				return result;
			}
		}
		return result;
	}
	public boolean isPrime(int n) {
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0)
				return false;
		}
		return true;
	}
}