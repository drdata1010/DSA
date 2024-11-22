package Arrays;

import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int []arr, int k){

        //For TC nlogn we can sort the arr and use Two pointers
        // For TC n and SC n, we can use Hashmap
        // we can add Arr[i], i to map then keep looking for k-A[i], if found, return map.get(k-A[i], i)
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int num = arr[i];
            int complement = k - num;
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(arr[i], i);
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int arr[] = {2,7,11,15};
        int k = 9;
        int ans[] = twoSum(arr,k);
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i]+" ");
        }
    }
}
