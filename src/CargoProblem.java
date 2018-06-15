import java.util.*;

class CargoProblem{
	 static ArrayList<Integer> finalCargoList = new ArrayList<Integer>();
	    static int[] findTruckCargo(int maxCargoWeight, int[][] cargoList) {
	       int length = cargoList.length;
	       int[] cargoNumber = new int[length];
	       int[] weight = new int[length];
	       int[] profit  = new int[length];
	       for(int i = 0; i < length; i++){
	                cargoNumber[i]  =  cargoList[i][0];
	                weight[i] = cargoList[i][1];
	                profit[i] = cargoList[i][2];
	                
	           }
	        int maxProfit = maximizeProfit(maxCargoWeight, weight, profit, length);
	        int resultSize = finalCargoList.size();
	        int[] result = new int[resultSize];
	        int k = 0;
	        List<Integer> listWithoutDuplicate = new ArrayList<>(new HashSet<>(finalCargoList));
	        if(listWithoutDuplicate.size() > 0){
	            for(Integer cargoNo: listWithoutDuplicate){
	                 result[k] = cargoNumber[cargoNo];
	                 k++;
	                }
	        }
	        result[k] = maxProfit;
	        return result; 
	       }
	   static int maximizeProfit(int maxCargoWeight, int[] weightArr, int[] profitArr, int length){
	       
	       if(length == 0 || maxCargoWeight == 0)
	           return 0;
	       if(weightArr[length - 1] > maxCargoWeight)
	           return maximizeProfit(maxCargoWeight, weightArr, profitArr, length-1);
	       else{
	           int p1 = profitArr[length-1] + maximizeProfit(maxCargoWeight - weightArr[length - 1], weightArr, profitArr, length-1);
	           int p2 = maximizeProfit(maxCargoWeight, weightArr, profitArr, length-1);
	           int max = Integer.MIN_VALUE;
	           if(p1 > p2){
	               max = p1;
	               int index = length-2;
	               finalCargoList.add(index);
	           }
	           else{
	               max = p2;
	               
	           }
	           return max;
	           }
	   }
	   public static void main(String[] args) {
		   int[][] arr = {{38,130,500}, {21,280,1800},{13,120,1500}};
		   int[] res = findTruckCargo(300, arr);
		   for(int i = 0; i < res.length; i++) {
			   System.out.println(res[i]);
		   }
	   }
	   
}