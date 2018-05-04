package leet.code.easy;

public class Squareroot {
	
	public static int mySqrt(int x) {
        if(x == 0 || x == 1)
            return x;
        long start = 1, end = x;
        int ans=0;
        while (start <= end)
        {
            long mid = (start + end) / 2;
 
            // If x is a perfect square
            if (mid*mid == x)
                return (int)mid;
 
            // Since we need floor, we update answer when mid*mid is
            // smaller than x, and move closer to sqrt(x)
            if (mid*mid < x)
            {
                start = mid + 1;
                ans = (int)mid;
            }
            else   // If mid*mid is greater than x
                end = mid - 1;
        }
        return ans;
    }
	
	public static boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1)
            return true;
        
        long start = 1, end = num;
        while(start <= end) {
            long mid = (start + end) /2;
            if(mid * mid == num) {
                return true;
            } else if(mid * mid < num) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return false;
    }

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(104976));

		System.out.println(mySqrt(104976));
	}

}
