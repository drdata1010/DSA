package Recursion;

import java.util.ArrayList;
import java.util.List;

public class printSubsequences {
    public static void findSubsequences(int curr, int n, int arr[], List<Integer> subarr, List<List<Integer>> res){
//Whole Idea is to take and not take array elements
        //Base case, when curr reaches n - 1, add current subarray and return from depth
        if(curr == n){
            res.add(new ArrayList<>(subarr));
            return;
        }

        //Take element to subarr or current subsequence
        subarr.add(arr[curr]);
        //recurse to next element
        findSubsequences(curr+1,n,arr,subarr,res);

        //remove current element, explore other opps
        subarr.remove(subarr.size()-1);

        //do not include element in the subsequence
        findSubsequences(curr+1,n,arr,subarr,res);
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int n = arr.length;
        List<Integer> subarr = new ArrayList<>();

        List<List<Integer> > res = new ArrayList<>();

        findSubsequences(0,n, arr, subarr, res);


        for (List<Integer> subsequence : res) {
            if(subsequence.isEmpty()){
                System.out.println("{}");
            }
            for (int num : subsequence) {
                System.out.print(num + " ");
            }
            System.out.println();

        }
    }
}
