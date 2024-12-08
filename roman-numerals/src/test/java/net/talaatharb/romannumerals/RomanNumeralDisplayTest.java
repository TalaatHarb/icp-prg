package net.talaatharb.romannumerals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RomanNumeralDisplayTest {
	
	RomanNumeralDisplay romanNumeralDisplay;
	
	@BeforeEach
	void setup() {
		romanNumeralDisplay = new RomanNumeralDisplay();
	}
	
	@ParameterizedTest(name = "Should convert {0} to {1}")
	@CsvSource(value = {
			"1, I",
			"2, II",
			"3, III",
			"4, IV",
			"5, V",
			"7, VII",
			"9, IX",
			"1990, MCMXC", 
			"2008, MMVIII", 
			"99, XCIX", 
			"47, XLVII", 
	})
	void testAcceptanceOfMultipleExamples(final int arabicNumber, final String expectedResult ) {		
		// Act
		final String result = romanNumeralDisplay.convertToRomanNumeral(arabicNumber);
		
		// Assert
		assertEquals(expectedResult, result);
	}

}
