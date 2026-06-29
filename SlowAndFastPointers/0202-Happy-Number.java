/*
LeetCode: 202
Problem: Happy Number
Difficulty: Easy

Topic:
- Math
- Two Pointers
- Floyd's Cycle Detection

Approach:
Generate the next number by summing the squares of its digits.
Use Floyd's Cycle Detection:
- If the fast pointer reaches 1, the number is happy.
- If slow and fast meet before reaching 1, a cycle exists.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public static int fun(int n)
    {
        int s=0;
        while(n>0)
        {
            int d= n%10;
            n = n/10;
            s= s+d*d;
        }
        return s;
    }
    public boolean isHappy(int n) {
        if(n==1)
        {
            return true;
        }
        int slow =n;
       int fast = n;
        while(fast!=1)
        {
            slow = fun(slow);
            fast=fun(fast);
            fast=fun(fast);
            if(slow != 1 && slow == fast )
            {
                return false;
            }
        }
        return true;
    }
}