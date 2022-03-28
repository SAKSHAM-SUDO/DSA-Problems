class Solution {
    public boolean search(int[] arr, int x) {
        
       int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
  
            if (arr[m] == x)
                return true;
 
            else if(arr[m] == arr[l] && arr[m] == arr[r])
            {
                l++;
                r--;
            }
           else if (arr[m] >= arr[l])
            {
                if(x >= arr[l] && x < arr[m])
                    r = m-1;
                else
                    l = m + 1;
            }  
            else{
                if(x > arr[m] && x <= arr[r])
                    l = m + 1;
                else
                    r = m-1;
            }
        }
  
        return false;
    }
}