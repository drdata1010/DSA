package String;

public class IsAnagram {
    public static void checkAnagram(String s, String t){
        if(s.length() != t.length()) {
            System.out.println("FALSE");
            return;
        }
        int freq[] = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < s.length(); i++){
            if(freq[s.charAt(i) - 'a'] != 0) {
                System.out.println("FALSE");
                return;
            }
        }
        System.out.println("TRUE");
        return;
    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        checkAnagram(s,t);
    }
}
