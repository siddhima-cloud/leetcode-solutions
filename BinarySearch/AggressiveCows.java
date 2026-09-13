/*
Aggressive Cows 
using binary Search : time complexity= O(nlogn + nlog(d))
using linear Search

*/
import java.util.Arrays;
class Solution {
    public int aggressiveCows(int[] arr, int k) {
        // code here
        
        if(arr.length<k)
        {
        return 0;
        }
        Arrays.sort(arr);
        int n = arr.length;
        int low=0, high = arr[n - 1] - arr[0];;
        int ans=0;
        
        while(low<=high)
        {
            int guess = low+(high-low)/2;
            if(findMin(arr,k,guess))
            {
                ans=guess;
                low= guess+1;
                
            }
            else
            {
                high= guess-1;
            }
        }
        
return ans;

    }
    
    static boolean findMin(int arr[], int k, int guess)
    {
        int count =1;
        int i=0, j=1;
        while(i<arr.length&& j<arr.length)
        {
            if(arr[j]-arr[i]>= guess)
            {
                count++;
                i=j;
                j++;
            }
            else
            {
                j++;
            }
            
            if(count ==k)
            {
                return true;
            }
        }
        return false;
   
    }
}