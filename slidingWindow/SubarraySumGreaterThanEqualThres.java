/*
1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold*/

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int low=0;
        int sum=0;
        int res=0;
        for(int high=0;high<arr.length;high++)
        {
            sum+= arr[high];
            if(high-low+1==k)
            {
                if(sum/k>=threshold)
                {
                    res++;
                }

                sum-=arr[low];
                low++;
            }
        }
      return res;  
    }
}