class Solution {
    public int numDecodings(String s) {
        int[] digits = getDigits(s);
        int prev = (digits[0] != 0) ? 1 : 0;
        int curr = (digits[0] != 0) ? 1 : 0;
        for (int i = 1; i < digits.length; i++) {
            int next = 0;
            if (digits[i - 1] == 1 || ((digits[i - 1] == 2) && (digits[i] <= 6))) {
                next += prev;
            }
            if (digits[i] != 0) {
                next += curr;
            }
            prev = curr;
            curr = next;
        }
        return curr;
    }

    private int[] getDigits(String s) {
        int[] digits = new int[s.length()];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = s.charAt(i) - '0';
        }
        return digits;
    }
}