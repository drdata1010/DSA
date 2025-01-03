package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int arr[] = {100, 80, 60, 70, 60, 75, 85};
        //op ; 1 1 1 2 1 4 6
        //As we need to find span until which my current price is >=, so we can use stack
        //we will push indices into stack and check if arr[st.peek()] <= arr[i] then pop
        //if st goes empty means no element greater than curr so add i+1 to ans else add i-st.peek()

        ArrayList<Integer> ls = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            while(!st.empty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            ls.add(st.empty() ? i + 1 : i-st.peek());
            st.push(i);
        }
        for(Integer i : ls){
            System.out.print(i + " ");
        }
    }
}
