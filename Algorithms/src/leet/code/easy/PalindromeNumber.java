package leet.code.easy;
/**
 * 9. Palindrome Number
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author knidhi
 *
 */
public class PalindromeNumber {
	public static boolean isPalindrome(int x) 
	{
		if(x > 0 && x < 10)
			return true;
		int dev = 10;

		while((Math.abs((long)x) / dev) >= 10)
		{
			dev = dev * 10;
		}
		
		while(x!=0)
		{
			if(x < 0 || x/dev != x%10)
			{
				return false;
			}
			x /= 10;
			x -= x*10/dev * dev/10;
			
			dev /= 100;
			
		}
		
        return true;
    }
	public static void main(String[] args) 
	{
		System.out.println(isPalindrome(123454321));

		System.out.println(isPalindrome(1000021));
		System.out.println(isPalindrome(1001));
		System.out.println(isPalindrome(1));
		
		
		
		System.out.println(isPalindrome(123454321));
		System.out.println(isPalindrome(2222222));
		
		System.out.println(isPalindrome(0));
		System.out.println(isPalindrome(131));
		
		System.out.println(isPalindrome(-2147447412));
		System.out.println(isPalindrome(-2147483648));
		
	}

}
