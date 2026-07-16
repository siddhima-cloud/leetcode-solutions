/*

Leetcode 242 - VALID ANAGRAMS

To solve this problem there are two ways:
1. use HashMap 
    time complexity:O(N)
    space complexity: O(N)

2.Frequenecy Array
 this is optimal solution
    time complexity= O(N)
    space complexxity= O(1)
 */
class Solution {
    public boolean isAnagram(String s, String t)
     {

        HashMap <Character,Integer> freq = new HashMap<>();
        char [] cn = s.toCharArray();
        if(s.length() != t.length())
        {
            return false;
        }
        for(char ch : cn)
        {
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
       
        char [] cm = t.toCharArray();
        for(char c : cm)
        { 
              if(!freq.containsKey(c))
            {
                return false;
            }
            int count = freq.get(c);
            freq.put(c,count-1);
            if(freq.get(c)==0)
            {
                freq.remove(c);
            }
            
        }
        return freq.isEmpty();
    }

    public static isAnagram2(String s, String t)
    {
                int n= s.length();
        int [] freq= new int[26];
        int [] freq2 = new int[26];
        boolean ans= false;
        for(int i=0;i<s.length();i++)
        {
            char st= s.charAt(i);
            freq[st]++;
        }
        for(int i=0;i<t.length();i++)
        {
            char st1= t.charAt(i);
            freq2[st1]++;
        }
        for(int i=0;i<256;i++)
        {
            if(freq[i] != freq2[i])
            {
                return false;
            }
        }
        return true;
    }
}
