package String;

import java.util.Stack;

public class SuperReducedString {
    public static String reduce(String s){
        String ans = "";
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(stack.isEmpty() || c != stack.peek()){
                stack.push(c);
            }else{
                stack.pop();
            }
        }
        if(stack.isEmpty()) {
            ans = "Empty String";
        }else{
            for(char c : stack){
                ans += c;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "aaabccddd";
        String ans = reduce(s);   //abd
        System.out.println(ans);
    }
}
