class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> rFreq= new HashMap<>();
        HashMap<Character, Integer> mFreq= new HashMap<>();

        for(char c: ransomNote.toCharArray())
        {
            rFreq.put(c,rFreq.getOrDefault(c,0)+1);
        }

         for(char c: magazine.toCharArray())
        {
            mFreq.put(c,mFreq.getOrDefault(c,0)+1);
        }
        for(char ch: rFreq.keySet() )
        {
            if(rFreq.get(ch)>mFreq.getOrDefault(ch,0))
            {
                return false;
            }
        }
        return true;

    }
}