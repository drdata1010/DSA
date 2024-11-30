package Arrays.MedianOfTwoSortedArrs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'median_array' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY nums1
     *  2. INTEGER_ARRAY nums2
     */

    public static String median_array(List<Integer> nums1, List<Integer> nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        if (n1 == 0 && n2 == 0) {
            throw new IllegalArgumentException("Both input arrays are empty.");
        }
        // Binary search on the smaller array
        if (n1 > n2) return median_array(nums2, nums1);

        int low = 0, high = n1;
        int totalLength = n1 + n2;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = (totalLength + 1) / 2 - mid1;

            int l1 = (mid1 >= 0) ? nums1.get(mid1 - 1) : Integer.MIN_VALUE;
            int l2 = (mid2 >= 0) ? nums2.get(mid2 - 1) : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? nums1.get(mid1) : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? nums2.get(mid2) : Integer.MAX_VALUE;

            // Valid partition found
            if (l1 <= r2 && l2 <= r1) {
                if (totalLength % 2 == 1) {
                    // Odd total length
                    return String.format("%.1f", (double) Math.max(l1, l2));
                } else {
                    // Even total length
                    double median = (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                    return String.format("%.1f", median);
                }
            }

            // Move the binary search boundaries
            if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        // Fallback for invalid input
        return "NA";
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String[] nums1Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> nums1 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int nums1Item = Integer.parseInt(nums1Temp[i]);
            nums1.add(nums1Item);
        }

        String[] nums2Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> nums2 = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int nums2Item = Integer.parseInt(nums2Temp[i]);
            nums2.add(nums2Item);
        }

        String result = Result.median_array(nums1, nums2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
