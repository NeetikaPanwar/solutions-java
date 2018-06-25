package Strings;
import java.util.*;

public class PalindromeCheck {
    public int isPalindrome(String A) {
        StringBuilder str = new StringBuilder(A);
        Stack<Character> stack = new Stack<Character>();
        int mid, i = 0, result = 1;
        
        while(i < str.length()){
            char currentChar = str.charAt(i);
            if(!(Character.isLetter(currentChar) || Character.isDigit(currentChar)))
                str.deleteCharAt(i);
            else
                i++;
        }
        
        int newStrLength = str.length();
        
        mid = newStrLength/2 - 1;
        i = 0;
        while(i <= mid){
            char currentChar = str.charAt(i);
            if(Character.isLetter(currentChar) || Character.isDigit(currentChar))
                stack.push(currentChar);
            i++;
        }
        
        if(newStrLength % 2 == 0){
            i = mid + 1;
        }
        else{
            i = mid + 2;
        }
        while(i < newStrLength){
            char strChar = str.charAt(i);
            if(Character.isLetter(strChar) || Character.isDigit(strChar)){
                char topChar = stack.pop();
                if(Character.toLowerCase(topChar) != Character.toLowerCase(strChar)){
                    result = 0;
                    break;
                }
            }
            i++;
        }
        return result;
    }
}
