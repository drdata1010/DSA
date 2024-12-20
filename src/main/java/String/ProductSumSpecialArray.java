import java.io.*;

class Result {

    public static int ProductSum(String input) {
        int[] index = {0};  // Array to keep track of the current position in the string
        return calculateProductSum(input, index, 1);  // Start with depth = 1
    }

    private static int calculateProductSum(String input, int[] index, int depth) {
        int sum = 0;
        int currentNumber = 0;
        boolean isNegative = false;

        while (index[0] < input.length()) {
            char c = input.charAt(index[0]++);

            if (c == '-') {
                isNegative = true;  // Negative number detected
            } else if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');  // Build the current number
            } else if (c == '[') {
                // Start of a nested array, go deeper
                sum += calculateProductSum(input, index, depth + 1);
            } else if (c == ',' || c == ']') {
                // Finish parsing the current number
                if (isNegative) {
                    currentNumber = -currentNumber;
                }
                sum += currentNumber;

                // Reset for the next number and sign
                currentNumber = 0;
                isNegative = false;

                if (c == ']') {
                    // End of the current array
                    break;
                }
            }
        }
        return sum * depth;  // Multiply the sum by its depth
    }
}

public class ProductSumSpecialArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Read input string
        String s = bufferedReader.readLine();

        // Calculate the product sum
        int result = Result.ProductSum(s);

        // Print the output to the console
        System.out.println(result);

        bufferedReader.close();
    }
}
