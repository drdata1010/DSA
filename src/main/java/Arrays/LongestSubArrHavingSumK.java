package Arrays;

public class LongestSubArrHavingSumK {
    public static int lenOfLongestSubarr(int[] arr, int k) {
        // code here
        int maxLen = 0;
        int currSum = arr[0];
        int left = 0; int right = 0;
        int n = arr.length;

        while(right < n){

            //if sum > k, valid subarray check
            while(left <= right && currSum > k){
                currSum -= arr[left];
                left++;
            }
            //if sum == k
            if(currSum == k){
                maxLen = Math.max(right - left + 1, maxLen);
            }
            //if sum < k
            //keep adding to sum
            right++;
            if(right < n) currSum += arr[right];
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int nums[] = {10, 5, 2, 7, 1, 9};
        int k = 15;
        int ans = lenOfLongestSubarr(nums,k);
        System.out.println(ans);
    }
}
