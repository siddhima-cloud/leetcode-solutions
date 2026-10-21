/*
1744. Can You Eat Your Favorite Candy on Your Favorite Day?
*/
public class CanEatCandiess {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long [] prefix= new long[candiesCount.length];
        prefix[0]=candiesCount[0];
        int n=candiesCount.length;
        for(int i=1;i<n;i++) 
        {
            prefix[i]=prefix[i-1]+ candiesCount[i];
        }
boolean answer[]= new boolean[queries.length];
int i=0;
        for(int[] query: queries)
        {
            int favType= query[0];
            long favDay=query[1];
            long dailyCap= query[2];

            long candiesEaten= (favType==0)?0: prefix[favType-1];
            
            long totalCandy= (favDay+1)*dailyCap;
            if(totalCandy<=candiesEaten)
            {
                answer[i++]= false;
            } else if(prefix[favType]<= favDay)
            {
                answer[i++]= false;
            }
            else
            {
                answer[i++]= true;
            }
        }
        return answer;
    }
}