package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int longestCons(int[]arr){
        //first we add all to set
        Set<Integer> set = new HashSet<>();
        for(int num : arr){
            set.add(num);
        }
        int longest = 0;
        //we find number from where max streak can start
        for(int num : arr){
            if(!set.contains(num - 1)){
                int currNum = num; //possible starting point of streak
                int streak = 1; //start by counting
                while(set.contains(currNum+1)){//we find next consecutive number
                    currNum = currNum + 1; //if found increase currNum as well to keep looking for consecutive number
                    streak++; //keep updating streak as well
                }
                //now we update longest streak
                longest = Math.max(longest,streak);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] arr = {0,3,7,2,5,8,4,6,0,1};
        int longestStreak = longestCons(arr);
        System.out.println(longestStreak);
    }
}
