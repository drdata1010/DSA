package PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * This program finds the k closest elements to a given value x in an array.
 * The elements are returned in sorted order.
 */
class Pair {
    int first; // Difference from x
    int second; // Value of the element

    /**
     * Constructor for the Pair class.
     *
     * @param first  The difference of the element from x.
     * @param second The value of the element.
     */
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class FindKClosestElements {

    /**
     * Main method to test the functionality of finding k closest elements.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        List<Integer> KClosest = new ArrayList<>();
        findKClosest(KClosest, arr, k, x);
        for (Integer I : KClosest) {
            System.out.print(I + " ");
        }
    }

    /**
     * Finds the k closest elements to x in the given array and adds them to the provided list.
     *
     * @param kClosest The list to store the k closest elements.
     * @param arr      The input array of integers.
     * @param k        The number of closest elements to find.
     * @param x        The reference value to calculate closeness.
     */
    private static void findKClosest(List<Integer> kClosest, int[] arr, int k, int x) {
        // Max-Heap to store the k closest elements
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> {
            if (p2.first != p1.first) {
                return Integer.compare(p2.first, p1.first); // Larger difference first
            } else {
                return Integer.compare(p2.second, p1.second); // Larger value first
            }
        });

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Add the current element as a Pair (difference, value)
            maxHeap.offer(new Pair(Math.abs(arr[i] - x), arr[i]));

            // If the size of the heap exceeds k, remove the farthest element
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Extract all elements from the heap and add them to the list
        while (!maxHeap.isEmpty()) {
            kClosest.add(maxHeap.poll().second);
        }

        // Sort the result list to return elements in ascending order
        Collections.sort(kClosest);
    }
}
