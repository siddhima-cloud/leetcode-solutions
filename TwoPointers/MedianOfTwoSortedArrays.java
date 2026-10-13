/*
*/
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int m= nums2.length;
        int mergedArray[]= new int[n+m];
        int p1=0,p2=0,k=0;
        while(p1<n && p2<m)
        {
            if(nums1[p1]<nums2[p2])
            {
                mergedArray[k++]=nums1[p1++];
            }
            else if(nums1[p1]==nums2[p2])
            {
                mergedArray[k++]=nums1[p1++];
                mergedArray[k++]=nums2[p2++];
            }
            else {
                 mergedArray[k++]=nums2[p2++];
            }
        }
        while(p1<n){
                mergedArray[k++]=nums1[p1++];
            }

            while(p2<m){
                 mergedArray[k++]=nums2[p2++];
            }

            if((n+m)%2!=0)
            {
                return mergedArray[(n+m)/2];
            }

            int mid1= (n+m-1)/2;
            int mid2= mid1+1;
            int total=  mergedArray[mid1]+mergedArray[mid2];
            double median= total/2.0;
            return median;
            
    }
}