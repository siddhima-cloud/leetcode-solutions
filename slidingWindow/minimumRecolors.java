/*
2379. Minimum Recolors to Get K Consecutive Black Blocks*/

class Solution {
    public int minimumRecolors(String blocks, int k) {

        Map<Character,Integer> colourFreq= new HashMap<>();
        int low=0;
        int ans= Integer.MAX_VALUE;
        for(int high=0;high<blocks.length();high++)
        {
            colourFreq.put(blocks.charAt(high),colourFreq.getOrDefault(blocks.charAt(high),0)+1);

            while(high-low+1>k)
            {
                 colourFreq.put(blocks.charAt(low),colourFreq.getOrDefault(blocks.charAt(low),0)-1);

                 if(colourFreq.getOrDefault(blocks.charAt(low),0)==0)
                 {
                    colourFreq.remove(blocks.charAt(low));
                 }
                 low++;
            }

            if((high-low+1)==k)
            {
                int toChange= colourFreq.getOrDefault('W',0);
                ans=Math.min(toChange,ans);
            }
        }
        return ans;
    }
}