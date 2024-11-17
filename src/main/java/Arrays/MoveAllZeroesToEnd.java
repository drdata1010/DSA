package Arrays;

public class MoveAllZeroesToEnd {
    public static int[] movesZeroesToEnd(int arr[], int n){
        //Brute
//        for(int i = 0; i < n; i++){
//            if(arr[i] == 0){
//                for(int j = i+1; j < n; j++){
//                    if(arr[j] != 0){
//                        int temp = arr[j];
//                        arr[j] = arr[i];
//                        arr[i] = temp;
//                    }
//                }
//            }
//        }
        //Optimized
        //Two Pointers
        int zero = 0;
        for(int nonZero = 0; nonZero < n; nonZero++){
            if(arr[nonZero] != 0){
                int temp = arr[nonZero];
                arr[nonZero] = arr[zero];
                arr[zero] = temp;
                zero++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int arr[] = {8,5,0,0,0,20};
        int n = arr.length;
        int res[] = movesZeroesToEnd(arr,n);
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
