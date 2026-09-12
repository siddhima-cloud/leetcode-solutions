/*
34. Find First and Last Position of Element in Sorted Array

*/
/*
Method 1:
use two binary search 
time complexity is O(log n)
 */
public class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int low =0, n = nums.length;
        int first_Index= -1;
        int last_Index= -1;
        int high = n-1;
        while(low<=high)
        {
            int mid = low +(high-low)/2;
            if(nums[mid]==target)
            {
             first_Index= mid;
                high = mid-1;
               
            }
            else if(nums[mid]<target)
            {
                low = mid +1;
            }
            else
            {
                high = mid -1;
            }
        }
        low =0;
        high = n-1;
        while(low<=high)
        {
            int mid = low +(high-low)/2;
            if(nums[mid]==target)
            {
             last_Index= mid;
                low = mid+1;
               
            }
            else if(nums[mid]<target)
            {
                low = mid +1;
            }
            else
            {
                high = mid -1;
            }
        }
      return new int [] {first_Index,last_Index};  
    }

}


/*Method 2
use 1 binary search and when element is found, expand the search to the right and to the left. LINEAR SCAN 
time complexity: O(n)
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low =0, n = nums.length;
        int high = n-1;
        while(low<=high)
        {
            int mid = low +(high-low)/2;
            if(nums[mid]==target)
            {
                int i=mid, j=mid;
                while(i>=0 && nums[i]== target)
                {
                    i--;
                }
                while(j<n&& nums[j]== target)
                {
                    j++;
                }
                return new int []{i+1,j-1};
            }
            else if(nums[mid]<target)
            {
                low = mid +1;
            }
            else
            {
                high = mid -1;
            }
        }
      return new int [] {-1,-1};  
    }
}
