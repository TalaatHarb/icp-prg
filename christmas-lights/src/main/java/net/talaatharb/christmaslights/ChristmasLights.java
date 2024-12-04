package net.talaatharb.christmaslights;

public class ChristmasLights {

	public static final int SIZE = 1000;

	private boolean[][] lights;

	public ChristmasLights() {
		// Construct Christmas lights
		lights = new boolean[SIZE][SIZE];
	}

	public boolean getStatus(int x, int y) {
		// return status at coordinates (x, y)
		return lights[x][y];
	}

	public void turnOnAll() {
		// turn on all lights
		turnOn(0, 0, SIZE - 1, SIZE - 1);
	}

	public void turnOffAll() {
		// turn off all lights
		turnOff(0, 0, SIZE - 1, SIZE - 1);
	}

	public void turnOn(int startX, int startY, int endX, int endY) {
		// turn on range
		for (int y = startY; y < endY + 1; y++) {
			for (int x = startX; x < endX + 1; x++) {
				lights[x][y] = true;
			}
		}
	}

	public void turnOff(int startX, int startY, int endX, int endY) {
		// turn off range
		for (int y = startY; y < endY + 1; y++) {
			for (int x = startX; x < endX + 1; x++) {
				lights[x][y] = false;
			}
		}
	}

	public void toggle(int startX, int startY, int endX, int endY) {
		// toggle range
		for (int y = startY; y < endY + 1; y++) {
			for (int x = startX; x < endX + 1; x++) {
				lights[x][y] = !lights[x][y];
			}
		}
	}

	public int getTotalOn() {
		// get total number on
		return 0;
	}
}
