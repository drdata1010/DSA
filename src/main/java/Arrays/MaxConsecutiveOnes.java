package Arrays;

public class MaxConsecutiveOnes {
    public static int missingNum(int [] nums){
        int maxOnes = 0;
        int curr = 0;
        for(int i = 0; i < nums.length; i++){

            if(nums[i] != 0){
                curr++;
                maxOnes = Math.max(maxOnes,curr);
            }else{
                curr = 0;
            }
        }
        return maxOnes;
    }
    public static void main(String[] args) {
        int nums[] = {1,0,1,1,0,1};
        int ans = missingNum(nums);
        System.out.println(ans);
    }
}
