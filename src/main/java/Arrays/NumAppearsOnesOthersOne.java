package Arrays;

public class NumAppearsOnesOthersOne {
    public static int appearsOnes(int [] nums){
        //simple approach is have frequency array, iterate it, return i having 1 count

        //optimized approach is xor of each element, one appearing once will remain in xor variable
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans = ans ^ nums[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {4,1,2,1,2};
        int ans = appearsOnes(nums);
        System.out.println(ans);
    }
}
