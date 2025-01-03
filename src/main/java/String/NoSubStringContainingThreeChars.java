package String;

import java.util.HashSet;
import java.util.Set;

public class NoSubStringContainingThreeChars {
    private static int findNoSubstrings(String s){
        int count = 0; int n = s.length();
        //find no of substring so generate all substrings

        for(int i = 0 ; i < n; i++){
            Set<Character> set = new HashSet<>();
            for(int j = i; j < n; j++){
                set.add(s.charAt(j));
                if(set.size() == 3){
                    count+=n-j;
                    break;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "bcaacbbccaacacaccacccacbabaaaabcababcbbbbbacbcbababcaabcababbcbcbacbbbcaababbbbacbcabbccbbccbbcbbbbbcacaabacaccabbacccaacacbcaabbbccbbbcbabbbbcaccbabaaabcacaabbbcaabbbcbcabbbacabbbbacccbaccbcbaaacccacccbaaaabbabccbcacaabcbacabbcabacbcbababbbcaccaaccbbccaccacacbbcbcaacaabcbbcabccbacbbcbabbaaabaccccabaaccbbabbbaccacbcbacabcaccbabccbacabcbacbababaccccbbbccbbbbcacbcbbaababbccbaccaccaaabaabbcacbbabcaccbaacbbaabcbaababcbabccbbbbbbaccccacacaacacbccbabaabbcccbaaacabbcccbbaacbcccbaccabaaaabacbaccacabbbacccccbbaaaaccbcbabacbbbcaaacbccaccbabacbcbacbbbabcaccbacbcacbabbaaaaaccabcaacbaaaaacbcbacbabcaaaacabcacbbaaaccccbcbaccbcabccbbcacbcaabbbbbbcbcacabbbabaababcacbbbabbcccccbcccbbbcacbaabcbabbacbacbcbcabaabbc";
        int ans = findNoSubstrings(s);
        System.out.println(ans);
    }
}
