package net.talaatharb.christmaslights;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChristmasLightsTests {

	private static final int SIZE = ChristmasLights.SIZE;

	private ChristmasLights christmasLights;

	@BeforeEach
	void setup() {
		// arrange: construct the Christmas lights
		christmasLights = new ChristmasLights();
	}

	@Test
	void testWhenStartedAllLightsAreOff() {
		// action = nothing

		// assert all turned off
	}

	@Test
	void testTurnOnAllLightsTurnsAllOn() {
		// action = turn on all

		// assert all turned on

	}

	@Test
	void testTurnOffAllLightsTurnsAllOff() {
		// action = turn off all after turning on

		// assert all turned on
	}

	@Test
	void testTurnOnRange() {
		// action = turn on (0,0) -> (999, 0) 'first row'

		// assert range is turned on and rest is off
	}

	@Test
	void testTurnOffRange() {
		// action = turn off (499,499) -> (500,500) 'four squares in the middle'

		// assert range is turned off and rest is on
	}

	@Test
	void testToggleRange() {
		// action = toggle (0,0) -> (999, 0) 'first row'

		// assert range is turned on and rest is off
	}
}
