package PriorityQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class FreqSort{
    public static int[] sort(int[] nums){
        //Create hashMap
        HashMap<Integer, Integer> fMap = new HashMap<>();
        for (int i : nums) {
            fMap.put(i, fMap.getOrDefault(i, 0) + 1);
        }
        //Create Priority Queue of Pairs (frequency,elements)
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.first, p2.first));
        for (Map.Entry<Integer, Integer> entry : fMap.entrySet()) {
            int frequency = entry.getValue();
            int element = entry.getKey();

            // Add the pair (frequency, element) to the Min-Heap
            minHeap.offer(new Pair(frequency, element));
            }
        int idx = 0;
        while(!minHeap.isEmpty()){
            int freq = minHeap.peek().first;
            int ele = minHeap.peek().second;
            for(int i = 0; i < freq; i++){
                nums[idx++] = ele;
            }
            minHeap.poll();
        }
        return nums;
    }

}
public class FrequencySort {
    public static void main(String[] args) {
        FreqSort solution = new FreqSort();

        // Test Case 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        System.out.println("Test Case 1: " + Arrays.toString(FreqSort.sort(nums1))); // Expected: [1, 2]

        // Test Case 2
        int[] nums2 = {1};
        System.out.println("Test Case 2: " + Arrays.toString(FreqSort.sort(nums2))); // Expected: [1]

        // Test Case 3
        int[] nums3 = {4, 4, 4, 5, 5, 6};
        int k3 = 2;
        System.out.println("Test Case 3: " + Arrays.toString(FreqSort.sort(nums3))); // Expected: [4, 5]
    }
}
