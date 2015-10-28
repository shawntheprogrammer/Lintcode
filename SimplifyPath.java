/*Given an absolute path for a file (Unix-style), simplify it.
**
**For example,
**path = "/home/", => "/home"
**path = "/a/./b/../../c/", => "/c"
*/
public class Solution {
    public String simplifyPath(String path) {
        // Write your code here
        if (path == null || path.length() == 0 || path.equals("/")) {
            return path;
        }
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            String token = arr[i];
            if (token.equals(".") || token.length() == 0) {
                continue;
            } else if (token.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(token);
            }
        }
        String res = "";
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res;
    }
}
