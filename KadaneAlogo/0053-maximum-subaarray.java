 /*
 # 53. Maximum Subarray

## Problem Statement

Given an integer array `nums`, find the contiguous subarray with the largest sum and return its sum.

A **subarray** is a contiguous, non-empty sequence of elements within an array.

**Example 1**

```text
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6

Explanation:
The subarray [4, -1, 2, 1] has the largest sum = 6.
```

**Example 2**

```text
Input: nums = [1]
Output: 1
```

**Example 3**

```text
Input: nums = [5,4,-1,7,8]
Output: 23
```

---

## Approach

This solution uses **Kadane's Algorithm**, an efficient dynamic programming technique.

The idea is to maintain:

- **bestEnding** → Maximum subarray sum ending at the current index.
- **maxSum** → Maximum subarray sum found so far.

For each element, we decide whether to:

- Extend the previous subarray, or
- Start a new subarray from the current element.

We choose whichever gives the larger sum.

---

## Algorithm

1. Initialize:
   - `bestEnding = nums[0]`
   - `maxSum = nums[0]`
2. Traverse the array from index `1`.
3. For every element:
   - Update `bestEnding` using:
     ```java
     bestEnding = Math.max(bestEnding + nums[i], nums[i]);
     ```
   - Update:
     ```java
     maxSum = Math.max(maxSum, bestEnding);
     ```
4. Return `maxSum`.

---

## Complexity Analysis

- **Time Complexity:** `O(n)`
  - The array is traversed exactly once.

- **Space Complexity:** `O(1)`
  - Only two variables are used regardless of input size.

---

## Java Concepts Used

- Arrays
- Loops
- Variables
- Dynamic Programming
- Kadane's Algorithm
- `Math.max()`

---

## Key Learning

- Kadane's Algorithm solves the Maximum Subarray problem in linear time.
- At every index, decide whether extending the previous subarray is beneficial or starting a new one is better.
- Maintaining both the current best ending and the overall maximum allows an optimal solution.

---

## LeetCode

- **Problem Number:** 53
- **Difficulty:** Medium
- **Topic:** Arrays, Dynamic Programming, Kadane's Algorithm
*/

class solution
 {

    public int maxSubArray(int[] nums) 
    {

        int bestEnding = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++)
       {

            bestEnding = Math.max(bestEnding + nums[i], nums[i]);
            maxSum = Math.max(maxSum, bestEnding);

        }

        return maxSum;
    }
}