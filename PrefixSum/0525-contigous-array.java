/*525. Contiguous Array

Approach

Count the number of 0s and 1s while traversing the array.
Store the difference (zeros - ones) in a HashMap.
If the same difference appears again, it means the number of 0s and 1s between those two indices is equal.
Update the maximum length of such a subarray.


Algorithm

Initialize counters for zeros, ones, and maxLength.
Traverse the array:
Increment zeros if the element is 0, otherwise increment ones.
Calculate diff = zeros - ones.
If diff == 0, the subarray from index 0 to i is balanced.
If diff is seen for the first time, store its index.
Otherwise, calculate the subarray length and update the answer.
Return the maximum length found.

Time Complexity
O(n) – Single traversal of the array.

Space Complexity
O(n) – HashMap stores the first occurrence of each difference.
Key Idea

If the same (zeros - ones) difference occurs at two indices, the subarray between them contains an equal number of 0s and 1s.
 */

class Solution {
    public int findMaxLength(int[] nums) {
        Map <Integer,Integer> f= new HashMap<>();
        int zero=0, one=0, res=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                zero++;
            }
            else
            {
                one++;
            }
            
            int diff =  zero-one;
            if(diff==0)
            {
                res= Math.max(res,i+1);
                continue;
            }

            if(!(f.containsKey(diff)))
            {
                f.put(diff,i);
            }
            else
            {
                int ind= f.get(diff);
                res= Math.max(res, i-ind);
            }

        }
        return res;
    }
}