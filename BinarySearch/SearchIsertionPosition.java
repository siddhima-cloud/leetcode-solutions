/*
35. Search Insert Position
Important point to notes is that why do we return low as the position to be inserted when the element is not found in the list.
this is because at low , everything on lefft of it is smaller than the element.

*/
class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int low=0; 
        int high = nums.length-1;
        int mid=-1;
        while(low<=high)
        {
            mid = low + (high - low) / 2;
            if(nums[mid]==target)
            {
                return mid;
            }else if(nums[mid]>target)
            {
                high= mid-1;
            }else
            {
                low=mid+1;
            }
        }
        return low;

    }
}
public class SearchIsertionPosition {
    
}
