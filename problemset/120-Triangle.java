class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<Integer> bottom = triangle.get(n - 1);
        int[] minSums = new int[n];
        for (int i = 0; i < n; i++) {
            minSums[i] = bottom.get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> layer = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                minSums[j] = Math.min(minSums[j], minSums[j + 1]) + layer.get(j);
            }
        }
        return minSums[0];
    }
}