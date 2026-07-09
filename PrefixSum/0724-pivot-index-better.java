/*
# 724. Find Pivot Index

## Problem Statement

Given an integer array `nums`, return the **pivot index** where the sum of the elements to its left equals the sum of the elements to its right. If no such index exists, return `-1`.

**LeetCode:** https://leetcode.com/problems/find-pivot-index/

---

## Pattern

- Prefix Sum
- Running Sum

---

## Intuition

Instead of calculating the left and right sums for every index (**O(n²)**), first compute the total sum of the array.

While traversing:
- Maintain a running `leftSum`.
- Compute `rightSum` as:

```
rightSum = totalSum - leftSum - nums[i]
```

If `leftSum == rightSum`, the current index is the pivot index.

---

## Algorithm

1. Compute the total sum of the array.
2. Initialize `leftSum = 0`.
3. Traverse the array:
   - Calculate `rightSum = totalSum - leftSum - nums[i]`.
   - If `leftSum == rightSum`, return the current index.
   - Update `leftSum += nums[i]`.
4. Return `-1` if no pivot index exists.

---

## Example

**Input**

```
nums = [1,7,3,6,5,6]
```

**Output**

```
3
```

**Explanation**

```
Left Sum  = 1 + 7 + 3 = 11
Right Sum = 5 + 6 = 11
```

Since both sums are equal, index `3` is the pivot index.

---

## Complexity

| Time | Space |
|------|-------|
| **O(n)** | **O(1)** |

---

## Key Takeaways

- Compute the total sum only once.
- Maintain a running left sum.
- Calculate the right sum in constant time.
- Reduce the brute-force **O(n²)** approach to **O(n)**.
*/
class Solution {
    public int pivotIndex(int[] nums) 
    {
        int left=0, right=0,sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        if(left == sum-nums[0])
        {
            return 0;
        }
        for(int i=1;i<nums.length;i++)
        {
            left= left +nums[i-1];
            right = sum-left-nums[i];
            if(left ==right)
            {
                return i;
            }
        }
        return -1;
    }
}
