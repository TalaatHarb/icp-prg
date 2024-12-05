package net.talaatharb.ohce;

import static org.mockito.Mockito.verify;

import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OutputSystemImplTest {
	
	@InjectMocks
	private OutputSystemImpl outputSystem;
	
	@Mock
	private PrintStream outputStream; 

	@Test
	void testOutputSystemWorks() {
		String text = "Test";
		outputSystem.output(text);
		verify(outputStream).println("> " + text);
	}

}
