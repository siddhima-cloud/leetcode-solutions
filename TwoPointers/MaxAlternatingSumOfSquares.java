class Solution {
    public long maxAlternatingSum(int[] nums) {
       
        int i=0, j= nums.length-1;
        long ans=0;

        int [] a= new  int[nums.length];
        for(int k=0;k<nums.length;k++)
        {
            a[k]= nums[k]*nums[k];
        }
         Arrays.sort(a);
        while(i<j)
        {
            ans+= a[j]-a[i];
            i++;
            j--;
           
        }
        if(i==j)
        {
            ans+= a[i];
        }
        return ans;
    }
}