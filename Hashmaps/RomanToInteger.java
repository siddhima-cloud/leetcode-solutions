/*
13. Roman to Integer

solved using hashmaps and two pointers.

*/
class Solution {
    public int romanToInt(String s) {
        
        Map <Character, Integer> value = new HashMap<>();
        value.put('I',1);
        value.put('V',5);
        value.put('X',10);
        value.put('L',50);
        value.put('C',100);
        value.put('D',500);
        value.put('M',1000);

        char [] c= s.toCharArray();
        int i=0, j=1;
        int number=0;
        while(i<s.length())
        {
            if(j<s.length() && value.get(c[i])<value.get(c[j]))
            {
                number+= value.get(c[j])-value.get(c[i]);
                i+=2;
                j+=2;
            }
            else
            {
                number+=value.get(c[i]);
                i++;
                j++;
            }
        }
        return number;
    }
}