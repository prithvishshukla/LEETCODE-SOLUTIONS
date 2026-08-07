class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> result = new ArrayList<>();
        backtrack(0, n, k, 0, new StringBuilder(), result, false);
        return result;
    }

    private void backtrack(int index, int n, int k, int cost,
                           StringBuilder curr, List<String> result, boolean prevOne) {

        if (index == n) {
            if (cost <= k) {
                result.add(curr.toString());
            }
            return;
        }

        curr.append('0');
        backtrack(index + 1, n, k, cost, curr, result, false);
        curr.deleteCharAt(curr.length() - 1);

        if (!prevOne) {
            int newCost = cost + index;

            if (newCost <= k) {
                curr.append('1');
                backtrack(index + 1, n, k, newCost, curr, result, true);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }
}