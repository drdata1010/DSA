package Recursion.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetsArr {
    private static List<List<Integer>> generateSubsets(int[] arr){
        List<List<Integer>> subsets = new ArrayList<>();

        //we're sending index as 0 and an empty DS to add or remove actually to keep state
        helperToGen(subsets, arr, 0, new ArrayList<>());

        return subsets;
    }
    private static void helperToGen(List<List<Integer>> subsets, int[] arr, int index, List<Integer> ds){
        //base case, when we reach end of array we add DS to subset
        if(index == arr.length){
            subsets.add(new ArrayList<>(ds));
            return;
        }
        //Take
        helperToGen(subsets, arr, index+1, ds);
        ds.add(arr[index]);

        //Not Take
        helperToGen(subsets, arr, index+1, ds);
        ds.remove(ds.size()-1); //remove last added element when not taking
    }
    public static void main(String[] args) {
        /**
         * Given an array of n elements, {1,2,3}
         * Print all subsets which are possible, set must not contain duplicate subsets.
         * Return soln in any order
         *
         * */
        int arr[] = {1,2,3};
        List<List<Integer>> ans = generateSubsets(arr);

        for(List<Integer> list : ans){
            for(Integer i : list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
