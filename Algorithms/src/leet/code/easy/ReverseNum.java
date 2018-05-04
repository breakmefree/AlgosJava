package leet.code.easy;

/**
 * 7. Given a 32-bit signed integer, reverse digits of an integer.
 * Input: 123
 * Output:  321
 * Example 2:
 * 
 * Input: -123
 * Output: -321
 * Example 3:
 * 
 * Input: 120
 * Output: 21
 * 
 * @author knidhi
 *
 */
public class ReverseNum {
	
	public static int reverse(int x)
	{
        long rev = 0;
        while(x != 0)
        {
        		rev = rev * 10 + x % 10;
        		x = x/10;
        }
        if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
        {
        		return 0;
        }
        return (int) rev;
    }

	public static void main(String[] args)
	{
		int num = -1534236469;
		System.out.println(num + " : " + reverse(num));

	}

}
