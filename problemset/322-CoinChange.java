class Solution {
    private static final int NOT_FOUND = -1;

    public int coinChange(int[] coins, int amount) {
        int[] counts = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            counts[i] = NOT_FOUND;
        }

        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                int next = i + coin; // might overflow
                if ((next >= 0) && (next <= amount) && (counts[i] != NOT_FOUND)) {
                    if (counts[next] != NOT_FOUND) {
                        counts[next] = Math.min(counts[next], counts[i] + 1);
                    } else {
                        counts[next] = counts[i] + 1;
                    }
                }      
            }
        }
        return counts[amount];
    }
}