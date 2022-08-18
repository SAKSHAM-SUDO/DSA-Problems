class Solution
{
    public int minSetSize(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int val : arr)
        {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(Integer x: map.values())
        {
            pq.offer(x);
        }
        
        int curr = arr.length;
        int count = 0;
        while(curr > arr.length / 2 && pq.size() != 0)
        {
            count++;
            curr -= pq.poll();
        }
        
        return count;
    }
}