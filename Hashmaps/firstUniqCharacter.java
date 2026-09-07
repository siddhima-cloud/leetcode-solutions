class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> freq= new HashMap<>();
        char [] c = s.toCharArray();
        for(char ch : c)
        {
            freq.put(ch, freq.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<c.length;i++)
        {
            if(freq.get(c[i])==1)
            {
                return i;
            }
        }
        return -1;
    }
}