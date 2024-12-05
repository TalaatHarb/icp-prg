package net.talaatharb.ohce;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class InputSystemImplTest {
	
	@InjectMocks
	private InputSystemImpl inputSystem;
	
	@Mock
	private Scanner scanner;
	
	@Mock
	private OutputSystem outputSystem;

	@Test
	void testInputSystemWorks() {
		String expected = "Test";
		when(scanner.nextLine()).thenReturn(expected);
		String message = inputSystem.getInput();
		
		assertEquals(expected, message);
		
	}

}
