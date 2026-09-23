class Solution {
    public boolean wordPattern(String pattern, String s) {
        String [] words= s.split(" ");
        if(words.length!= pattern.length())
        {
            return false;
        }

        HashMap<String,Character > wordToChar = new HashMap<>();
        HashMap<Character,String> charToWord = new HashMap<>();
        String str ="";
         

        for(int i=0;i<pattern.length();i++)
        { 

            wordToChar.put(words[i], pattern.charAt(i));
        }

        for(int i=0;i<words.length;i++)
        {
             charToWord.put(pattern.charAt(i), words[i]);
        }

        if(charToWord.size()!=wordToChar.size())
        {
            return false;
        }

        for(int i=0;i<words.length;i++)
        {
            str+= wordToChar.get(words[i]);
        }
        
       if(str.equals(pattern))
       {
        return true;
       }
        return false;
        
    }
}