package net.talaatharb.ohce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OhceTests {

	private Ohce ohce;

	private String userName;

	@BeforeEach
	void setup() {
		userName = "Pedro";

		// constructor can be different to allow dependency injection
		ohce = new Ohce(userName);
	}

	@ParameterizedTest
	@CsvSource(value = { "21,¡Buenas noches", "7,¡Buenos días", "13,¡Buenas tardes" })
	void testAtStartAndOutputsCorrectWelcomeMessage(int hour, String welcome) {
		// TODO test that we get different welcome message for different hours

		// Arrange

		// Action
		ohce.run();

		// Assert
	}

	@Test
	void testOutputsReverse() {
		// TODO test reversing strings

		// Arrange
		String message = "echo";
		String expected = "ohce";

		// Action
		ohce.run();

		// Assert
	}

	@Test
	void testHandlesPalindrome() {
		// TODO test the handling of a palindrome

		// Arrange
		String message = "oto";

		// Action
		ohce.run();

		// Assert
	}

	@Test
	void testStopsWhenSentStopPhrase() {
		// TODO test stop phrase behavior

		// Arrange
		String message = Ohce.STOP_PHRASE;

		// Action
		ohce.run();

		// Assert
	}

}
