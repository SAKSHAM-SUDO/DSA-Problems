class Solution {
    Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();

    private void DFS(int[] signalReceivedAt, int currNode, int currTime) {
        if (currTime >= signalReceivedAt[currNode]) {
            return;
        }

        signalReceivedAt[currNode] = currTime;
        
        if (!adj.containsKey(currNode)) {
            return;
        }
        
        for (Pair<Integer, Integer> edge : adj.get(currNode)) {
            int travelTime = edge.getKey();
            int neighborNode = edge.getValue();
            
            DFS(signalReceivedAt, neighborNode, currTime + travelTime);
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];
            
            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair(travelTime, dest));
        }
        
        for (int node : adj.keySet()) {
            Collections.sort(adj.get(node), (a, b) -> a.getKey() - b.getKey());
        }
        
        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);
        
        DFS(signalReceivedAt, k, 0);
        
        int answer = Integer.MIN_VALUE;
        for (int node = 1; node <= n; node++) {
            answer = Math.max(answer, signalReceivedAt[node]);
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}