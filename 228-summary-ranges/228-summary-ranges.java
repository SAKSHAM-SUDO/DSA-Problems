class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            int start = nums[i]; 
            int end = start;
            String temp = "";
            
            while(i + 1 < nums.length && nums[i] + 1 == nums[i+1])
            {
                end = nums[i + 1];
                i++;
            }
            if(start == end)
                temp = Integer.toString(start);
            else
                temp = Integer.toString(start) + "->" + Integer.toString(end);
            list.add(temp);
        }
        return list;
    }
}