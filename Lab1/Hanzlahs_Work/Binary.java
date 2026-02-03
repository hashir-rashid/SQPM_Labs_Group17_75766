package com.ontariotechu.sofe3980U;

/**
 * The Binary class represents a binary number and provides
 * static methods to perform binary arithmetic and bitwise operations.
 */
public class Binary
{
	/** Stores the binary number as a string */
	private String number = "0";

	/**
	 * Constructs a Binary object from a string.
	 * The input is validated to ensure it contains only
	 * binary digits ('0' or '1'). Leading zeros are removed.
	 * If the input is invalid or empty, the value defaults to "0".
	 *
	 * @param number a string representing a binary number
	 */
	public Binary(String number) {
		if (number == null || number.length() == 0) {
			this.number = "0";
			return;
		}

		for (char c : number.toCharArray()) {
			if (c != '0' && c != '1') {
				this.number = "0";
				return;
			}
		}

		int start = 0;
		while (start < number.length() && number.charAt(start) == '0') {
			start++;
		}

		this.number = (start == number.length()) ? "0" : number.substring(start);
	}

	/**
	 * Returns the binary value stored in this object.
	 *
	 * @return binary number as a string
	 */
	public String getValue() {
		return number;
	}

	/**
	 * Adds two binary numbers.
	 *
	 * @param a first binary number
	 * @param b second binary number
	 * @return Binary object representing the sum
	 */
	public static Binary add(Binary a, Binary b) {
		int i = a.number.length() - 1;
		int j = b.number.length() - 1;
		int carry = 0;
		StringBuilder result = new StringBuilder();

		while (i >= 0 || j >= 0 || carry == 1) {
			int sum = carry;

			if (i >= 0) sum += (a.number.charAt(i--) == '1') ? 1 : 0;
			if (j >= 0) sum += (b.number.charAt(j--) == '1') ? 1 : 0;

			result.insert(0, (sum % 2 == 0) ? '0' : '1');
			carry = sum / 2;
		}
		return new Binary(result.toString());
	}

	/**
	 * Performs a bitwise OR operation on two binary numbers.
	 *
	 * @param a first binary number
	 * @param b second binary number
	 * @return Binary object representing the OR result
	 */
	public static Binary OR(Binary a, Binary b) {
		int i = a.number.length() - 1;
		int j = b.number.length() - 1;
		StringBuilder out = new StringBuilder();

		while (i >= 0 || j >= 0) {
			char x = (i >= 0) ? a.number.charAt(i--) : '0';
			char y = (j >= 0) ? b.number.charAt(j--) : '0';
			out.insert(0, (x == '1' || y == '1') ? '1' : '0');
		}
		return new Binary(out.toString());
	}

	/**
	 * Performs a bitwise AND operation on two binary numbers.
	 *
	 * @param a first binary number
	 * @param b second binary number
	 * @return Binary object representing the AND result
	 */
	public static Binary AND(Binary a, Binary b) {
		int i = a.number.length() - 1;
		int j = b.number.length() - 1;
		StringBuilder out = new StringBuilder();

		while (i >= 0 || j >= 0) {
			char x = (i >= 0) ? a.number.charAt(i--) : '0';
			char y = (j >= 0) ? b.number.charAt(j--) : '0';
			out.insert(0, (x == '1' && y == '1') ? '1' : '0');
		}
		return new Binary(out.toString());
	}

	/**
	 * Multiplies two binary numbers using repeated shifting and addition.
	 *
	 * @param a first binary number
	 * @param b second binary number
	 * @return Binary object representing the product
	 */
	public static Binary Multiply(Binary a, Binary b) {
		Binary total = new Binary("0");
		Binary shifted = new Binary(a.number);

		for (int k = b.number.length() - 1; k >= 0; k--) {
			if (b.number.charAt(k) == '1') {
				total = Binary.add(total, shifted);
			}
			shifted = new Binary(shifted.number + "0");
		}
		return total;
	}
}
