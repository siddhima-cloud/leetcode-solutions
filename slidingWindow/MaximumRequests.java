import java.util.*;
public class MaximumRequests{
    
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int n = sc.nextInt();
    List<Integer> timestamps = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        timestamps.add(sc.nextInt());
    }
    System.out.println(maximumRequests(x, timestamps));
}   

     static int maximumRequests(int window, List<Integer> timestamps) {

        int start=0, end=1, res=1;
        int count=1;
        int n= timestamps.size();
        for(;end<n;end++)
        {
            if((end-start+1<=window)&& timestamps.get(end)-timestamps.get(end-1)==1)
            {
                count++;
            }
            else
            {
                res= Math.max(res,count);
                count=0;
            }

            if(window== (end-start+1))
            {
                res= Math.max(res,count);
                count=0;
                start=start+1;
            }
        }

return res;
    }
}