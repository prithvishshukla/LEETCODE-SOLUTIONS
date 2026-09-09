class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        StringBuilder vowels = new StringBuilder();

        for (char c : arr) {
            if (isVowel(c)) {
                vowels.append(c);
            }
        }

        vowels.reverse();

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isVowel(arr[i])) {
                arr[i] = vowels.charAt(j++);
            }
        }

        return new String(arr);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}