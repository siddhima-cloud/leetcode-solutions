class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> freq = new HashMap<>();
        HashMap<Character, Integer> ball = new HashMap<>();
        int ans= Integer.MAX_VALUE;
        for(int i=0;i<text.length();i++)
        {
            freq.put(text.charAt(i), freq.getOrDefault(text.charAt(i),0)+1);
        }
        String b= "balloon";
         for(int i=0;i<b.length();i++)
        {
            ball.put(b.charAt(i), ball.getOrDefault(b.charAt(i),0)+1);
        }
        for(char c : ball.keySet())
        {
            int available = freq.getOrDefault(c,0);
            int required = ball.get(c);
            int possible = available/ required;
            ans = Math.min(ans, possible);
        }
        if(ans == Integer.MAX_VALUE)
        {
            return 0;
        }
        return ans;
    }
}