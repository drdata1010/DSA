package PriorityQueue;

import java.security.Principal;
import java.util.PriorityQueue;

public class KthLargest {
    public static int kthLargest(int[] arr, int N, int K) {
        // Create a min-heap to store the K largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate through all elements of the array
        for (int i = 0; i < N; i++) {
            // Add the current element to the min-heap
            minHeap.offer(arr[i]);

            // If the size of the min-heap exceeds K, remove the smallest element
            // This ensures the heap always contains the K largest elements
            if (minHeap.size() > K) {
                minHeap.poll();
            }
        }

        // The top element of the min-heap is the Kth largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        //Find Kth Largest from given array
        int N = 10;
        int[] arr = { 10, 5,2, 4, 3, 48, 6, 2, 33, 53, 10 };
        int K = 4;
        // Function call
        System.out.println("Kth Largest Element is: " + kthLargest(arr, N, K));
    }
}
