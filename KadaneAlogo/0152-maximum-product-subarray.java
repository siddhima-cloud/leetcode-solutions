/*
# 152. Maximum Product Subarray

## Problem Statement

Given an integer array `nums`, find the contiguous non-empty subarray within the array that has the largest product and return the product.

A **subarray** is a contiguous sequence of elements within an array.

**Example 1**

```text
Input: nums = [2,3,-2,4]
Output: 6

Explanation:
The subarray [2,3] has the largest product = 6.
```

**Example 2**

```text
Input: nums = [-2,0,-1]
Output: 0

Explanation:
The result cannot be 2 because [-2,-1] is not a contiguous subarray.
```

---

## Approach

This solution uses **Dynamic Programming**.

Unlike the Maximum Subarray problem (Kadane's Algorithm), the product of numbers behaves differently because:

- Multiplying by a **negative number** can turn the largest product into the smallest.
- Multiplying two **negative numbers** can produce the largest positive product.

Therefore, at every index we maintain:

- **maxEnding** → Maximum product ending at the current index.
- **minEnding** → Minimum product ending at the current index.

For every element, we consider three possibilities:

1. Start a new subarray from the current element.
2. Extend the previous maximum product.
3. Extend the previous minimum product.

The answer is the maximum value of `maxEnding` seen throughout the traversal.

---

## Algorithm

1. Initialize:
   - `maxEnding = nums[0]`
   - `minEnding = nums[0]`
   - `ans = nums[0]`
2. Traverse the array from index `1`.
3. For each element:
   - Compute:
     - Current element
     - Current element × previous maximum product
     - Current element × previous minimum product
   - Update:
     - `maxEnding`
     - `minEnding`
   - Update the overall answer.
4. Return `ans`.

---

## Complexity Analysis

- **Time Complexity:** `O(n)`
  - The array is traversed once.

- **Space Complexity:** `O(1)`
  - Only a few variables are used.

---

## Java Concepts Used

- Arrays
- Loops
- Dynamic Programming
- Variables
- `Math.max()`
- `Math.min()`

---

## Key Learning

- Product problems require tracking both the maximum and minimum products because a negative number can reverse their roles.
- Maintaining two running values allows the problem to be solved in linear time.
- This is an extension of Kadane's Algorithm for multiplication instead of addition.

---

## Dry Run

Consider:

```text
nums = [2, 3, -2, 4]
```

| Index | Number | maxEnding | minEnding | Answer |
|------:|--------|----------:|----------:|-------:|
| 0 | 2 | 2 | 2 | 2 |
| 1 | 3 | 6 | 3 | 6 |
| 2 | -2 | -2 | -12 | 6 |
| 3 | 4 | 4 | -48 | 6 |

Final Answer:

```text
6
```

---

## LeetCode

- **Problem Number:** 152
- **Difficulty:** Medium
- **Topic:** Arrays, Dynamic Programming
*/
class Solution {
    public int maxProduct(int[] nums) {
        int maxending = nums[0];
        int minending = nums[0];
        int ans = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int n1 = nums[i];
            int n2= maxending*nums[i];
            int n3 = minending*nums[i];
            maxending = Math.max(n1,Math.max(n2,n3));
            minending = Math.min(n1,Math.min(n2,n3));
            ans = Math.max(ans,Math.max(minending, maxending));
        }
        return ans;

        
    }
}