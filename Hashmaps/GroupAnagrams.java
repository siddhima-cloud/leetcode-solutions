/*
92. Group Anagrams
*/
import java.util.*;
class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        
 /*
        METHOD 1: USING SORTING AND MAP
        
        TC: O(N) FOR TRAVERSING* O(MLOGM)FOR SORTING EACH STRING
        = 0(N*MLOGM)

        SC: 0(N*M)
        O(N): IF N DISTICT STRINGS AND NO ANAGRAM



        HashMap<String,List<String>> map= new HashMap<>();
        for(String s: strs)
        {
            char [] c= s.toCharArray();
            Arrays.sort(c);
            String key= new String(c);
            if(map.containsKey(key))
            {
                map.get(key).add(s);
            }
            else
            {
              List<String> ans=  new ArrayList<>();
              ans.add(s);
                map.put(key,ans);
            }
        }
        return new ArrayList<>(map.values());
        */


    // METHOD2: USE FREQUENCY ARRAY TO GENERATE A UNIQUE STRING MADEUP OF FREQUENCIESS IT REDUCES TIME COMPLEXITY TO O(NM)
// SC: 0(M*N)
// TC: O(M*N)

    HashMap<String, List<String>> map= new HashMap<>();
    for(String s: strs)
    {
        int[] freq= new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        String a="";
        for(int i: freq)
        {
            a+=i;
            a+="#";
        }
        String key= a;
        if(map.containsKey(key))
        {
            map.get(key).add(s);
        }
        else
        {
            List<String> ans=  new ArrayList<>();
              ans.add(s);
             map.put(key,ans);

        }
    }
    return new ArrayList<>(map.values())
       
    }
}