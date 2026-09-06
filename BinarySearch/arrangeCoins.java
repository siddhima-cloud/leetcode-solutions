/*
441. Arranging Coins
*/

class Solution {
    public int arrangeCoins(int n) {
        int i=1;
        int ans=0;
        while(i<=n)
        {
          ans++;
          n-=i ;
          i++;
        }
       return ans; 
    }
}