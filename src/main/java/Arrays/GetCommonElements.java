package Arrays;

import java.util.HashMap;

public class GetCommonElements {
    //Given two arrays a1, a2 return elements of a2 which appears in a1 but maintain relative order of a2.
    public static void main(String[] args) {
        int[] a1 = {1,1,1,2,2,3,3,5,5,3};
        int[] a2 = {1,1,1,2,2,4,5};
        //output : 1,2

        //Creating Frequency Map
        HashMap<Integer, Integer> fmap = new HashMap<>();
        for(int val : a1){
            if(fmap.containsKey(val)){
                int oldF = fmap.get(val);
                int newF = oldF + 1;
                fmap.put(val, newF);
            }else{
                fmap.put(val,1);
            }
        }
        for(int val : a2){
            if(fmap.containsKey(val)){
                System.out.print(val + " ");
                fmap.remove(val);
            }
        }
    }
}
