class Solution {
    public int minimumDeletions(int[] nums) {
			int n = nums.length;
            
            if (n == 1) return 1;
            if (n == 2 || n == 3) return 2;
            
			int i = 0;
			int minIdx = 0; 
			int maxIdx = 0; 
            
			while (i < n) {
				if (nums[i] > nums[maxIdx])
					maxIdx = i; 
				if (nums[i] < nums[minIdx])
					minIdx = i;
				i++;
			}
            int left = Math.min(maxIdx, minIdx);
			int right = Math.max(maxIdx, minIdx);
			int res = Math.min((Math.min((right + 1), (n - left))), ((left + 1) + (n - right)));
			return res;

    }
}