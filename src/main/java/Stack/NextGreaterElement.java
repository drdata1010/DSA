package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {
    public static List<Integer> findNGE(List<Integer> nge, int[]arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            if(st.isEmpty()){
                nge.add(-1);
            }else if(st.peek() > arr[i]){
                nge.add(st.peek());
            }else if(st.peek() <= arr[i]){
                while(st.size() > 0 && st.peek() <= arr[i]){
                    st.pop();
                }
                if(st.size() == 0) {
                    nge.add(-1);
                }else{
                    nge.add(st.peek());
                }
            }
            st.push(arr[i]);
        }
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
