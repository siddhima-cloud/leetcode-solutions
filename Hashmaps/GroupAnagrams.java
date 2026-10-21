/*
92. Group Anagrams
*/
import java.util.*;
class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        

        Map <String, List<String> >mp= new HashMap<>();
        for(String s: strs)
        {
            char [] c= s.toCharArray();
            Arrays.sort(c);
            if(mp.containsKey(new String(c)))
            {
                mp.get(new String(c)).add(s);
            }
            else
            {
                List<String> list= new ArrayList<>();
                list.add(s);
                mp.put(new String(c),list);
            }
        }
        return new ArrayList<>(mp.values());   

       
    }
}