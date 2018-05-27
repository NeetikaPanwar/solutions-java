class ArrangeArray{
public static void main(String[] arg){
	int[] array = new int[8];
	array[0] = -1;
	array[1] = 20;
	array[2] = 30;
	array[3] = -3;
	array[4] = -8;
	array[5] = 100;
	array[6] = -90;
	array[7] = 70;
	for(int j = 0; j < array.length; j++){
		if(j%2 == 0 && array[j] < 0) {
			replaceWithPositive(j, array);
		}
		if(j%2 == 1 && array[j] > 0) {
			replaceWithPositive(j, array);
		}
		
	}
	
	for(int j = 0; j < array.length; j++){
		System.out.println(array[j]);
	}

}
public static void replaceWithPositive(int index, int[] array) {
	
	while(index < array.length) {
	if(array[index + 1] > 0) {
		int temp = array[index];
		array[index] = array[index + 1];
		array[index + 1] = temp;
		break;
	}
	else {
		index++;
	}
	}
}


public static void replaceWithNegative(int index, int[] array) {
	while(index < array.length) {
		if(array[index + 1] < 0) {
			int temp = array[index];
			array[index] = array[index + 1];
			array[index + 1] = temp;
			break;
		}
		else {
			index++;
		}
		}
}
}