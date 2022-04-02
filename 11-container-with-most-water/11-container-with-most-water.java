class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        
        int left = 0; 
        int right = height.length - 1;
        
        while(left < right) {
            int width = right - left; 
            int currArea = width * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currArea);
            
            if(height[left] < height[right]) {
                left ++;
            }
            else {
                right --;
            }
        }
        return maxArea;
    }
}
