class Solution {
    public int reverseDegree(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            int normal = ch - 'a' + 1;
            int reverse = 27 - normal;

            sum += reverse * (i + 1);
        }

        return sum;
    }
}