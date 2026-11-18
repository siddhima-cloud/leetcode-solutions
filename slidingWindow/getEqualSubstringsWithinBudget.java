/*
1208. Get Equal Substrings Within Budget
*/
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {

        int maxLen=0;
        int cost=0;
        int low=0;
        for(int high=0;high<s.length();high++)
        {
            int currCost= s.charAt(high)- t.charAt(high);
            cost+= Math.abs(currCost);
            while(cost>maxCost)
            {
                 int c= s.charAt(low)- t.charAt(low);
            cost-= Math.abs(c);
            low++;
            }

            if(cost<=maxCost)
            {
                maxLen= Math.max(maxLen,high-low+1);
            }
        }
       return maxLen; 
    }
}