class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < tokens.length; i++)
        {
            String s = tokens[i];
            
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            {
                int v2 = st.pop();
                int v1 = st.pop();
                int tempVal = operation(v1,v2,s);
                st.push(tempVal);
            }
            else
            {
                int x = Integer.parseInt(s);
                st.push(x);
            }
        }
        int result = st.pop();
        return result;
    }
    
    public int operation(int v1, int v2, String op){
            if(op.equals("+")){
                return v1 + v2;
            }
            else if(op.equals("-")){
                return v1 - v2;
            }
            else if (op.equals("/")){
                return v1/v2;
            }else{
                return v1*v2;
            }
        }
}
