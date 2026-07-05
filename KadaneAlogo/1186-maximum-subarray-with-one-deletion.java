/*
# Maximum Subarray Sum with One Deletion

## Problem

Given an integer array `arr`, return the maximum sum of a **non-empty** subarray when you are allowed to **delete at most one element** from the chosen subarray.

The subarray must remain non-empty after the deletion.

---

## Approach

This problem is an extension of **Kadane's Algorithm**.

While traversing the array, maintain two states:

* **Without Deletion:** The maximum subarray sum ending at the current index without deleting any element.
* **With One Deletion:** The maximum subarray sum ending at the current index after deleting exactly one element.

For each element:

* Update the maximum subarray sum without deletion by either extending the previous subarray or starting a new one.
* Update the maximum subarray sum with one deletion by either:

  * deleting the current element, or
  * extending a subarray where one deletion has already been used.

At every step, keep track of the maximum value obtained from both states.

---

## Algorithm

1. Initialize the variables for:

   * Maximum subarray sum without deletion.
   * Maximum subarray sum with one deletion.
   * Overall maximum answer.
2. Traverse the array from left to right.
3. Update both states for each element.
4. Update the overall maximum answer.
5. Return the final result.

---

## Time Complexity

* **O(n)**

The array is traversed only once.

---

## Space Complexity

* **O(1)**

Only a constant amount of extra space is used.

---

## Key Concepts

* Dynamic Programming
* Kadane's Algorithm
* State Transition
* Maximum Subarray Sum
* Constant Space Optimization

*/ 
class Solution {
    public int maximumSum(int[] arr) {
        int oneDelete = 0;
        int noDelete = arr[0];
        int res = arr[0];
        for(int i=1;i<arr.length;i++)
        {      int prevOneDelete;
            int prevNoDelete = noDelete;
            if(oneDelete ==  0 )
            {
                prevOneDelete= arr[0];
            }  
            else
            {
                prevOneDelete= oneDelete;
            } 
            noDelete= Math.max(noDelete+arr[i], arr[i]);         
            oneDelete=  Math.max(prevNoDelete,prevOneDelete+ arr[i]);
            res= Math.max(res,Math.max(noDelete, oneDelete));
        }
        return res;
        
    }
} 
