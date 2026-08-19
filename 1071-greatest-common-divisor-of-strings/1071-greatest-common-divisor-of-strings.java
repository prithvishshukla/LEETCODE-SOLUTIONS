class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String ans = "";

        int n = Math.min(str1.length(), str2.length());

        for (int i = 1; i <= n; i++) {
            String x = str1.substring(0, i);

            if (check(str1, x) && check(str2, x)) {
                ans = x;
            }
        }

        return ans;
    }

    public boolean check(String str, String x) {
        String temp = "";

        while (temp.length() < str.length()) {
            temp += x;
        }

        return temp.equals(str);
    }
}