/*
Maximum Absolute Sum of Any Subarray
Problem

Given an integer array nums, return the maximum absolute sum of any (possibly empty) subarray.

The absolute sum of a subarray is defined as:

[
|nums[l] + nums[l+1] + \dots + nums[r]|
]

Approach

The maximum absolute subarray sum can come from:

the largest positive subarray sum, or
the smallest (most negative) subarray sum.

Therefore, during one traversal of the array, we maintain:

maxEnding → Maximum subarray sum ending at the current index.
minEnding → Minimum subarray sum ending at the current index.

At every index:

Update the maximum subarray sum using Kadane's Algorithm.
Update the minimum subarray sum similarly.
Compare:
maximum positive sum
absolute value of the minimum (negative) sum

The larger of these becomes the answer.

Algorithm
Initialize:
    maxEnding = nums[0]
    minEnding = nums[0]
    answer = abs(nums[0])
Traverse the array from index 1.
Update:
    maxEnding = max(maxEnding + nums[i], nums[i])
    minEnding = min(minEnding + nums[i], nums[i])
Update the answer with:
   max(maxEnding, abs(minEnding))
Return the final answer.
Example

Input- nums = [1, -3, 2, 3, -4]
Maximum positive subarray= [2, 3]
Sum = 5
Minimum (most negative) subarray=[-3]
Sum = -3
Absolute Sum = 3

Answer
5

Time Complexity- O(n),Only one traversal of the array is required.

Space Complexity- O(1), Only a few extra variables are used.

Key Concepts
Kadane's Algorithm
Dynamic Programming
Maximum Subarray Sum
Minimum Subarray Sum
Greedy Traversal

*/
class Solution {
    public int maxAbsoluteSum(int[] nums)
    {
        if(nums.length == 0)
        {
            return 0;
        }
        
        int maxending = nums[0];
        int minending = nums[0];
        int ans = Math.abs(nums[0]);
       
        for(int i=1; i<nums.length;i++)
        {   maxending=  Math.max(maxending+nums[i], nums[i]);
            minending = Math.min(minending+nums[i], nums[i]);
           int  abs_minending = Math.abs(minending);
            ans = Math.max(ans,Math.max(maxending, abs_minending));
        }
        return ans;

        
    }
}