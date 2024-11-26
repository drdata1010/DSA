package Arrays.BinarySearch;

public class SearchInsertPosition {
    public static int searchInsert(int[] a, int k) {
        int n = a.length;
        int low = 0; int high = n - 1;
        if(a[low] > k) return 0;
        if(a[high] < k) return n;
        int ans = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(low == high && high == mid) return ans;
            if(a[mid] == k){
                return mid;
            }else if(a[mid] > k){
                high = mid - 1;
                ans = high;
            }else {
                low = mid + 1;
            }
            System.out.println(ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,3,5,6};
        int k = 5;
        int ans = searchInsert(arr, k);
        System.out.println(ans);
    }
}
/*
1 3 5 6
k=5
l=0 h=3
m = 1
3 < 5, move right

l=2,h=3
m=2
5==5 return 2

k=2
1 3 5 6
l=0 h=3
m=1
3>2, move left
h=mid-1, 1-1=0
l=0
m=0
1<2
l=0+1=1
h=0
end of while


 */
