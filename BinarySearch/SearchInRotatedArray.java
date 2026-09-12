/*
33. Search in Rotated Sorted Array

*/
class Solution {
    public int search(int[] nums, int target) {
        int n= nums.length;
        int low =0;

    int high= n-1;
    int ans =-1;
    while(low<=high)
    {
            int mid = low +(high-low)/2;
            if (target == nums[mid])
               return mid;
            if(nums[low]<= nums[mid])
            {
               
                if(target<nums[mid] && target>=nums[low])
                {
                    high = mid-1;
                }
                else 
                {
                   low = mid+1;
                }
               
            }
            else
            {
                if(target>nums[mid]&& target<= nums[high])
                {
                    low= mid+1;
                }
                else 
                {
                    high = mid-1;
                }
            }

    }
     return -1;
}
}