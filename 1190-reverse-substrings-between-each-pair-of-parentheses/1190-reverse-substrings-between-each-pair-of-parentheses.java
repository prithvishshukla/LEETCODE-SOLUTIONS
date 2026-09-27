class Solution {
    public String reverseParentheses(String s) {

        while (s.contains("(")) {

            int open = -1;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    open = i;
                }
            }

            int close = -1;

            for (int i = open; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    close = i;
                    break;
                }
            }

            String part = s.substring(open + 1, close);

            String reverse = "";

            for (int i = part.length() - 1; i >= 0; i--) {
                reverse += part.charAt(i);
            }

            s = s.substring(0, open)
                    + reverse
                    + s.substring(close + 1);
        }

        return s;
    }
}