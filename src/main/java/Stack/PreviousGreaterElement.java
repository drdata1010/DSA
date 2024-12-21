package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreviousGreaterElement {
    public static List<Integer> findPGE(List<Integer> pge, int[]arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements from the stack until we find a greater element
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            // If stack is empty, no greater element exists
            pge.add(st.empty() ? -1 : st.peek());

            // Push the current element to the stack
            st.push(arr[i]);
        }

        return pge;

    }
    public static void main(String[] args) {
        int arr[] = {1,3,2,4};
        List<Integer> pge = new ArrayList<>();
        pge = findPGE(pge, arr);
        for(Integer i : pge){
            System.out.print(i + " ");
        }
    }
}
