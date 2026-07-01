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