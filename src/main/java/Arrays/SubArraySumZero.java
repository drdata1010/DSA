package Arrays;

import java.util.HashMap;

public class SubArraySumZero {
    public static boolean hasSubarrayWithZeroSum(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;

        for(int i = 0; i < arr.length; i ++){
            prefixSum += arr[i];

            if(prefixSum == 0 || map.containsKey(prefixSum)){
                return true;
            }

            map.put(prefixSum,i);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 2, -6, 3, 1};
        System.out.println(hasSubarrayWithZeroSum(arr) ? "Subarray with sum 0 exists" : "No such subarray exists");
    }
}
