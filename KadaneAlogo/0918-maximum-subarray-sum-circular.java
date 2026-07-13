 /*
 # Maximum Sum Circular Subarray

## Problem

Given a circular integer array `nums`, return the maximum possible sum of a non-empty subarray.

A circular array means the first element comes immediately after the last element, so the subarray may wrap around the end of the array.

---

## Approach

This solution is based on **Kadane's Algorithm**.

There are two possible cases for the answer:

### Case 1: Normal Maximum Subarray

The maximum subarray does **not** wrap around the array.

Use Kadane's algorithm to find:

* `maxSum` = Maximum subarray sum.

---

### Case 2: Circular Maximum Subarray

The maximum subarray wraps around the array.

Instead of directly finding the wrapped subarray, remove the minimum-sum subarray from the total array.

```
Circular Sum = Total Sum − Minimum Subarray Sum
```

To compute this:

* Calculate the total array sum.
* Use Kadane's algorithm (modified for minimum) to find:

  * `minSum` = Minimum subarray sum.

Then,

```
answer = max(maxSum, totalSum - minSum)
```

---

## Edge Case

If every element is negative:

```
minSum == totalSum
```

Then,

```
totalSum - minSum = 0
```

which represents an empty subarray (not allowed).

Therefore, return `maxSum`.

---

## Algorithm

1. Compute the total array sum.
2. Find the maximum subarray sum using Kadane's algorithm.
3. Find the minimum subarray sum using modified Kadane's algorithm.
4. If the entire array is the minimum subarray (`minSum == totalSum`), return `maxSum`.
5. Otherwise, return:

```
max(maxSum, totalSum - minSum)
```

---

## Time Complexity

* **O(n)**

The array is traversed a constant number of times.

---

## Space Complexity

* **O(1)**

Only a few variables are used.

---

## Key Concepts

* Kadane's Algorithm
* Maximum Subarray Sum
* Minimum Subarray Sum
* Circular Arrays
* Prefix Sum Idea (Total Sum)
* Greedy Dynamic Programming

---

## Real-Life Analogy

Imagine running on a circular track while collecting coins.

You have two choices:

* Pick the richest continuous section of the track.
* Skip the poorest section and collect coins from the rest of the track by wrapping around.

The algorithm computes both possibilities and returns whichever gives more coins.

 */
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMaxSum= nums[0];
        int maxSum= nums[0];
        int currMinSum= nums[0];
        int minSum= nums[0];
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+= nums[i];
        }
        for(int i=1;i<nums.length;i++)
        {
            currMaxSum = Math.max(currMaxSum+nums[i], nums[i]);
            maxSum= Math.max(maxSum, currMaxSum);

            currMinSum= Math.min(currMinSum+nums[i],nums[i]);
            minSum= Math.min(minSum, currMinSum);
    
        }
        if(minSum== sum)
        {
            return maxSum;
        }
        else
        {
            return Math.max(maxSum,sum-minSum);
        }
        
    }
} 