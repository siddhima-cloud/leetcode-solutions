/*
Two Sum II – Input Array Is Sorted

Problem:
Given a 1-indexed sorted array of integers numbers and an integer target, return the indices of the two numbers such that they add up to the target. Each input has exactly one solution, and the same element cannot be used twice.

Approach:
This solution uses the Two Pointers technique. Since the array is already sorted, one pointer is placed at the beginning of the array and another at the end. The sum of the two elements is calculated. If the sum equals the target, the 1-based indices are returned. If the sum is smaller than the target, the left pointer is moved to the right to increase the sum. If the sum is greater than the target, the right pointer is moved to the left to decrease the sum. This process continues until the required pair is found.

Time Complexity: O(n)

Space Complexity: O(1)

Key Concepts:

Two Pointers
Sorted Array
Greedy Pointer Movement

Example:
Input:
numbers = [2, 7, 11, 15]
target = 9

Output:
[1, 2]

Explanation:
The numbers 2 and 7 add up to 9. Since the problem uses 1-based indexing, their indices are returned as [1, 2].
*/
class solution
{
    public int[] twoSum(int[] numbers, int target)
    {
        int i=0, j= numbers.length-1;
        while(i<j)
        {
           int  sum=numbers[i]+ numbers[j];
            if(sum== target)
            {
                return new int [] {i+1,j+1};
            }
            else if(sum<target)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return new int [] {-1,-1};
    }
}