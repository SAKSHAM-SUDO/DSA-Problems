class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<prerequisites.length; i++){
            int c1 = prerequisites[i][0];
            int c2 = prerequisites[i][1];
            graph[c1].add(c2);
        }
    int[] in = new int[numCourses];
    for(int i = 0; i<numCourses; i++){
        for(int n : graph[i]){
            in[n]++;
        }
    }
    
    Queue<Integer> qu = new LinkedList<>();
    for(int i = 0; i<numCourses; i++){
        if(in[i] == 0){
            qu.add(i);
        }
    }
    
    int[] tsort = new int[graph.length];
    int idx = tsort.length-1;
    
    while(qu.size()>0){
        int rem = qu.remove();
        tsort[idx--] = rem;
        
        for(int n : graph[rem]){
            in[n]--;
            
            if(in[n]==0){
                qu.add(n);
            }
        }
    }
    
    if(idx==-1){
        return tsort;
    }else{
        return new int[] {};
    }

    }
}