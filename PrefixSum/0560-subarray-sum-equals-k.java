package PrefixSum;
import java.util.*;
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