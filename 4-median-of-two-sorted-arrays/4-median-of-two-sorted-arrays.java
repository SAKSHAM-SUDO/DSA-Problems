class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length> nums2.length) return findMedianSortedArrays(nums2, nums1);
        int s1 = nums1.length;
        int s2  =nums2.length;
        // int mid = (s1 + s2)/2;
        int start = 0, last = s1;
        while(start<= last)
        {
            int cut1 = (start + last)/2;
            int cut2 = (s1 + s2 + 1)/2 - cut1;
            
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 -1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 -1];
            
            int r1 = cut1 == s1 ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2 == s2 ? Integer.MAX_VALUE : nums2[cut2];
            
            if(l1<= r2 && l2<=r1)
            {
                if((s1+s2) % 2 == 0)
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                
                else
                    return Math.max(l1,l2);
            }
            
            else if(l1>r2)
            {
                last = cut1-1;
                
            }
            
            else
                start = cut1+1;
        }
        return 0.0;
    }
}