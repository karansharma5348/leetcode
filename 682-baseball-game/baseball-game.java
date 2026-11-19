class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < operations.length; i++){
            String op = operations[i];

            if(op.equals("C")){
                st.pop();
            }

            else if(op.equals("D")){

                int num=st.peek();

                st.push(num*2);
            }

            else if(op.equals("+")){

                int top = st.pop();
                int top1 = st.peek();

                int sum = top + top1;

                st.push(top);
                st.push(sum);
            }
            
            else{
                int num = Integer.parseInt(op);
                st.push(num);
            }
        }
        int total = 0;

        while(!st.isEmpty()){
            total+=st.pop();
        }
        return total;
    }
}