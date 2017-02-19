
public class Solution {
    private static final int LOG_BASE_5 = 5;
    private static final int EXP_BASE_2 = 2;

    public Solution() {

    }

    /**
     * This problem can be solved using Dynamic programming.
     * Note: No need to worry about synchronization/multi-threading as this method doesn't use any shared resources.
     * @param String s
     * @return Integer
     */
    public int getMin(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        long[] resultArray = new long[s.length() + 1];
        resultArray[0] = 0;
        for (int i = 1; i <= s.length(); i++) {
            resultArray[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (s.charAt(j - 1) == '0') {
                    continue;
                }
                long num = Long.parseLong(s.substring(j - 1, i), EXP_BASE_2);
                if (isPowerOfFive(num)) {
                    resultArray[i] = Math.min(resultArray[i], resultArray[j - 1] + 1);
                }
            }
        }

        return resultArray[s.length()] == Integer.MAX_VALUE ? -1 : (int) resultArray[s.length()];
    }

    /**
     * A utility method to verify if the number is a power of five.
     * @param num
     * @return boolean. True if it is a valid power of 5.
     */
    private boolean isPowerOfFive(long num) {
        if (num == 0) {
            return false;
        }
        int logExp = (int) (Math.log(num) / Math.log(LOG_BASE_5));
        return Math.pow(LOG_BASE_5, logExp) == num;
    }

}
