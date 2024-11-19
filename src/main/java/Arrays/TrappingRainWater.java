package Arrays;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int n = height.length;
        int lmax[] = new int[n];
        int rmax[] = new int[n];

        //prepare lmax
        lmax[0] = height[0];
        for(int i = 1; i < n; i++){
            lmax[i] = Math.max(lmax[i-1],height[i]);
        }
        //prepare rmax
        rmax[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--){
            rmax[i] = Math.max(rmax[i+1], height[i]);
        }
        //calculate water
        int water = 0;
        for(int i = 1; i < n-1; i++){
            water = water + Math.min(lmax[i],rmax[i]) - height[i];
        }
        return water;
    }
    public static void main(String[] args) {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int ans = trap(height);
        System.out.println(ans);
    }
}
