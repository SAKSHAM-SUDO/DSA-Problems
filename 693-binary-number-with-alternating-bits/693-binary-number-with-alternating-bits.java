class Solution {
    public boolean hasAlternatingBits(int n) {
        int lastBit = n % 2;
        int remNum = n / 2;
        while(remNum != 0)
        {
            if(lastBit == remNum % 2)
                return false;
            else{
                lastBit = remNum % 2;
                remNum = remNum / 2;
            }
        }
        return true;
    }
}