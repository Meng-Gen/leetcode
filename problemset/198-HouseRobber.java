class Solution {
    public int rob(int[] nums) {
        int visited = 0;
        int unvisited = 0;
        for (int i = 0; i < nums.length; i++) {
            int currVisited = unvisited + nums[i];
            int currUnvisited = Math.max(unvisited, visited);
            visited = currVisited;
            unvisited = currUnvisited;
        }
        return Math.max(unvisited, visited);
    }
}