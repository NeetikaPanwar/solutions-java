import java.util.*;
public class MaxSubArray {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("maxSum", 0);
        map.put("lowIndex", 0);
        map.put("highIndex", 0);
        
        int lowIndex = 0;
        int highIndex = 0;
        int sum = 0;
        boolean continuous = false;
        boolean negativeContinue = false;
        boolean positiveOccurred = false;
        
        for(int i = 0; i < A.size(); i++){
            if(A.get(i) < 0 ){
                if(i != 0){
                    if(!negativeContinue && continuous){
                        sum = 0;
                    }
                    negativeContinue = true;
                    continuous = false;
                }
            }
            else{
                if(sum >= 0)
                    sum = sum + A.get(i);
                
                highIndex = i;
                negativeContinue = false;
                if(!continuous){
                    lowIndex = i;
                    continuous = true;
                }
                if(sum < 0){
                    map.put("maxSum", Integer.MAX_VALUE);
                    map.put("lowIndex", lowIndex);
                    map.put("highIndex", highIndex);
                }
                else if(map.get("maxSum") < sum){
                        
                        map.put("maxSum", sum);
                        map.put("lowIndex", lowIndex);
                        map.put("highIndex", highIndex);
                }
                else {
                if(map.get("maxSum") == sum){
                    int recordedLength = map.get("highIndex") - map.get("lowIndex") + 1;
                    if(recordedLength < (highIndex - lowIndex + 1)){
                        map.put("lowIndex", lowIndex);
                        map.put("highIndex", highIndex);
                    }
                    else if(recordedLength == (highIndex - lowIndex + 1)){
                        if(lowIndex < map.get("lowIndex")){
                            map.put("lowIndex", lowIndex);
                            map.put("highIndex", highIndex);
                        }
                    }
                }}
                positiveOccurred = true;
            }
            
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(map.size() > 0 && A.size() > 0 && positiveOccurred){
        for(int i = map.get("lowIndex"); i <= map.get("highIndex"); i++){
            list.add(A.get(i));
        }
        }
        return list;
    }
}
