/*

643. Maximum Average Subarray I

*/
class Solution {
    public double findMaxAverage(int[] nums, int k) 
    {
        
        int low=0;
        
        double sum=0 ;
       
        double res=Integer.MIN_VALUE;
       for(int high=0;high<nums.length;high++)
       {
        sum+=nums[high];
        if(high-low+1==k)
        {
            res=Math.max(res,sum);
            sum-=nums[low];
            low++;
        }
       }
        return res/k;
    }
}

