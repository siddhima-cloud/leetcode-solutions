

import java.util.HashMap;
import java.util.Map;

/*
0169: Majority Element 
solved using concepts of hashmaps
 */


public class MajorityElements {
    public int majorityElement(int[] nums) {
        int n= nums.length;
        int c=n/2;
        int majorityelement=-1;
        Map<Integer,Integer> freq= new HashMap<>();
        for(int i=0;i<n;i++)
        {
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            if(freq.get(nums[i])>c)
            {
                majorityelement=nums[i];
                  return majorityelement;
            }
        }
        
        
        return majorityelement;
    }
    
}
