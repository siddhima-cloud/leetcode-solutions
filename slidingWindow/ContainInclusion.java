/*
leetcode:567. Permutation in String

what i learnt  is that for object == and .equals() behave differently and i also learnt about keySet() method
*/
import java.util.*;
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
        {
            return false;
        }
          Boolean isContainPermutation= true;
        Map<Character, Integer> freqS1= new HashMap<>();
        Map<Character, Integer> freqS2= new HashMap<>();
        for(int i=0;i<s1.length();i++)
        {
            freqS1.put(s1.charAt(i), freqS1.getOrDefault(s1.charAt(i),0)+1);
        }
        int n1= s1.length();
        int n2= s2.length();
        int low=0;
        char [] s = s2.toCharArray();
        for(int high=0;high<n2;high++)
        {
            freqS2.put(s[high], freqS2.getOrDefault(s[high],0)+1);
            while((high-low+1)>n1)
            {
                freqS2.put(s[low], freqS2.get(s[low])-1);
                if(freqS2.get(s[low])==0)
                {
                    freqS2.remove(s[low]);
                }
                low++;
            }
          isContainPermutation= true;
            for (Character val : freqS1.keySet())
            {
                if(!(freqS1.get(val).equals(freqS2.getOrDefault(val,0))))
                {
                    isContainPermutation= false;
                    break;
                }
            }
            if(isContainPermutation)
            {
                return true;
            }
        }
       return false; 
    }
}