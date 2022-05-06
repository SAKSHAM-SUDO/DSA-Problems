class Solution {
    public int maximumSwap(int num) {
        if(num==0) return 0;
        char[] digits = String.valueOf(num).toCharArray();
        
        int[] buckets = new int[10];
        for(int i=0;i<digits.length;i++){
            buckets[digits[i]-'0']=i;
        }
        
        for(int i=0;i<digits.length;i++){
            for(int j=9;j>digits[i]-'0';j--){
                if(buckets[j]>i){
                    swap(digits,i,buckets[j]);
                    return Integer.parseInt(String.valueOf(digits));
                }
            }
        }
        return num;
        
    }
    static void swap(char[] arr,int i,int j){
        char t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}