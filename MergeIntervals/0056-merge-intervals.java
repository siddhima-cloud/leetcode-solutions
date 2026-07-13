/*
# Merge Intervals (LeetCode 56)

## Problem Statement

Given an array of intervals where `intervals[i] = [start, end]`, merge all overlapping intervals and return an array of the non-overlapping intervals.

##Example

Input:
intervals = [[1,3],[2,6],[8,10],[15,18]]

Output:
[[1,6],[8,10],[15,18]]


## Approach

1. **Sort** all intervals by their starting point.
2. Initialize the first interval as the current interval.
3. Traverse the remaining intervals:

   * If the current interval overlaps with the next interval (`currentEnd >= nextStart`), merge them by updating the ending point.
   * Otherwise, store the current interval in the result and move to the next interval.
4. Add the last merged interval to the result.
5. Return only the filled portion of the result array.


## Algorithm

* Sort intervals based on the start value.
* Keep track of the current merged interval using `start1` and `end1`.
* For each interval:

  * If overlapping, update `end1 = max(end1, end2)`.
  * Otherwise, save the current interval and start a new one.
* Store the final interval after the loop.
* Return the result array trimmed to the correct size using `Arrays.copyOf()`.


## Time Complexity

* Sorting: O(n log n)
* Traversal: O(n)

Overall:O(n log n)

## Space Complexity

* Result array: O(n)
* Extra space (excluding output):O(1)


## Key Concepts

* Sorting
* Interval Merging
* Greedy Algorithm
* Arrays

*/
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int row= intervals.length;
        int start1= intervals[0][0];
        int end1= intervals[0][1];
        int index =0;
        int [][]ans = new int[row][2];
        for(int i=1;i<row;i++)
        {
            int start2= intervals[i][0];
            int end2= intervals[i][1];
            if(end1>=start2)
            {
                start1=start1;
                end1 = Math.max(end1,end2);
                continue;
            }
            else
            {
                ans[index][0]= start1;
                ans[index][1]=end1;
                start1= start2;
                end1= end2;
                index++;
            }
        }
        ans[index][0]= start1;
        ans[index][1]= end1;

        return Arrays.copyOf(ans,index+1);
        
    }
}