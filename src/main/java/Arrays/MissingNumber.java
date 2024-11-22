package Arrays;

public class MissingNumber {
    /*
    Given an array nums containing n distinct numbers in the range [0, n],
    return the only number in the range that is missing from the array.
Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
2 is the missing number in the range since it does not appear in nums.
     */
    public static int missingNum(int[]nums) {
        //since range is 0,n, we can have a frequency array and put counts, then iterate this frequency array and print i having count as 0
        // this will take O(n) space and O(n) time

        //optimized
        //find the xor of index from 0 to n which will be 0^1^2^3^4.......^n
        //then find xor of arr[i], this will be 0^1^2^3^4...^x..^n
        //as xor of same elements == 0, same elements will cancel if we xor xor1^xor2 and remaining will be our missing number

        int xorAct = 0;
        int xorCurr = 0;
        for (int i = 0; i <= nums.length; i++) {
            xorAct = xorAct ^ i;
        }
        for (int num : nums) {
            xorCurr = xorCurr ^ num;
        }
        int ans = xorAct ^ xorCurr;
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {9,6,4,2,3,5,7,0,1};
        int ans = missingNum(nums);
        System.out.println(ans);
    }
}
