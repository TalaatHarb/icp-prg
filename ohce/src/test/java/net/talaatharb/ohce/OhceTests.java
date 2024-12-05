package net.talaatharb.ohce;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OhceTests {

	private Ohce ohce;

	private String userName;
	
	@Mock
	private SystemTime systemTime;

	@Mock
	private InputSystem inputSystem;

	@Mock
	private OutputSystem outputSystem;

	@BeforeEach
	void setup() {
		userName = "Pedro";

		ohce = new Ohce(userName, systemTime, inputSystem, outputSystem);
	}

	@ParameterizedTest
	@CsvSource(value = { "21,¡Buenas noches", "7,¡Buenos días", "13,¡Buenas tardes" })
	void testAtStartAndOutputsCorrectWelcomeMessage(int hour, String welcome) {
		// Arrange
		when(systemTime.getHour()).thenReturn(hour);
		when(inputSystem.getInput()).thenReturn(Ohce.STOP_PHRASE);

		// Action
		ohce.run();

		// Assert
		verify(outputSystem).output(welcome + " " + userName);
	}

	@Test
	void testOutputsReverse() {
		// Arrange
		String message = "echo";
		String expected = "ohce";
		when(inputSystem.getInput()).thenReturn(message).thenReturn(Ohce.STOP_PHRASE);

		// Action
		ohce.run();

		// Assert
		final var outputCaptor = ArgumentCaptor.forClass(String.class);

		verify(outputSystem, times(3)).output(outputCaptor.capture());

		assertEquals(expected, outputCaptor.getAllValues().get(1));
	}

	@Test
	void testHandlesPalindrome() {
		// Arrange
		String message = "oto";
		when(inputSystem.getInput()).thenReturn(message).thenReturn(Ohce.STOP_PHRASE);

		// Action
		ohce.run();

		// Assert
		final ArgumentCaptor<String> outputCaptor = ArgumentCaptor.forClass(String.class);

		verify(outputSystem, times(4)).output(outputCaptor.capture());

		final var outputedValues = outputCaptor.getAllValues();
		assertEquals(message, outputedValues.get(1));
		assertEquals("¡Bonita palabra!", outputedValues.get(2));
	}

	@Test
	void testStopsWhenSentStopPhrase() {
		// Arrange
		when(inputSystem.getInput()).thenReturn(Ohce.STOP_PHRASE);

		// Action
		ohce.run();

		// Assert
		verify(outputSystem).output("Adios " + userName);
	}

}
