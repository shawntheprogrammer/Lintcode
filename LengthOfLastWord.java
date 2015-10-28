
public class LengthOfLastWord {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int end = 0;
        int start = 0;
        boolean found = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                if (!found) {
                    found = true;
                    end = i;
                }
                start = i;
            } else if (found) {
                break;
            }
        }
        return (found == true) ? (end - start + 1) : 0;
    }
}
