package String;

import java.util.*;

class Result {

    public static int productSum(List<Object> array) {
        return specialArrays(array, 1);
    }

    private static int specialArrays(List<Object> array, int currentLevel) {
        if (array == null || array.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (Object elem : array) {
            if (elem instanceof List) {
                @SuppressWarnings("unchecked")
                List<Object> innerList = (List<Object>) elem;
                sum += specialArrays(innerList, currentLevel + 1);
            } else if (elem instanceof Integer) {
                sum += (int) elem;
            }
        }

        return sum * currentLevel;
    }
    public static List<Object> parseInput(String s){
        return helper(s, new int[]{0});
    }
    private static List<Object> helper(String s, int[] index) {
        List<Object> result = new ArrayList<>();
        int num = 0;
        boolean isNegative = false;
        boolean buildingNumber = false;

        while (index[0] < s.length()) {
            char c = s.charAt(index[0]++);

            if (c == '-') {
                isNegative = true;
            } else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                buildingNumber = true;
            } else if (c == '[') {
                // Start a new nested list
                result.add(helper(s, index));  // recursive call to handle the inner list
            } else if (c == ',' || c == ']') {
                // End the current number and add it to the list
                if (buildingNumber) {
                    result.add(isNegative ? -num : num);
                    num = 0;
                    isNegative = false;
                    buildingNumber = false;
                }

                if (c == ']') {
                    // End the current list and return
                    break;
                }
            }
        }

        return result;
    }

}

public class Solution {
    public static void printParsedArray(List<Object> array) {
        for (Object obj : array) {
            if (obj instanceof List) {
                System.out.print("[");
                printParsedArray((List<Object>) obj); // Recursive call to print nested lists
                System.out.print("]");
            } else {
                System.out.print(obj + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String s = "[5,2,[7,-1],3,[6,[-13,8],4]]";
        List<Object> parsedArray = Result.parseInput(s);
        printParsedArray(parsedArray);  // Custom print function to print in a cleaner way
        int productSum = Result.productSum(parsedArray);
        System.out.println(productSum); // Output: 12
    }
}