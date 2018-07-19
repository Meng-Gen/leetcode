class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev = cost[0];
        int curr = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int next = Math.min(prev, curr) + cost[i];
            prev = curr;
            curr = next;
        }
        return Math.min(prev, curr);
    }
}