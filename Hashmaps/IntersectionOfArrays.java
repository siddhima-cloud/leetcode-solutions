import java.util.HashSet;

 class Solution {

    // Method1
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> ans= new HashSet<>();
        for(int i=0;i<nums1.length;i++)
        {
            ans.add(nums1[i]);
        }
      
      Iterator<Integer> iterator = ans.iterator();
while (iterator.hasNext()) {
    int x = iterator.next();
    if (!contains(x, nums2)) {
        iterator.remove(); // Safely removes the element from the HashSet
    }
}

        int[] a= new int[ans.size()];
        int k=0;
        for(int x: ans)
        {
            a[k++]= x;
        }

return a;
    }

    static boolean contains(int x,int[]nums2)
    {
        for(int i=0;i<nums2.length;i++)
        {
            if(nums2[i]==x)
            {
                return true;
            }
        }
        return false;
    }
} {
    
}
