package Arrays.BinarySearch;

public class SearchInSortedRotatedArray {
    public static int returnTargetInd(int nums[], int target){
        int low = 0; int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) return mid;

            //check sorted half
            //left half
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid - 1;
                } else{
                    low = mid + 1;
                }
            }
            //right half
            else{
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int n = arr.length;
        int target = 0;
        int ans = returnTargetInd(arr,target);
        System.out.println(ans);
    }
}
