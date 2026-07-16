// method 1: two pointers+ array
/*
Instead of using an extra array you can use set and use set so that you can use sset functions see m2;
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n= Math.max(nums1.length,nums2.length);
        int[] ans= new int [n];  
        int i=0, j=0,k=0;
        while(i<nums1.length && j<nums2.length)
        {
            if(i>0 && nums1[i]==nums1[i-1])
            {
                i++;
                continue;
            }
            if(i<nums1.length && nums1[i]==nums2[j])
            {
                ans[k]= nums1[i];
                i++;
                j++;
                k++;
            }
            else if(j<nums2.length && nums1[i]<nums2[j])
            {
                i++;
            }
            else
            {
                j++;
            }
        }
        return Arrays.copyOf(ans,k);
    }
    

    
// Method2 : two pointers+ set
    public static int [] intersection2 (int []nums1,int [] nums2)
    {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int N= nums1.length;
        int M = nums2.length;
        int p1=0, p2=0;
        Set <Integer> intersection= new HashSet<>();

        while(p1<nums1.length && p2<nums2.length)
        {
            if(nums1[p1]== nums2[p2])
            {
                intersection.add(nums1[p1]);
                p1++;
                p2++;

            }
            else if(nums1[p1]< nums2[p2])
            {
                p1++;
            }
            else
            {
                p2++;
            }
        }

        int k= intersection.size();
        int []result = new int[k];
        int curr =0;
        for(int x: intersection)
        {
            result[curr]=x;
            curr++;
        }
        return result;
    }

    // Method 3
    /* Built-in Set Intersection
        Intuition

        There are built-in intersection facilities, which provide O(n+m) time complexity in the average case and O(n×m) time complexity in the worst case.
        In Java it's the retainAll() function.

        Algorithm

        Initialize a set set1 and add all elements of nums1 to it.
        Initialize a set set2 and add all elements of nums2 to it.
        Call the built-in set intersection method (either retainAll() in Java, or & operator in Python).
        Transform the resulting set into an array and return this result.
    
        */

  public int[] intersection(int[] nums1, int[] nums2) 
  {
    Set<Integer> set1 = new HashSet<>();
    for (Integer n : nums1)
    {
        set1.add(n);
    } 
    Set<Integer> set2 = new HashSet<>();
    for (Integer n : nums2) 
    {
        set2.add(n);
    }
    set1.retainAll(set2);
    int[] output = new int[set1.size()];
    int idx = 0;
    for (int s : set1) 
    {
        output[idx++] = s;
    }
    return output;
  }

}



    


 
