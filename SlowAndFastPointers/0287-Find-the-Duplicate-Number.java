/*
LeetCode: 287
Problem: Find the Duplicate Number
Difficulty: Medium

Topics:
- Floyd's Cycle Detection
- Slow and Fast Pointers

Approach:
Treat the array as a linked list where each value points to the next index.
Since one number is duplicated, a cycle is formed.
Use Floyd's Cycle Detection to find the meeting point.
Reset one pointer to index 0 and move both one step at a time.
The point where they meet again is the duplicate number.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int findDuplicate(int[] nums) {

        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}