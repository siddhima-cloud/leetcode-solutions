/*

2848. Points That Intersect With Cars

uses the concept of efficient ranging 
*/
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {

        int[] prefixSum= new int[102];

        for(List<Integer> num: nums){
            int left= num.get(0);
            int right= num.get(1);
            prefixSum[left]+=1;
            prefixSum[right+1]-=1;
        }
        int count=0;
        if(prefixSum[1]!=0)
        {
            count++;
        }
        for(int i=2;i<102;i++)
        {
            prefixSum[i]+=prefixSum[i-1];
            if(prefixSum[i]!=0)
            {
                count++;
            }
        }
     return count;   
    }
}