class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        double median=0.0;
        int mergedLength=m+n;
        int merged[]=new int[mergedLength];
        for(int i=0;i<m;i++){
            merged[i]=nums1[i];
        }
        int index=0;
        for(int i=m;i<m+n;i++){
            merged[i]=nums2[index++];
        }
        Arrays.sort(merged);
        if((mergedLength)%2==0){
            median=((double)merged[mergedLength/2]+(double)merged[(mergedLength/2)-1])/2;
        }
        else{
            median=(double)merged[(mergedLength-1)/2];
        }
        return median;
    }
}