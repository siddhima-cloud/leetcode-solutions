/*

*/
class divisorSubstring {
    public int divisorSubstrings(int num, int k) {

        String s="";
        s+=num;

        int count=0;
        int low=0;
        int high = k-1;
        while(high<s.length())
        {
            int number=  Integer.valueOf(s.substring(low,high+1));
            if(number!=0&& num%number==0)
            {
                count++;
            }
            high++;
            low++;
        }
       return count; 
    }
}