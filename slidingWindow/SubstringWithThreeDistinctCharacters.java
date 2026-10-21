/*
1876. Substrings of Size Three with Distinct Characters
*/
import java.util.*;
class Solution {
    public int countGoodSubstrings(String s) {
        HashMap<Character,Integer> map= new HashMap<>();
        int low=0;
        int res=0;
if(s.length()<=2)
{
    return 0;
}
        for(int i=0;i<3;i++)
        {
             map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        if(map.size()==3)
        {
            res++;
        }
        for(int high=3;high<s.length();high++)
        {
            map.put(s.charAt(high),map.getOrDefault(s.charAt(high),0)+1);
           
                map.put(s.charAt(low), map.getOrDefault(s.charAt(low),0)-1);
                if(map.get(s.charAt(low))==0)
                {
                    map.remove(s.charAt(low));
                }
                low++;
                
           
            if(map.size()==3)
            {
                res++;
            }
        }
        return res;
    }
}