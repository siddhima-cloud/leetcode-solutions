 class solution
 {

    public int maxSubArray(int[] nums) 
    {

        int bestEnding = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++)
       {

            bestEnding = Math.max(bestEnding + nums[i], nums[i]);
            maxSum = Math.max(maxSum, bestEnding);

        }

        return maxSum;
    }
}