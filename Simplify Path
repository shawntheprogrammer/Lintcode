/*Given an absolute path for a file (Unix-style), simplify it.
**
**For example,
**path = "/home/", => "/home"
**path = "/a/./b/../../c/", => "/c"
*/
public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }
        ArrayList<String> list = new ArrayList<>();
        int start = 0;
        // split the path by '/'
        for (int i = 0; i < path.length(); i++)  {
            if (path.charAt(i) == '/') {
                if (start != i) {
                    list.add(path.substring(start, i));
                }
                start = i + 1;
            }
        }
        // add the rightmost part if last char is not '/'
        if (start != path.length()) {
            list.add(path.substring(start));
        }
        // add things to stack, ignore "."
        // back up one level if it's ".." and stack is not empty, otherwise we are at the root
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(".")) {
                continue;
            } else if (list.get(i).equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(list.get(i));
            }
        }
        // add things up to the result
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        // if empty path, stay in root
        if (res.length() == 0) {
            return  "/";
        }
        return res;
    }
}
