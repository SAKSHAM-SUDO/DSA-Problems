class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        // int curWeight = 0;
        int start  =0;
        int end = people.length - 1;
        
        while(start <= end)
        {
            int curWeight = people[start] + people[end];
            if(curWeight <= limit)
            {
                start++;
                end--;
                count++;
            }
            else
            {
                count++;
                end--;
            }
        }
        return count;
    }
}