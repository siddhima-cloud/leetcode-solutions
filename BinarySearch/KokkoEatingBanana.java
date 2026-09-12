/*
875. Koko Eating Bananas

the commented part is first method in which we linearly search for minium speed starting from last.
but that is insufficient approach because it takes O(n^2) times

the next part is optimized solution using binary search.
we have perfformed binary search because it is monotic . 
for example if k=10 works than all the values<k , such as 6,7,8,9 are wrong and all the values>k are right/valid. so this showss that this is monotonic and hence binary earch can be applied.

and remember we have take the total_hours as long to prevent Integer Overflow.

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