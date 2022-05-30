class Solution {
public int smallestDivisor(int[] nums, int threshold) {
    int left = 1, right = (int) 1e6;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (sum(nums, mid) > threshold) left = mid + 1;
        else right = mid;
    }
    return left;
}


int sum(int[] nums, int divisor) {
    int sum = 0;
    for (int num : nums) {
        sum += (num + divisor - 1) / divisor;
    }
    return sum;
}
}