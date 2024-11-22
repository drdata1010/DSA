package Arrays;

public class SortColors {
    public static int[] sort(int []arr){
        int n = arr.length;
        int low = 0; int mid = 0; int high = n-1;
        while(mid <= high){
            //if mid is 0, swap with low and move low, mid by 1
            //if mid is 1, move mid by 1
            //if mid is 2, swap with high and decrease high
            if(arr[mid] == 0){
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }else if(arr[mid] == 1){
                mid++;
            }else{
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int arr[] = {2,0,2,1,1,0};
        int n = arr.length;
        int ans[] = sort(arr);
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i]+" ");
        }
    }
}
