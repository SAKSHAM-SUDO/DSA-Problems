class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        
        for(int i = 0; i < arr.length; i++){
            int rem = arr[i] % k;
            if(rem < 0){
                rem = k + rem;
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        
        for(int val : arr){
            int rem = val % k;
            
            if(rem == 0){
                int freq = map.get(0);
                if(freq % 2 != 0){
                    return false;
                }
            }
            else if(rem * 2 == k){
                int freq = map.get(rem);
                if(freq % 2 != 0){
                    return false;
                }
            }
            else{
                int freq1 =map.getOrDefault(rem, 0);
                int freq2 = map.getOrDefault(k - rem, 0);
                
                if(freq1 != freq2){
                    return false;
                }
            }
        }
        
        return true;
    }
}
