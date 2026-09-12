public class Solution {
    public int findPeakElement(int[] nums) {
          int low =0; 
        int high = nums.length-1;
        int ans =-1;
        while(low<high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid]>nums[mid+1])
            {
                ans= mid;
                
                high= mid;
            }
            else
            {
                low= mid+1;
            }
        }
        return high;
        
        
    }
} {
    
}
