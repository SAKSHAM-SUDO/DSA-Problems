class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length)
        {
            return nums;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i], 1);
            }
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (num1, num2) -> map.get(num1) - map.get(num2));
        
        for(int num : map.keySet())
        {
            pq.add(num);
            if(pq.size() > k)
                pq.poll();
        }
        int ans[] = new int[k];
        for(int i = 0; i < k; i++)
        {
            ans[i] = pq.poll();
        }
        return ans;
    }
}