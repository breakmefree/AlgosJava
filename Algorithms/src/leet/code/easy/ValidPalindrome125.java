package leet.code.easy;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 * @author knidhi
 *
 */
public class ValidPalindrome125 {

	public static boolean isPalindrome(String s) {
        if(s == null || s.length() < 2) return true;
        int i = 0, j= s.length() - 1;
        s = s.toLowerCase();
        while(i < j) {
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) { 
            		i++;
            	}
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) {
            		j--;
            }
            if(i < j && s.charAt(i) != s.charAt(j)) {
            		return false;
            }
            i++;
            j--;      
            
        }
        return true;
    }
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

	}

}
