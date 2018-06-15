import java.util.*;
class MergeSortedArray{
	public static void main(String[] args) {
		int[] array1 = {2, 4, 6, 8, 10};
		int[] array2 = {3, 6, 9, 12, 15};
		
		ArrayList<Integer> result = mergeArrays(array1, array2);
	
		for(Integer mergedElement: result) {
			System.out.println(mergedElement);
		}
	}
	public static ArrayList<Integer> mergeArrays(int[] array1, int[] array2) {
		int arrayLength1 = array1.length;
		int arrayLength2 = array2.length;
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int k = 0, i = 0, j = 0;
		int remainingStartIndex = -1, remainingEndIndex = -1;
		while(i < arrayLength1 && j < arrayLength2) {
			
			if(array1[i] == array2[j]) {
				result.add(array1[i]);
				i++;
				j++;
			}
			else{
				if(array1[i] < array2[j]) {
				result.add(array1[i]);
				i++;
				}
				else {
				result.add(array2[j]);
				j++;
			}
			}
			
		}
		if(i < arrayLength1) {
			remainingStartIndex = i;
			remainingEndIndex = arrayLength1;
		}
		else if(j < arrayLength2) {
			remainingStartIndex = j;
			remainingEndIndex = arrayLength2;
		}
		while(remainingStartIndex < remainingEndIndex) {
			if(i == remainingStartIndex) {
				result.add(array1[remainingStartIndex]);
			}
			else {
				result.add(array2[remainingStartIndex]);
			}
			remainingStartIndex++;
		}
			
		return result;
	}
}