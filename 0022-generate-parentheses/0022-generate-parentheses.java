
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate("", n, ans);
        return ans;
    }

    void generate(String s, int n, List<String> ans) {
        if (s.length() == 2 * n) {
            if (isValid(s)) {
                ans.add(s);
            }
            return;
        }

        generate(s + "(", n, ans);
        generate(s + ")", n, ans);
    }

    boolean isValid(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                count--;

                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}