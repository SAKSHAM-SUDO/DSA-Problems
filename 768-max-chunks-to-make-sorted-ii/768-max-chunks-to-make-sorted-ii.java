class Solution {
    public int maxChunksToSorted(int[] arr) {
        int rmin[] = new int[arr.length + 1];
        int min = Integer.MAX_VALUE;
        rmin[arr.length] = min;
        for(int i = arr.length - 1; i >= 0; i--)
        {
            rmin[i] = Math.min(rmin[i+1], arr[i]);
        }
        
        int countChunks = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++)
        {
            max = Math.max(max,arr[i]);
            if(max <= rmin[i+1])
            {
                countChunks++;
            }
        }
        return countChunks;
    }
}