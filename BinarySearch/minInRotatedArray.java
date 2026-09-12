/*
153. Find Minimum in Rotated Sorted Array

*/
class Solution {
    public int findMin(int[] nums) {
        int low=0; 
        int high= nums.length-1;
        int ans=-1;

        while(low<high)
        {
            int mid= low+ (high -low)/2;
            if(nums[mid]> nums[high])
            {
                ans= mid;
                low=mid+1;
               
            }
            else
            {
                 high=mid;
            }
        }
      return nums[low];  
    }
}