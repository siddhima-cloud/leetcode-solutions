// 1002. Find Common Characters

import java.util.*;
class Solution {
    public List<String> commonChars(String[] words) {
        Map<Character,Integer> f= new HashMap<>();
        List<String> a = new ArrayList<>();
         for(int i=0;i<words[0].length();i++)
        {
            char c= words[0].charAt(i);
            f.put(c,f.getOrDefault(c,0)+1);
           
        }
        for(int i=1;i<words.length;i++)
        {
            f=freq(f,words[i]);
        }

        for(char ch: f.keySet())
        {
            String c= "";
            c+=ch;
            int count= f.get(ch);
            while(count-->0)
            {
                a.add(c);
            }
        }
        return a;
    }

    static Map<Character,Integer> freq(Map<Character,Integer> f, String s)
    {
        Map<Character,Integer> f2= new HashMap<>();
        Map<Character,Integer> ans= new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char c= s.charAt(i);
            f2.put(c,f2.getOrDefault(c,0)+1);
           
        }
        for(char c: f.keySet())
        {
            if(f2.containsKey(c))
            {
                ans.put(c,Math.min(f2.get(c),f.get(c)));
            }
        }
        return ans;
    }
}