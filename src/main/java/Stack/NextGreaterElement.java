package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {
    public static List<Integer> findNGE(List<Integer> nge, int[]arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack until we find a greater element
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            // If stack is empty, no greater element exists
            nge.add(st.empty() ? -1 : st.peek());

            // Push the current element to the stack
            st.push(arr[i]);
        }

        // Reverse the result list since we're iterating from right to left
        Collections.reverse(nge);
        return nge;
    }
    public static void main(String[] args) {
        int arr[] = {1,3,2,4};
        List<Integer> nge = new ArrayList<>();
        nge = findNGE(nge, arr);
        for(Integer i : nge){
            System.out.print(i + " ");
        }
    }
}
