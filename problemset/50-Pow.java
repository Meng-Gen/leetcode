class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return myPow(1.0 / x, -1-n) / x;
        }
        if (n == 0) {
            return 1.0;
        }
        double y = 1.0;
        while (n > 1) {
            if (n % 2 == 0) {
                x = x * x;
                n = n / 2;
            } else {
                y = x * y;
                x = x * x;
                n = (n - 1) / 2;
            }
        }
        return x * y;
    }
}