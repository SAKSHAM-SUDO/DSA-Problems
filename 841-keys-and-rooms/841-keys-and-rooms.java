class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];
        int count = 0;
        for(int i = 0; i < rooms.size(); i++)
        {
            if(visited[i] == false)
            {
                count++;
                calc(rooms, i, visited);
            }
        }
        return count == 1;
    }
    public void calc(List<List<Integer>> rooms, int idx, boolean visited[])
    {
        visited[idx] = true;
        
        for(int n : rooms.get(idx))
        {
            if(visited[n] == false)
            {
                calc(rooms, n, visited);
            }
        }
    }
}