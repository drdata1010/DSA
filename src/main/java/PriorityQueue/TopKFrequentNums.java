package PriorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Arrays;

/**
 * Class representing a Pair of two integers.
 * Used to store the frequency and the element for heap operations.
 */
//class Pair {
//    int first; // Frequency of the element
//    int second; // The element itself
//
//    /**
//     * Constructor to initialize the Pair.
//     *
//     * @param first  The frequency of the element.
//     * @param second The element itself.
//     */
//    Pair(int first, int second) {
//        this.first = first;
//        this.second = second;
//    }
//}

/**
 * Solution class to solve the problem of finding the Top K Frequent Elements.
 */
class Solution {

    /**
     * Finds the k most frequent elements in the given array.
     *
     * @param nums The input array of integers.
     * @param k    The number of top frequent elements to return.
     * @return An array of integers representing the top k frequent elements.
     */
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Create a frequency map to count occurrences of each element
        HashMap<Integer, Integer> fMap = new HashMap<>();
        for (int i : nums) {
            fMap.put(i, fMap.getOrDefault(i, 0) + 1);
        }

        // Step 2: Create a Min-Heap (PriorityQueue) to keep the top k elements
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.first, p2.first));

        // Step 3: Add each element and its frequency as a Pair to the Min-Heap
        for (Map.Entry<Integer, Integer> entry : fMap.entrySet()) {
            int frequency = entry.getValue();
            int element = entry.getKey();

            // Add the pair (frequency, element) to the Min-Heap
            minHeap.offer(new Pair(frequency, element));

            // Maintain the size of the heap to be at most k
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element
            }
        }

        // Step 4: Extract the top k elements from the Min-Heap
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.poll().second;
        }

        return ans;
    }
}

public class TopKFrequentNums {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println("Test Case 1: " + Arrays.toString(solution.topKFrequent(nums1, k1))); // Expected: [1, 2]

        // Test Case 2
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println("Test Case 2: " + Arrays.toString(solution.topKFrequent(nums2, k2))); // Expected: [1]

        // Test Case 3
        int[] nums3 = {4, 4, 4, 5, 5, 6};
        int k3 = 2;
        System.out.println("Test Case 3: " + Arrays.toString(solution.topKFrequent(nums3, k3))); // Expected: [4, 5]
    }
}

