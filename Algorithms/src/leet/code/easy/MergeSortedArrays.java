package leet.code.easy;

import java.util.Arrays;

public class MergeSortedArrays {
	public static void merge(Integer[] nums1, int m, Integer[] nums2, int n) {
		if(nums2 == null || n < 1)
            return;
        
        int n1 = m-1;
        int n2 = n-1;
        int i;
        for(i = m+n-1; i > -1; i --)
        {
        		if(n2 < 0 || n1 < 0)
                break;
            if(nums1[n1] >= nums2[n2])
            {
                nums1[i] = nums1[n1--];
            }
            else
            {
                nums1[i] = nums2[n2--];
            }
            
        }
        for(; n1 > -1; n1--)
        {
            nums1[i--] = nums1[n1];
        }
        
        for(; n2 > -1; n2--)
        {
            nums1[i--] = nums2[n2];
        }
    }
	public static int removeDuplicates(int[] nums) {
        int j =0, dup=0;
        for(int i=1; i < nums.length; i++)
        {
            if(dup == 0 && nums[j] != nums[i])
            {
                j++;
            } else if(nums[j] == nums[i]) {
                dup = 1;
            }
            if(dup == 1 && nums[j] != nums[i])
            {
                dup = 0;
                nums[++j] = nums[i];
            }
        }
        return ++j;
    }
	public static void main(String[] args) {
		Integer[] nums1 = new Integer[1];
		nums1[0] = 0;
//		nums1[1] = 2;
//		nums1[2] = 3;
//		nums1[3] = 4;
//		nums1[4] = 5;

		int m = 0;
		Integer[] nums2 = new Integer[]{6};
		int n = 1;
		merge(nums1, m, nums2, n);
		System.out.println(Arrays.asList(nums1));
		
		
	}

}
