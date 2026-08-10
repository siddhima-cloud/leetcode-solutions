/*
1456. Maximum Number of Vowels in a Substring of Given Length
*/
class Solution{
    public int maxVowels(String s, int k)
    {
        int low=0;
        int vowelCount=0;
        int res=0;
        for(int high=0;high<s.length();high++)
        {
            if(isVowel(s.charAt(high)))
            {
                vowelCount+=1;
            }
            if(high-low+1==k)
            {
                res=Math.max(res,vowelCount);
                if(isVowel(s.charAt(low)))
                {
                    vowelCount-=1;
                }
                low++;
            }
        }
        return   res;
    }
    private static boolean isVowel(char c)
    {
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
        {
            return true;
        }
        return false;
    }
    
}
