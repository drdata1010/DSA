package Stack;

public class MaxAreaHistogram {
    static int largestarea(int arr[], int n) {
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, arr[j]);
                int width = j - i + 1;
                maxArea = Math.max(maxArea, minHeight * width);
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int arr[] = {6,2,5,4,1,5,6};
        int n = 7;
        System.out.println("The largest area in the histogram is " + largestarea(arr, n)); // Printing the largest rectangle area

    }
}
