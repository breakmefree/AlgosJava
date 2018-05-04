package leet.code.easy;

public class RemoveDuplicates {
	public static int removeDuplicates(int[] nums) {
		int j =0;
        for(int i=1; i < nums.length; i++)
        {
            if(nums[j] != nums[i])
            {
                nums[++j] = nums[i];
            }
        }
	    return ++j;
	}
	
	public int strStr(String haystack, String needle) {
        if(haystack.contains(needle))
        {
            for(int i=0; i < haystack.length(); i++)
            {
                if(haystack.charAt(i) == needle.charAt(0))
                {
                    for(int j=0; j < needle.length(); j++)
                    {
                        if(!(haystack.charAt(i+j) == needle.charAt(j)))
                        {
                            break;
                        }
                        if(j == needle.length() -1)
                        {
                           return i; 
                        }
                    }
                }
            }
            
        }
        return -1;
    }
	
	public static int searchInsert(int[] nums, int target) {
        int i=0;
        for(; i < nums.length; i++)
        {
            if(target < nums[i]) {
                break;
            }
            else if(target == nums[i]) {
                return i;
            }
        }
        return i;
    }
	
	public static int compress(char[] chars) {
        if( chars == null || chars.length == 0) {
            return 0;
        }
        if(chars.length == 1) {
            return 1;
        }
        char c = chars[0];
        int count = 1;
        int j = 0;
        for(int i =1; i < chars.length; i++) {
            if(c == chars[i]) {
                count ++;
                continue;
            } else {
                if(count == 1) {
                    j++;
                } else {
                    String nums = (""+count);
                    for(int a =0; a < nums.length(); a++) {
                        chars[++j] = nums.charAt(a);
                    }
                    
                }
                count = 1;
                c = chars[i];
            }
        }
        if(count == 1) {
            j++;
        } else {
            String nums = (""+count);
            for(int a =0; a < nums.length(); a++) {
                chars[++j] = nums.charAt(a);
            }                    
        }
        return j;
    }

	public static void main(String[] args) {
		System.out.println("{'a', 'b', 'c'} " + compress(new char[] {'a', 'b', 'c'}));
		System.out.println("{'a', 'b', 'c'} " + compress(new char[] {'a', 'b', 'c'}));
		System.out.println("{'a', 'b', 'c'} " + compress(new char[] {'a', 'b', 'c'}));
		System.out.println("{'a', 'b', 'c'} " + compress(new char[] {'a', 'b', 'c'}));

		System.out.println("{'a', 'b', 'c'} " + compress(new char[] {'a', 'b', 'c'}));

//		System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 5));
//		System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 2));
//		System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 7));
//		System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 0));
//		System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 5));

	}

}
