package Arrays;

public class SmallSubSumMoreThanK {
    public static int findSmallLength(int[]arr, int k){
        int smallestLength = Integer.MAX_VALUE;
        int left = 0;
        int currSum = 0;
        int n = arr.length;

        for(int right = 0; right < n; right++){
            //add current to currSUm
            currSum += arr[right];
            //maintain sum > k and reduce window as much as possible
            while(currSum > k){
                smallestLength = Math.min(smallestLength, right - left + 1);
                currSum -= arr[left];
                left++;
            }
        }
        return smallestLength == Integer.MAX_VALUE ? -1 : smallestLength;
    }
    public static void main(String[] args) {
        int arr[] = {1, 4, 45, 6, 0, 19};
        int k = 51;
        int smallSub = findSmallLength(arr, k);
        System.out.println(smallSub);
    }
}
