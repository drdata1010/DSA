package PriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortKSortedArr {

    private static List<Integer> kSort(int[] arr, int n, int k) {
        // As we need to sort the array, we will use a Min Heap (PriorityQueue)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Create a list to store the sorted elements
        ArrayList<Integer> list = new ArrayList<>();

        // Iterate through the array elements
        for (int i = 0; i < n; i++) {
            // Add the current element to the Min Heap
            minHeap.offer(arr[i]);

            // If the size of the Min Heap exceeds k, remove the smallest element (root of the Min Heap)
            // and add it to the sorted list
            if (minHeap.size() > k) {
                list.add(minHeap.poll());
            }
        }

        // Extract the remaining elements from the Min Heap and add them to the sorted list
        while (minHeap.size() > 0) {
            list.add(minHeap.poll());
        }

        // Print the sorted list (if needed for debugging or logging)
        printArray(list);

        // Return the sorted list
        return list;
    }
//TC : O(nlog(k)
//SC : O(k)
    // A utility function to print the array
    private static void printArray(List<Integer> list)
    {
        for(Integer val : list){
            System.out.println(val + " ");
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        int n = arr.length;

        // function call
        kSort(arr, n, k);
//        printArray(list, n);
    }
}
