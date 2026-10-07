public class MoveZeroesToEnd  {
    public void moveZeroes(int[] nums) {
        int n= nums.length;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==0)
            {
               for(int j=i+1;j<n;j++)
               {
                if(nums[j]!=0)
                {
                    nums[i]=nums[j];
                    nums[j]=0;
                    break;
                }
               }
            }
        }
        
    }
}

