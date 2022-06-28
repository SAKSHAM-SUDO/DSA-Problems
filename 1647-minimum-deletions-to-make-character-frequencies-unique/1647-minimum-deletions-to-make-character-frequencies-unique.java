class Solution {
    public int minDeletions(String s) {
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0) {
                pq.add(frequency[i]);
            }
        }
        
        int deleteCount = 0;
        while (pq.size() > 1) {
            int topElement  = pq.remove();
            
            if (topElement == pq.peek()) {
                if (topElement - 1 > 0) {
                    pq.add(topElement - 1);
                }
                deleteCount++;
            }
        }
        
        return deleteCount;
    }
}