/*
921. Minimum Add to Make Parentheses Valid
 */
import java.util.*;
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stk = new Stack<>();
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            char c= s.charAt(i);
            if(c=='(')
            {
                count++;
                stk.push(c);
            }
            if(c ==')') {
                if(stk.isEmpty())
                {
                    count++;
                }
                else if(stk.peek()=='(')
                {
                    count--;
                    stk.pop();
                }
                else
                {
                    count++;
                }

            }
            
        }
        return count;
    }
}