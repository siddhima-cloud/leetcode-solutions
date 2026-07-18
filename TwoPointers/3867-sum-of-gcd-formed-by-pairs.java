/*
to find gcd do not use brute force as the complexity  becomes 0(min(m,n))

use eulid's algo
int gcd(int n, int m)
    {
        int a = Math.max(n,m);
        int b= n+m-a;
        while(b!=0)
        {
            int temp= b;
            b= a%b;
            a=temp;
        }
        
        return a;


*/
class Solution {
    public long gcdSum(int[] nums) {
        long sum=0;
        int mx= nums[0];
        int[] prefixGcd= new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            mx= Math.max(mx,nums[i]);
            prefixGcd[i]= gcd(mx,nums[i]);
        }
        Arrays.sort(prefixGcd);
        int i=0, j= prefixGcd.length-1;

        while(i<j)
        {
            sum+= gcd(prefixGcd[i],prefixGcd[j]);
            i++;
            j--;
        }
        return sum;
    }

    public static int gcd(int n, int m)
    {
        int a = Math.max(n,m);
        int b= n+m-a;
        while(b!=0)
        {
            int temp= b;
            b= a%b;
            a=temp;
        }
        
        return a;
    }
}