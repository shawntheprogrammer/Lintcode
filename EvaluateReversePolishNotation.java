public class Solution {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        // Write your code here
        Stack<String> nums = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (isOperator(token)) {
                int right = Integer.valueOf(nums.pop());
                int left = Integer.valueOf(nums.pop());
                nums.push(calculate(left, right, token));
            } else {
                nums.push(token);
            }
        }
        return Integer.valueOf(nums.pop());
    }
    
    public boolean isOperator(String token) {
        if (token.length() != 1) {
            return false;
        }
        char c = token.charAt(0);
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            return true;
        } else {
            return false;
        }
    }
    
    public String calculate(int left, int right, String operator) {
        if (operator.equals("+")) {
            return String.valueOf(left + right);
        } else if (operator.equals("-")) {
            return String.valueOf(left - right);
        } else if (operator.equals("*")) {
            return String.valueOf(left * right);
        } else {
            return String.valueOf(left / right);
        }
    }
}
