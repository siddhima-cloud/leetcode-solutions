/*
1109. Corporate Flight Bookings
*/
public class CorporateFlight  {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // Method 1
        // int ans[]= new int [n];
        // for(int[]  booking: bookings)
        // {
        //     int start= booking[0];
        //     int end= booking[1];
        //     int reserve= booking[2];
        //     for(int i=start-1;i<end;i++)
        //     {
        //         ans[i]+= reserve;
        //     }
        // }
        // return ans;


        // METHOD 2: EFFICIENT RANGE UPDATE
int ans[]= new int [n];
        for(int[] booking: bookings)
        {
              int start= booking[0];
            int end= booking[1];
            int reserve= booking[2];
            ans[start-1]+= reserve;
            if(end<n)
            {
                ans[end]-= reserve;
            }

        }
        for(int i=1;i<n;i++)
        {
            ans[i]= ans[i-1]+ans[i];
        }
        return ans;
    }

}
