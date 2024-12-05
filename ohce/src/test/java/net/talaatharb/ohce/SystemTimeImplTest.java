package net.talaatharb.ohce;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SystemTimeImplTest {

	@Test
	void testGetHour() {
		SystemTime systemTime = new SystemTimeImpl();
		final var hour = systemTime.getHour();
		
		assertTrue(hour >= 0);
		assertTrue(hour <= 24);
	}

}
