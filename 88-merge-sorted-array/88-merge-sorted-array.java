class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i = 0 , j= 0;
        int ans[]= new int[n+m];
        int c =0;
        while(i < m && j < n)
        {
            if(nums1[i] < nums2[j])
            {
                ans[c++] = nums1[i];
                i++;
            }
            
            else{
                ans[c++] = nums2[j];
                j++;
            }
        }
        while(i<m) ans[c++] = nums1[i++];
        while(j<n) ans[c++] = nums2[j++];

        
        for(int k = 0; k< ans.length ; k++)
        {
            nums1[k] = ans[k];
        }
        
    }
}