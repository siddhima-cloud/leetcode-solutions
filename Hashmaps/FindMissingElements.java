/*
3731. Find Missing Elements
solved using hashmaps
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMissingElements {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans= new ArrayList<>();
        Map<Integer,Integer> frequency =  new HashMap<>();
        int max=nums[0], min=nums[0];
        for(int i=0;i<nums.length;i++)
        {
           max= max<nums[i]?nums[i]:max;
           min=min>nums[i]?nums[i]:min;
           frequency.put(nums[i],frequency.getOrDefault(nums[i],0)+1);
        }
        for(int i=min+1;i<max;i++)
        {
            int count= frequency.getOrDefault(i,0);
            if(count==0)
            {
                ans.add(i);
            }
        }
        return ans;
    }
    
}
