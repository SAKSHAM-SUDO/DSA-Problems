class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int chunkCount = 0;
        for(int i = 0; i < arr.length; i++)
        {
            max = (int)Math.max(max, arr[i]);
            if(max == i)
            {
                chunkCount++;
            }
        }
        return chunkCount;
    }
}