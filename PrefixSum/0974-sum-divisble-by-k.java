/*
# 0974. Subarray Sums Divisible by K

## Problem
Given an integer array `nums` and an integer `k`, return the number of **non-empty subarrays** whose sum is divisible by `k`.

## Approach

This problem uses the **Prefix Sum + HashMap** pattern.

## Algorithm

1. Create a `HashMap` to store the frequency of each remainder.
2. Initialize the map with `(0 → 1)` to handle subarrays starting from index `0`.
3. Traverse the array:

   * Update the running prefix sum.
   * Compute `remainder = prefixSum % k`.
   * If the remainder is negative, add `k` to make it positive.
   * Add the frequency of the current remainder to the answer.
   * Increment the frequency of the current remainder in the map.
4. Return the total count.

## Why Negative Remainders?
Java's `%` operator can produce negative remainders.

Example:
-2 % 5 = -2

To keep remainders in the range [0, k-1]:
if (remainder < 0) {
    remainder += k;
}
This ensures equivalent remainders are grouped correctly.

## Complexity Analysis
* Time Complexity: O(n)
* Space Complexity: O(min(n, k))

## Pattern Used
* Prefix Sum
* HashMap (Frequency Counting)
* Modular Arithmetic

## Key Takeaway
Two prefix sums having the **same remainder when divided by `k`** imply that the subarray between them has a sum divisible by `k`. The HashMap efficiently tracks how many times each remainder has appeared, allowing all valid subarrays to be counted in a single pass.

*/
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map <Integer, Integer> freq = new HashMap<>();
        int sum=0,res=0;
        freq.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            sum+= nums[i];
            int check = sum%k ;
            if(check<0)
            {
                check+=k;
            }
            int f= freq.getOrDefault(check,0);
            res+= f;
            freq.put(check,freq.getOrDefault(check,0)+1);

        }
        return res;
        
    }
}