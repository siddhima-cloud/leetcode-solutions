class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int row= intervals.length;
        int[][] ans= new int[row+1][2];
        boolean insert = false;
        int j=0;
        for(int i=0;i<row;i++)
        {   
             int start= intervals[i][0];
             int end =intervals[i][1];
            if(insert == false && newInterval[0]<= intervals[i][0])
            {
                ans[j][0]= newInterval[0];
                ans[j][1]= newInterval[1];
                j++;
                insert = true;
            }
            ans[j][0]= start;
            ans[j][1]= end;
            j++;
            
        }

        if(!insert)
        {
                ans[j][0]= newInterval[0];
                ans[j][1]= newInterval[1];
                j++;
        }


        int [][] finans= new int [ans.length][2];
        int ind=0;
        int s1 = ans[0][0];
        int e1= ans[0][1];
        for(int  k =1;k<ans.length;k++)
        {
            int s2= ans[k][0];
            int e2= ans[k][1];
            if(s2<= e1)
            {
                s1= s1;
                e1= Math.max(e1,e2);
                continue;

            }
            else
            {
                finans[ind][0]= s1;
                finans[ind][1]= e1;
                s1= s2;
                e1= e2;
                ind++;
            }
        }
        finans[ind][0] = s1;
        finans[ind][1] = e1;
        ind++;
        return Arrays.copyOf(finans, ind);
    }
}
