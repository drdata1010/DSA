package PriorityQueue;

import java.util.PriorityQueue;

public class KthSmallest {
    private static int kthSmallest(int[] arr, int N, int K){
        //As kth Smallest is asked, maintain K Max Heap and return its peek
        //This is maxHeap using PQ
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        //Iterate array add it to maxHeap
        for(int i = 0; i < N; i++){
            //adding to maxHeap
            maxHeap.offer(arr[i]);

            //removing if maxHeap size exceeds k
            if(maxHeap.size() > K){
                maxHeap.poll();
            }
        }
        //return maxHeap's peek
        return maxHeap.peek();
    }
    public static void main(String[] args) {
        //Find Kth Smallest from given array
        int N = 10;
        int[] arr = { 10, 5,2, 4, 3, 48, 6, 2, 33, 53, 10 };
        int K = 4;
        // Function call
        System.out.println("Kth Smallest Element is: " + kthSmallest(arr, N, K));
    }
}
