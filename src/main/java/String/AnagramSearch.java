package String;

import java.util.Arrays;

public class AnagramSearch {
    public static boolean isAnagramInSubstring(String t, String s) {
        if (s.length() > t.length()) return false;

        int[] sFreq = new int[26]; // Frequency array for 's'
        int[] tFreq = new int[26]; // Frequency array for current window in 't'

        // Populate frequency array for 's' and first window in 't'
        for (int i = 0; i < s.length(); i++) {
            sFreq[s.charAt(i) - 'a']++;
            tFreq[t.charAt(i) - 'a']++;
        }

        // Sliding window approach
        for (int i = s.length(); i < t.length(); i++) {
            if (Arrays.equals(sFreq, tFreq)) return true; // Check if current window is an anagram

            // Update the window
            tFreq[t.charAt(i) - 'a']++; // Add new character
            tFreq[t.charAt(i - s.length()) - 'a']--; // Remove old character
        }

        // Check the last window
        return Arrays.equals(sFreq, tFreq);
    }

    public static void main(String[] args) {
        String t1 = "geeksforgeeks";
        String s1 = "frog";
        System.out.println(isAnagramInSubstring(t1, s1)); // Output: true

        String t2 = "geeksforgeeks";
        String s2 = "rseek";
        System.out.println(isAnagramInSubstring(t2, s2)); // Output: false
    }
}

