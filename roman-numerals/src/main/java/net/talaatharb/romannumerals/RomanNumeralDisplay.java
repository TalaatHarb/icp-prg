package net.talaatharb.romannumerals;

public class RomanNumeralDisplay {

	private static final int[] ARABIC_NUMBERS = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	private static final String[] ROMAN_NUMERALS = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
			"V", "IV", "I" };

	public String convertToRomanNumeral(int arabicNumber) {
		StringBuilder resultBuilder = new StringBuilder();

		for (int i = 0; i < ARABIC_NUMBERS.length; i++) {
			while (arabicNumber >= ARABIC_NUMBERS[i]) {
				resultBuilder.append(ROMAN_NUMERALS[i]);
				arabicNumber -= ARABIC_NUMBERS[i];
			}
		}

		return resultBuilder.toString();
	}
}
