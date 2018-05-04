package leet.code.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
 * @author knidhi
 *
 */
public class LetterCombinationsofaPhoneNumber {

	public static List<String> letterCombinations(String digits) {
        Map<Character, String> numLet = new HashMap<>();
        numLet.put('2', "abc");
        numLet.put('3', "def");
        numLet.put('4', "ghi");
        numLet.put('5', "jkl");
        numLet.put('6', "mno");
        numLet.put('7', "pqrs");
        numLet.put('8', "tuv");
        numLet.put('9', "wxyz");
        
        List<String> result = new ArrayList<>();
        if(digits == null || digits.isEmpty())
        {
        		return result;
        }
        result.add("");
        
        for(int i = 0; i < digits.length(); i++) {
        		List<String> im = new ArrayList<>();
        		String alpha = numLet.get(digits.charAt(i));
        		for(int j = 0; j < alpha.length(); j++) {
        			for(String st : result) {
        				im.add(st + alpha.charAt(j));
        			}
        		}
        		result = im;
        }
        
        
        return result;
        
    }
	
	public static List<String> letterCombinations(int sizecomb, List<String> arr) {
		List<String> result = new ArrayList<>();
		if(sizecomb < 1)
			return result;
		else if(sizecomb == 1)
			return arr;
		else if(sizecomb > arr.size())
			return result;
		
		result.add("");
		
		for(int i = 0; i < sizecomb; i++) {
    			List<String> im = new ArrayList<>();
    			for(String arrStr : arr) {
    				for(String st : result) {
    					if(!st.isEmpty() && st.contains(arrStr))
        					continue;
    					im.add(st + arrStr);
    				}
    			}
    			result = im;
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<String> result = new ArrayList<>();
		result.add("1");
		result.add("2");
		result.add("3");
		result.add("4");
		//result.add("5");
	
		System.out.println(letterCombinations(4, result));
		//System.out.println(letterCombinations("23"));

	}

}
