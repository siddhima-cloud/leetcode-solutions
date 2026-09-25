class Solution {
    public int reverse(int x) {
        return rev(x,0);
       
    }

    private static int rev(int x, int r)
    {
        if(x==0)
        {
            return r;
        }
        int rem= x%10;
        x=x/10;
        if (r > Integer.MAX_VALUE / 10 ||
            (r == Integer.MAX_VALUE / 10 && rem > 7)) {
            return 0;
        }

        if (r < Integer.MIN_VALUE / 10 ||
            (r == Integer.MIN_VALUE / 10 && rem < -8)) {
            return 0;
        }

         r= r*10+rem;
         return rev(x,r);

    }
}