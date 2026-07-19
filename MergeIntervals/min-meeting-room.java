/*
INTUTION
sort both arrays and use two pointer(merge two arrays logic)

Real-life  example: think of it as a hotel room construction  
if element belongs to start array means create  a room, belongs to end means destroy the room.
when two elements are same means firstly destroy  and then create;

also start array will always finish first .

the answer is the max no of room constructed at a given time.


GFG: given two arrays start[] and end[] such that start[i] is the starting time of ith meeting and end[i] is the ending time of ith meeting. Return the minimum number of rooms required to attend all meetings.

Note: A person can also attend a meeting if it's starting time is same as the previous meeting's ending time
*/
class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0;
        int j=0;
        int res=0;
        int k=0;
        int n= start.length;
        while(i<start.length && j<end.length)
        {
            
            if(start[i]<end[j])
            {
                k+=1;
                res=Math.max(res,k);
                i++;
            }
            else if(end[j]==start[i] )
            {
                i++;
                j++;
            }
            else
            {
                k-=1;
                j++;
            }
        }
        
        return res;
    }
}
