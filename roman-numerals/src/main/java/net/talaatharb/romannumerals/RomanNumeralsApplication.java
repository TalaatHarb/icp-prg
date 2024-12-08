package net.talaatharb.romannumerals;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RomanNumeralsApplication {
	
	public static void main(String[] args) {
		log.trace("Application Started");
		
		var romanNumeralDisplay = new RomanNumeralDisplay();
		
		for(int i = 1; i< 3999; i++) {
			log.info("{}\t\t{}", i , romanNumeralDisplay.convertToRomanNumeral(i));
		}	
		
		log.trace("Application finished");
	}
}