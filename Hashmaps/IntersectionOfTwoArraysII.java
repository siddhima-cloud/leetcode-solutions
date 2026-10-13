/*
350. Intersection of Two Arrays II
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
/*
        HashMap<Integer,Integer> freq1= new HashMap<>();
        HashMap<Integer,Integer> freq2= new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums1.length;i++)
        {
            freq1.put(nums1[i],freq1.getOrDefault(nums1[i],0)+1);
        }
         for(int i=0;i<nums2.length;i++)
        {
            freq2.put(nums2[i],freq2.getOrDefault(nums2[i],0)+1);
        }

        for(int i=0;i<nums1.length;i++){
            if(freq2.getOrDefault(nums1[i],0)>0)
            {
                int count= Math.min(freq1.get(nums1[i]),freq2.get(nums1[i]));
                while(count-->0)
                {
                    ans.add(nums1[i]);
                }
                freq2.remove(nums1[i]);
            }
        }
*/
        
    // METHOD2: PRESORTING AND TWO POINTERS
/*
     Arrays.sort(nums1);
     Arrays.sort(nums2);
        ArrayList<Integer> ans = new ArrayList<>();
     int p1=0, n1= nums1.length;
     int p2=0, n2= nums2.length;  


     while (p1<n1 && p2<n2)
     {
        if(nums1[p1]==nums2[p2])
        {
            ans.add(nums1[p1]);
            p1++;
            p2++;
        }else if(nums1[p1]<nums2[p2])
        {
            p1++;
        }else{
            p2++;
        }
     }
*/

// METHOD 3: USING FIXED ARRAY

int[] freq1= new int[1001];
int[] freq2= new int[1001];
ArrayList<Integer> ans = new ArrayList<>();
for(int num: nums1)
freq1[num]++;

for(int num: nums2)
freq2[num]++;

for(int i=0;i<1001;i++)
{
    if(freq1[i]>0 && freq2[i]>0)
    {
        int count = Math.min(freq1[i],freq2[i]);
         while(count-->0)
                {
                    ans.add(i);
                }
    }
}
     int [] res= new int[ans.size()];
        for(int i=0;i<res.length;i++)
        {
            res[i]= ans.get(i);
        }
        return res;
    }
}