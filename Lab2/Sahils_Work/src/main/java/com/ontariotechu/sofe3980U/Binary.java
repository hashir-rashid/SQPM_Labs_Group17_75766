package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 */
public class Binary {
    private String number = "0"; // string containing the binary value '0' or '1'

    /**
     * A constructor that generates a binary object.
     *
     * @param number a String of the binary values. It should contain only zeros or ones
     *               with any length and order. otherwise, the value of "0" will be stored.
     *               Trailing zeros will be excluded and empty string will be considered as zero.
     */
    public Binary(String number) {
        if (number == null || number.isEmpty()) {
            this.number = "0";
            return;
        }

        // Validate the binary string (only '0' or '1' allowed)
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (ch != '0' && ch != '1') {
                this.number = "0";
                return;
            }
        }

        // Remove leading zeros
        int beg;
        for (beg = 0; beg < number.length(); beg++) {
            if (number.charAt(beg) != '0') {
                break;
            }
        }

        // If all digits are '0', ensure number is "0"
        this.number = (beg == number.length()) ? "0" : number.substring(beg);

        // Replace empty strings with a single zero
        if (this.number.isEmpty()) {
            this.number = "0";
        }
    }

    /**
     * Return the binary value of the variable
     */
    public String getValue() {
        return this.number;
    }

    /**
     * Adding two binary variables.
     */
    public static Binary add(Binary num1, Binary num2) {
        int ind1 = num1.number.length() - 1;
        int ind2 = num2.number.length() - 1;

        int carry = 0;
        String num3 = "";

        while (ind1 >= 0 || ind2 >= 0 || carry != 0) {
            int sum = carry;

            if (ind1 >= 0) {
                sum += (num1.number.charAt(ind1) == '1') ? 1 : 0;
                ind1--;
            }
            if (ind2 >= 0) {
                sum += (num2.number.charAt(ind2) == '1') ? 1 : 0;
                ind2--;
            }

            carry = sum / 2;
            sum = sum % 2;
            num3 = ((sum == 0) ? "0" : "1") + num3;
        }

        return new Binary(num3);
    }

    /**
     * Bitwise OR between two binary variables.
     */
    public static Binary or(Binary num1, Binary num2) {
        int ind1 = num1.number.length() - 1;
        int ind2 = num2.number.length() - 1;

        String num3 = "";

        while (ind1 >= 0 || ind2 >= 0) {
            int bit1 = 0;
            int bit2 = 0;

            if (ind1 >= 0) {
                bit1 = (num1.number.charAt(ind1) == '1') ? 1 : 0;
                ind1--;
            }
            if (ind2 >= 0) {
                bit2 = (num2.number.charAt(ind2) == '1') ? 1 : 0;
                ind2--;
            }

            int outBit = (bit1 == 1 || bit2 == 1) ? 1 : 0;
            num3 = ((outBit == 0) ? "0" : "1") + num3;
        }

        return new Binary(num3);
    }

    /**
     * Bitwise AND between two binary variables.
     */
    public static Binary and(Binary num1, Binary num2) {
        int ind1 = num1.number.length() - 1;
        int ind2 = num2.number.length() - 1;

        String num3 = "";

        while (ind1 >= 0 || ind2 >= 0) {
            int bit1 = 0;
            int bit2 = 0;

            if (ind1 >= 0) {
                bit1 = (num1.number.charAt(ind1) == '1') ? 1 : 0;
                ind1--;
            }
            if (ind2 >= 0) {
                bit2 = (num2.number.charAt(ind2) == '1') ? 1 : 0;
                ind2--;
            }

            int outBit = (bit1 == 1 && bit2 == 1) ? 1 : 0;
            num3 = ((outBit == 0) ? "0" : "1") + num3;
        }

        return new Binary(num3);
    }

    /**
     * Multiply two binary variables using shift-and-add.
     */
    public static Binary multiply(Binary num1, Binary num2) {
        if (num1.number.equals("0") || num2.number.equals("0")) {
            return new Binary("0");
        }

        Binary result = new Binary("0");

        int shift = 0;
        for (int i = num2.number.length() - 1; i >= 0; i--) {
            if (num2.number.charAt(i) == '1') {
                String shifted = num1.number;
                for (int k = 0; k < shift; k++) {
                    shifted = shifted + "0";
                }
                result = add(result, new Binary(shifted));
            }
            shift++;
        }

        return result;
    }
}
