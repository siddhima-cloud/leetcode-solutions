/*
904-Fruits into basket is a sliding window problem and usees hashmap.
 beacuse we have to find he maxmimum length of subarray
general template for sliding window is

    include high in info.
    check if info is incorrect; if incorrect remove low from info,recalculatee info,increaese low.
    if info is correct include in ans.

*/
class Solution {
    public int totalFruit(int[] fruits) {
       int high =0,low=0,res=-1,len=0;
       Map<Integer,Integer> freq= new HashMap<>();
       for(high=0;high<fruits.length;high++)
       {
        freq.put(fruits[high],freq.getOrDefault(fruits[high],0)+1);
        while(freq.size()>2)
        {
            len= high-low+1;
            freq.put(fruits[low],freq.get(fruits[low])-1);
            if(freq.get(fruits[low])==0)
            {
                freq.remove(fruits[low]);
            }
            low++;
        }
        len= high-low+1;
        res=Math.max(len,res);
       }
    return res;
    }
}

