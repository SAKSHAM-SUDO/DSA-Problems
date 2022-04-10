class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < ops.length; i++)
        {
            String k = ops[i];
            // if(k >= 48 && k >= 57)
            // {
            //     st.push(k - '0');
            // }
            if(k.equals("+"))
            {
                int num1 = st.pop();
                int num2 = st.pop();
                int sum = num1 + num2;
                st.push(num2);
                st.push(num1);
                st.push(sum);
            }
            else if(k.equals("D"))
            {
                int num = st.peek() * 2;
                st.push(num);
            }
            else if(k.equals("C"))
            {
                st.pop();
            }
            else{
                st.push(Integer.parseInt(k));
            }
        }
        int sum = 0;
        while(!st.isEmpty())
        {
            int num = st.pop(); 
            System.out.print(num +", ");
            sum = sum + num;
        }
        return sum;
    }
}