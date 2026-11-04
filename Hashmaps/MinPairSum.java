/*
    1877. Minimize Maximum Pair Sum in Array
*/
import java.util.HashMap;
import java.util.Map;

public class MinPairSum {
    
    public int minPairSum(int[] nums) {
        /*
        Approach 1= using sorting 
        TC: O(NLOGN)
        Arrays.sort(nums);
        int max=0;
        int n=nums.length;
        for(int i=0;i<n/2;i++)
        {
            int sum= nums[i]+nums[n-i-1];
            max= Math.max(sum,max);
        }
        return max;
        */
        int max=1,min=Integer.MAX_VALUE;
        int n= nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            max= Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }

        int res=0;
        int i=min;
        int j=max;
        while(i<=j)
        {
            if(freq.getOrDefault(i,0)==0)
            {
                i++;
            }
            else if(freq.getOrDefault(j,0)==0)
            {
                j--;
            }
            else
            {
                res= Math.max(res,i+j);
                freq.put(i,freq.get(i)-1);
                freq.put(j,freq.get(j)-1);

            }
        }
        return res;
    }

    
}
