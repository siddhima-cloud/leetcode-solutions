import java.util.*;
class PalindromePermuatation{
    public static boolean palindromePermuatation(String s)
    {
        int[] freq= new int[128];
        for(int i=0;i<s.length();i++)
        {
            int c=s.charAt(i);
            freq[c]++;
        }
        int ch=0;
        for(int i=0;i<freq.length;i++)
        {
            ch+= freq[i]%2;       
         }

        return ch<=1;
       }

       
    
    static boolean palindromicPermutationUsingSet(String s)
    {

        HashSet<Character> st= new HashSet<>();
        for(char c: s.toCharArray())
        {
            if(st.contains(c))
            {
                st.remove(c);
            }
            else{
                st.add(c);
            }
        }
        return st.size()<=1;
    }

    public static void main(String[] args)
       {
        String s="abdccabbdbaac";
       if(palindromicPermutationUsingSet(s))
         System.out.println("Palindromic");
        else
            System.out.println("Not");
       }
}

