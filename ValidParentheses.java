/*  Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	Example
	The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class ValidParentheses {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
      if (s == null || s.length() == 0) {
          return false;
      }
      Stack<Character> stack = new Stack<>();
      for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (stack.isEmpty() || !isMatch(stack.peek(), c)) {
              stack.push(c);
          } else {
              stack.pop();
          }
      }
      return !stack.isEmpty();
    }
    
    public boolean isMatch(char a, char b) {
        if (a == null || b == null) {
            return false;
        }
        if ((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}')){
            return true;
        }
        return false;
    }
    
    @Test
    public void test() {
        String s = "()";
        assertTrue(isValidParenthese(s));
    }
}
