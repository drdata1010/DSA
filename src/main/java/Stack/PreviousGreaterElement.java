package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreviousGreaterElement {
    public static List<Integer> findPGE(List<Integer> pge, int[]arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            if(st.isEmpty()){
                pge.add(-1);
            }else if(st.peek() > arr[i]){
                pge.add(st.peek());
            }else if(st.peek() <= arr[i]){
                while(st.size() > 0 && st.peek() <= arr[i]){
                    st.pop();
                }
                if(st.size() == 0) {
                    pge.add(-1);
                }else{
                    pge.add(st.peek());
                }
            }
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
