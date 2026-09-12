/*


*/


class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
      
      int max= piles[0];
      
      for(int j=0;j<piles.length;j++)
      {
        if(max<piles[j])
        {
            max=piles[j];
        }
      }
     
        int ans=max;
        // for(int k=1;k<=max;k++)
        // {
        //     int total_time=0;
        //     for(int j=0;j<piles.length;j++)
        //     {
        //         total_time += (int)Math.ceil(piles[j]/(double)k);
        //     }
        //    if(total_time<=h)
        //    {
        //     ans= k;
        //     break;
        //    }
        // }

        int low= 1, high= max;
        while(low<=high)
        {
            int k = low+(high-low)/2;
            long total_hours= 0;
            for(int j=0;j<piles.length;j++)
            {
                total_hours+= (long)Math.ceil(piles[j]/(double)k);

            }
            if(total_hours<=h)
            {
                ans= Math.min(ans,k);
                high=k-1;
            }
            else
            {
                low= k+1;
            }
        }
        return ans;
    }
    
    
}