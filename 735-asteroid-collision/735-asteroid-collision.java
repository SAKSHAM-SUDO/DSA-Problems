class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<Integer>();
        // st.push(asteroid[0]);
        for(int i = 0; i < asteroids.length; i++)
        {
           if(asteroids[i] < 0)
           {
               while(!st.isEmpty() && st.peek () > 0 && st.peek() < asteroids[i] * -1)
               {
                   st.pop();
               }
               if(!st.isEmpty() && st.peek() == asteroids[i] * -1)
               {
                   st.pop();
                   continue;
               }
               else if(!st.isEmpty() && st.peek() > asteroids[i] * -1)
               {
                   continue;
               }
               else
               {
                   st.push(asteroids[i]);
               }
           }
            else
                 st.push(asteroids[i]);
        }
        int n = st.size();
        int ans[]= new int[n];
        for(int i = n-1; i >= 0; i--)
        {
            ans[i] = st.pop();
        }
        return ans;
        
    }
}