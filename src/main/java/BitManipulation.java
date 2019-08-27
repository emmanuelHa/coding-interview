public class BitManipulation {

    public static int updateBits(int n, int m, int i, int j) {

        int max = ~0; /* All 1’s */
        // 1’s through position j, then 0’s
        int left = max - ((1 << j) - 1);
        // 1’s after position i
        int right = ((1 << i) - 1);
        // 1’s, with 0s between i and j
        int mask = left | right;
        // Clear i through j, then put m in there
        return (n & mask) | (m << i);
    }


    public static String printBinary(String n) {

        int intPart = Integer.parseInt(n.substring(0, n.indexOf('.')));
        double decPart = Double.parseDouble(
                n.substring(n.indexOf('.'), n.length()));
        String int_string = "";
        while (intPart > 0) {
            int r = intPart % 2;
            intPart >>= 1;
            int_string = r + int_string;
        }
        StringBuffer dec_string = new StringBuffer();
        while (decPart > 0) {
            if (dec_string.length() > 32) return "ERROR";
            if (decPart == 1) {
                dec_string.append((int)decPart);
                break;
            }
            double r = decPart * 2;
            if (r >= 1) {
                dec_string.append(1);
                decPart = r - 1;
            } else {
                dec_string.append(0);
                decPart = r;
            }
        }
        return int_string + "." + dec_string.toString();
    }


    /**
     * Counts the number of different bits between a and b
     * @param a first number whose bits are to be compared
     * @param b second number whose bits are to be compared
     * @return number of different bits between a and b
     */
    public static int bitSwapRequired(int a, int b) {

        int count = 0;
        for (int c = a ^ b; c != 0; c = c >> 1) {
            count += c & 1;
        }
        return count;
    }
}
