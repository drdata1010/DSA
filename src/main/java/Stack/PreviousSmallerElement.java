package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreviousSmallerElement {
    public static List<Integer> findPSE(List<Integer> pse, int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (!st.empty() && st.peek() >= arr[i]) {
                st.pop();
            }
            if (st.empty()) {
                pse.add(-1);
            } else {
                pse.add(st.peek());
            }
            st.push(arr[i]);
        }
        return pse;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,2,10,8};
        List<Integer> pse = new ArrayList<>();
        pse = findPSE(pse, arr);
        for(Integer i : pse){
            System.out.print(i + " ");
        }
    }
}
