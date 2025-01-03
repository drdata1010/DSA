package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextSmallerElement {
    public static List<Integer> findNSE(List<Integer> NSE, int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        for(int i = n-1; i >=0; i--){
            //condition to pop
            while(!st.empty() && st.peek() >= arr[i]){
                st.pop();
            }
            NSE.add(st.empty() ? -1 : st.peek());

            st.push(arr[i]);
        }
        //reverse list
        Collections.reverse(NSE);
        return NSE;
    }
    public static void main(String[] args) {
        int[] arr = {5,5,2,10,8};
        List<Integer> NSE = new ArrayList<>();
        NSE = findNSE(NSE, arr);
        for(Integer i : NSE){
            System.out.print(i+", ");
        }
    }
}
