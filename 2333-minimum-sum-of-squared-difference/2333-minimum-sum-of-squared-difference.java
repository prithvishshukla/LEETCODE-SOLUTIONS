class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        int[] diff = new int[n];

        int max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        if (k >= Arrays.stream(diff).asLongStream().sum()) {
            return 0;
        }

        int[] count = new int[100001];

        for (int d : diff) {
            count[d]++;
        }

        for (int i = max; i > 0 && k > 0; i--) {
            if (count[i] == 0) {
                continue;
            }

            int next = i - 1;
            long operations = (long) count[i] * (i - next);
            long use = Math.min(k, operations);

            count[i] -= (int) (use / (i - next));
            count[next] += (int) (use / (i - next));

            if (use % (i - next) != 0) {
                count[i]--;
                count[i - (int) (use % (i - next))]++;
            }

            k -= use;
        }

        long answer = 0;

        for (int i = 1; i < count.length; i++) {
            answer += (long) i * i * count[i];
        }

        return answer;
    }
}

