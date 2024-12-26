package Queue;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateNumbers {
    public static void main(String[] args) {
        int n = 99999999; // Number of elements to generate
        generateNumbers(n);
    }

    public static void generateNumbers(int n) {
        // Queue to hold the numbers
        Queue<String> queue = new LinkedList<>();

        // Initialize the queue with the given digits
        queue.offer("5");
        queue.offer("6");
        queue.offer("7");

        // Generate n numbers
        for (int i = 0; i < n; i++) {
            // Dequeue the front element
            String current = queue.poll();

            // Print the current number
            System.out.print(current + " ");

            // Enqueue the next numbers formed by appending 5 and 6
            queue.offer(current + "5");
            queue.offer(current + "6");
            queue.offer(current + "7");
        }
    }
}

