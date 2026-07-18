/*
leetcode-986 Interval list Intersection
use two pointer 
intution: sorted+ two arrays+ merge

*/
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) 
    {
        int i=0,j=0,s1,s2,e2,e1;
        int n= firstList.length;
        int m= secondList.length;
        List<int[]> list = new ArrayList<>();
        while(i<n && j<m)
        {
            s1= firstList[i][0];
            e1= firstList[i][1];
            s2 = secondList[j][0];
            e2= secondList[j][1];
            int start= Math.max(s1,s2);
            int end = Math.min(e1,e2);
            if(start<= end)
            {
                list.add(new int[]{start,end});
            }
        
         if(e1<e2)
            {
                i++;
            }
            else
            {
                j++;
            }
        
        }
        int k= list.size();
        return list.toArray(new int [k][]);
        
    }
}