class Solution
{
    class Pair implements Comparable<Pair>
    {
        String num;
        int idx;
        
        Pair(String num, int idx)
        {
            this.num = num;
            this.idx = idx;
        }

        public int compareTo(Pair p)
        {
            if(num.equals(p.num))
                return idx - p.idx;
            
            return num.compareTo(p.num);
        }
    }
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries)
    {
        int ans[] = new int[queries.length];
        int idx = 0;    
        for(int i = 0; i < queries.length; i++)
        {
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            int t = queries[i][0] - 1;
            int trim = queries[i][1];
            
            for(int j = 0; j < nums.length; j++)
            {
                String curr = nums[j];
                curr = curr.substring(curr.length() - trim);
                pq.add(new Pair(curr, j));
            }
            while(t --> 0)
            {
                pq.poll();
            }
            ans[idx++] = pq.poll().idx;
        }
        return ans;
    }
}