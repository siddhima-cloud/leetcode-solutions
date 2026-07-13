/*
# 560. Subarray Sum Equals K

## Problem Statement

Given an integer array `nums` and an integer `k`, return the total number of **continuous subarrays** whose sum equals `k`.

**LeetCode Link:** https://leetcode.com/problems/subarray-sum-equals-k/

---

## Pattern

- Prefix Sum
- HashMap (Frequency Map)

---

## Intuition

The brute-force approach checks every possible subarray and calculates its sum, resulting in **O(n²)** time complexity.

Instead, we use a **Prefix Sum** along with a **HashMap**.

As we traverse the array, we maintain the cumulative (prefix) sum. At every index, we ask:

> **Has there been a previous prefix sum equal to `currentPrefixSum - k`?**

If yes, then the elements between that previous prefix sum and the current index form a subarray whose sum is exactly `k`.

The HashMap stores the frequency of every prefix sum encountered so far, allowing us to count valid subarrays in constant time.

---

## Real-Life Analogy

Imagine keeping track of your total savings every day.

```
Day 1 : +2
Day 2 : +3
Day 3 : +1
Day 4 : +2
```

Instead of checking every group of consecutive days, you simply remember your **total savings so far**.

If your total today is **10** and your total some days ago was **7**, then you know you saved **3** during those days.

Similarly,

```
Current Prefix Sum - Previous Prefix Sum = k
```

This lets us identify valid subarrays instantly.

---

## Algorithm

1. Create a `HashMap` to store the frequency of prefix sums.
2. Insert `(0 → 1)` into the map to handle subarrays starting from index `0`.
3. Initialize:
   - `sum = 0`
   - `result = 0`
4. Traverse the array:
   - Add the current element to `sum`.
   - Calculate `required = sum - k`.
   - If `required` exists in the map, add its frequency to the answer.
   - Store/update the current prefix sum in the map.
5. Return the final answer.

---

## Dry Run

**Input**

```
nums = [1, 2, 3]
k = 3
```

Initial State

Map = {0=1}
sum = 0
result = 0

### Index 0
sum = 1
required = -2
Not found
Map = {0=1, 1=1}

### Index 1
sum = 3
required = 0
Found once
result = 1
Map = {0=1, 1=1, 3=1}
Subarray:
[1, 2]

### Index 2
sum = 6
required = 3
Found once
result = 2
Subarray:
[3]

Final Answer
2

---

## Why do we initialize the map with `(0 → 1)`?

Consider:

nums = [3]
k = 3

After processing the first element,
sum = 3
required = 0
Since the map already contains
0 → 1

we correctly count the subarray `[3]`.

Without this initialization, subarrays starting from index `0` would not be counted.

## Complexity Analysis

Time Complexity- O(n)
Space Complexity- O(n)


## Key Takeaways

- Prefix Sum helps avoid recalculating subarray sums.
- A HashMap stores the frequency of prefix sums seen so far.
- The key observation is:
Current Prefix Sum − Previous Prefix Sum = k
Rearranging,
Previous Prefix Sum = Current Prefix Sum − k

If this required prefix sum has already appeared, then every occurrence contributes one valid subarray.

This reduces the solution from **O(n²)** to **O(n)**.

*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0,1);
        int sum =0;
        int ques =0;
        int res=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+= nums[i];
            ques= sum-k;
            int f= freq.getOrDefault(ques,0);
            res+= f;
            freq.put(sum, freq.getOrDefault(sum,0)+1);
        }
        return res;
        
    }
}