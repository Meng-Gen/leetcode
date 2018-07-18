class Solution {
    public int maxCoins(int[] nums) {
        int ballonsCount = nums.length;
        nums = addVirtualBalloons(nums);
        
        // c[i][j] = maxCoins(nums[i : j+1]).
        int[][] c = new int[ballonsCount + 2][ballonsCount + 2];
        for (int currLength = 1; currLength <= ballonsCount; currLength++) {
            for (int i = 1; i <= ballonsCount - currLength + 1; i++) {
                int j = i + currLength - 1;
                for (int k = i; k <= j; k++) {
                    c[i][j] = Math.max(c[i][j], c[i][k - 1] + nums[i - 1] * nums[k] * nums[j + 1] + c[k + 1][j]);
                }
            }
        }
        
        return c[1][ballonsCount];
    }
    
    private int[] addVirtualBalloons(int[] nums) {
        int[] virtual = new int[nums.length + 2];
        virtual[0] = 1;
        virtual[nums.length + 1] = 1;
        for (int i = 1; i <= nums.length; i++) {
            virtual[i] = nums[i - 1];
        }
        return virtual;
    }
}