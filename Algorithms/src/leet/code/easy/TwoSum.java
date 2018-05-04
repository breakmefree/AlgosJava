package leet.code.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> numIndex = new HashMap<>();
        
        for(int i=0; i < nums.length; i++)
        {            
            int compli = target - nums[i];
            Integer index = numIndex.get(compli);
            if(index != null && i != index)
                return new int[]{index, i};
            
            numIndex.put(nums[i], i);

        }
        
        return null;
    }

	public static void main(String[] args) {
		int[] nums = new int[] {2, 3, 7}; //{3,3,1} - 3 //{2,7,9} -9 { 1,2,3} -8
		int target = 9;
		int[] num = twoSum(nums, target);
		System.out.println("----------");
		System.out.println(num.length + " - " + num[0] + ", " + num[1]);
	}

}
