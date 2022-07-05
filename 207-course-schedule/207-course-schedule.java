class Solution {
    public boolean canFinish(int numCourses, int[][] mat) {
        int topo[] = new int[numCourses];
        int inDegree[] = new int[numCourses];
        
        ArrayList<Integer>[] list = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++)
        {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < mat.length; i++)
        {
            int c1 = mat[i][0];
            int c2 = mat[i][1];
            list[c1].add(c2);
        }
        
        for(int i = 0; i < numCourses; i++)
        {
            for(int n : list[i])
            {
                inDegree[n]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++)
        {
            if(inDegree[i] == 0)
                q.add(i);
        }
        int idx = numCourses - 1;
        while(!q.isEmpty())
        {
            int curr = q.poll();
            topo[idx--] = curr;
            for(int n : list[curr])
            {
                inDegree[n]--;
                if(inDegree[n] == 0)
                    q.add(n);
            }
        }
        
        for(int num : inDegree)
        {
            if(num != 0)
                return false;
        }
        return true;
    }
}