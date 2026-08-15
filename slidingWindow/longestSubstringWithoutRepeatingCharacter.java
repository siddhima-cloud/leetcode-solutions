/*
3. Longest Substring Without Repeating Characters
Approach:
[Pattern- Sliding Window]
the idea is  firstly form a window 
include the freq of character at high
then check whether the size of current window and the size frquency map is same or not.
if(the size of the window is greater than the size of frequency map  ) it means there is a duplicate charcter
then remove the element at low position unless the window size and the map size becomes the same.
and when thn happens calculate the len and if it is larger than previous one than store it in the result.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> freq=new HashMap<>();
        int low=0,  res=0;
        char[] c= s.toCharArray();
        for(int high=0;high<s.length();high++)
        {
                freq.put(c[high],freq.getOrDefault(c[high],0)+1);
                if(freq.size()< (high-low+1))
                {
                    freq.put(c[low],freq.getOrDefault(c[low],0)-1);
                    if(freq.get(c[low])==0)
                    {
                        freq.remove(c[low]);
                    }
                    low++;
                }
                res=Math.max(res,high-low+1);
        }
        return res;
    }
}