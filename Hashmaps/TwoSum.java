/*
1. Two Sum

*/
import java.util.*;
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

       /*
       METHOD 1: BRUTE FORCE
        TC: O(n^2)
        SC: O(1)
        int n= nums.length;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    return new int[]{i,j};
                }
            }
        }
      return new int[]{-1,-1};
      */

   /*  Method 2: HASHMAP IN TWO PASS
     TC: O(2n)
        SC: O(n)
     
      HashMap<Integer,Integer> mp= new HashMap<>();
      for(int i=0;i<nums.length;i++)
      {
        mp.put(nums[i],i);
      }

      for(int i=0;i<nums.length;i++)
      {
        int complement= target-nums[i];
        if(mp.containsKey(complement))
        {
           int j= mp.get(complement);
           if(j!=i)
           return new int []{i,j};

        }
      }
      return new int []{-1,-1};

      */
        /* METHOD 3: HASHMAP IN ONE PARSE
        TC: O(n)
        SC: O(n)
        
        HashMap<Integer,Integer> mp= new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int complement= target-nums[i];
            if(mp.containsKey(complement))
            {
                return new int[]{i,mp.get(complement)};
            }
            mp.put(nums[i],i);
        }
return new int []{-1,-1};
*/

// METHOD 4: TWO POINTERS + PRE SORTING



    }
}