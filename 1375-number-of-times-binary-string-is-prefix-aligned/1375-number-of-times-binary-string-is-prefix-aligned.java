class Solution {
    public int numTimesAllBlue(int[] flips) {
        int count = 0;
        int curr = 0;
        for(int i = 0; i < flips.length; i++)
        {
            curr = Math.max(curr, flips[i]);
            if(curr == i + 1)
                count++;
        }
        return count;
    }
}