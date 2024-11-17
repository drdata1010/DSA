package Arrays;

//Remove dupes from sorted array and return the length if distinct elements -- inplace
public class RemoveDupesFromSortedArray {
    public static int removeDupesReturnDistLen(int arr[], int n){
        int i = 0;
        for(int j = 1; j < n; j++){
            if(arr[i] != arr[j]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i + 1;
    }
    public static void main(String[] args) {
        int arr[] = {10,20,20,30,30,30};
        int n = arr.length;

        int ans = removeDupesReturnDistLen(arr,n);
        System.out.println(ans);
    }
}
