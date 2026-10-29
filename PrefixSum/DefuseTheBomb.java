class Solution {
    public int[] decrypt(int[] code, int k) {
          int n= code.length;
          if(n==0)
          {
            return code;
          }
          if(k==0)
          {
            return code= new int[code.length];
          }
        if(k>0)
        {
          
           int[] prefixLeft= new int[n];
           prefixLeft[0]=code[0];
           for(int i=1;i<n;i++)
           {
            prefixLeft[i]= prefixLeft[i-1]+code[i];
           }

           int i=0;
           for(; i<n-k;i++)
           {
                code[i]=prefixLeft[i+k]-prefixLeft[i];
           }
           while(i<n)
           {
            code[i]=prefixLeft[n-1]-prefixLeft[i]+prefixLeft[k-(n-i-1)-1];
            i++;
           }

           return code;

        }
       
            k=k*-1;

            int[] prefix= new int[n];
            prefix[n-1]=code[n-1];
            for(int i=n-2;i>=0;i--)
            {
                prefix[i]=prefix[i+1]+code[i];
            }
            for(int i=k;i<n;i++)
            {
                code[i]= prefix[i-k]-prefix[i];
            }
            for(int i=0;i<k;i++)
            {
                code[i]=prefix[0]-prefix[i]+prefix[n-(k-i)];
            }
            return code;
       
    }
}