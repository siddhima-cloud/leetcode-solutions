/*
# 977. Squares of a Sorted Array

## Problem Statement

Given an integer array `nums` sorted in **non-decreasing order**, return an array of the squares of each number, also sorted in **non-decreasing order**.

**Example 1**

```text
Input: nums = [-4, -1, 0, 3, 10]
Output: [0, 1, 9, 16, 100]
```

**Example 2**

```text
Input: nums = [-7, -3, 2, 3, 11]
Output: [4, 9, 9, 49, 121]
```

---

## Approach

### Method 1 (Merge-Based Approach)

1. Count the number of negative elements.
2. Square the negative and non-negative parts separately.
3. Reverse the squared negative part because squaring changes its order.
4. Merge the two sorted arrays into the final result.

**Complexity**

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

Although correct, this approach requires multiple arrays and additional processing.

---

### Method 2 (Optimal - Two Pointers)

This solution uses the **Two Pointers** technique.

Observation:

- The largest square always comes from either the leftmost negative number or the rightmost positive number.
- Compare the squares of both ends.
- Place the larger square at the end of the answer array.
- Move the corresponding pointer inward.
- Continue until all elements are processed.

This avoids reversing and merging arrays.

---

## Algorithm

1. Create an answer array of size `n`.
2. Initialize:
   - `left = 0`
   - `right = n - 1`
   - `index = n - 1`
3. While `left <= right`:
   - Compute the squares of both ends.
   - Place the larger square at `answer[index]`.
   - Move the corresponding pointer.
   - Decrement `index`.
4. Return the answer array.

---

## Complexity Analysis

### Method 1

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

### Method 2 (Optimal)

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

---

## Java Concepts Used

- Arrays
- Two Pointers
- Loops
- Conditional Statements
- Array Traversal

---

## Key Learning

- Squaring negative numbers changes their order.
- Since the input array is already sorted, the largest square must be at one of the two ends.
- The **Two Pointers** technique allows the problem to be solved in a single traversal without sorting.
- Filling the result array from **right to left** ensures the output remains sorted.

---

## Dry Run

Input:

```text
nums = [-4, -1, 0, 3, 10]
```

| Left Square | Right Square | Chosen | Result Position |
|-------------|--------------|--------|-----------------|
| 16 | 100 | 100 | ans[4] |
| 16 | 9 | 16 | ans[3] |
| 1 | 9 | 9 | ans[2] |
| 1 | 0 | 1 | ans[1] |
| 0 | 0 | 0 | ans[0] |

Final Output:

```text
[0, 1, 9, 16, 100]
```

---

## LeetCode

- **Problem Number:** 977
- **Difficulty:** Easy
- **Topic:** Arrays, Two Pointers

*/

class Solution {
    public int[] sortedSquares(int[] nums) {
    //   method 1:
    //   int k=0;
    //     for(int i=0; i<nums.length;i++)
    //     {
    //         if(nums[i]<0)
    //         {
    //              k++;
    //         }
            
    //     }
    //     if(k==0)
    //    {
    //         int a[] = new int[nums.length];
    //         for(int i=0;i<nums.length;i++)
    //         {
    //             a[i] = nums[i]*nums[i];
    //         }
    //         return a;
    //    } 
       
    //   else if(k==nums.length)
    //    {
    //     int b[] = new int[nums.length];
    //     for(int i=0; i<k;i++)
    //     {
    //         b[i] = nums[i]*nums[i];
    //     }
    //     int i=0, j= nums.length-1;
    //     while(i<j)
    //     {
    //         int temp = b[i];
    //         b[i]= b[j];
    //         b[j]= temp;
    //         i++;
    //         j--;
    //     }
    //     return b;
    //    }
    //    else
    //    {
    //     int n= nums.length;
    //     int a[]= new int[k];
    //     int b[] = new int[n-k];
    //     int i, j=0,p;
    //     for(i=0;i<k;i++)
    //     {
    //         a[i] = nums[i] *nums[i];
    //     }
    //     for(i=k;i<n;i++)
    //     {
    //         b[j] = nums[i]*nums[i];
    //         j++;
    //     }
    //      i=0;
    //       j=k-1;
    //     while(i<j)
    //     {
    //         int temp = a[i];
    //         a[i]= a[j];
    //         a[j]= temp;
    //         i++;
    //         j--;
    //     }
    //     i=0;
    //      j=0;
    //     p = n-k;
    //     int l=0;
    //     int temp[]= new int[n];

    //     while(i<k && j<p)
    //     {
    //         if(a[i]<b[j])
    //         {
    //             temp[l]= a[i];
    //             i++;
    //             l++;
    //         }
    //         else if(a[i]>b[j])
    //         {
    //             temp[l]= b[j];
    //             j++;
    //             l++;
    //         }
    //         else
    //         {
    //             temp[l]= a[i];
    //             i++;
    //             l++;
    //             temp[l]= b[j];
    //             j++;
    //             l++;
    //         }
    //     }
    //     while(i<k)
    //     {
    //          temp[l]= a[i];
    //             i++;
    //             l++;
    //     }
    //     while(j<p)
    //      {
    //             temp[l]= b[j];
    //             j++;
    //             l++;
    //         }
    //     return temp;
    //    }
   

    //  method 2
    int n= nums.length;
     int [] ans = new int [n];
    int k=n-1;
    int i=0;
    int j=n-1;
    while(i<=j)
    {
        int leftSquare= nums[i]*nums[i];
        int rightSquare = nums[j]*nums[j];
        if(leftSquare > rightSquare)
        {
            ans[k]= leftSquare;
            k--;
            i++;

        }
        else
        {
            ans[k]= rightSquare;
            k--;
            j--;
        }
    }
    
    return ans;
    }
}