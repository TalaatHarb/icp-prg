package net.talaatharb.christmaslights;

public class ChristmasLights {

	public static final int SIZE = 1000;

	private final int[][] brightness;

	public ChristmasLights() {
		// Construct Christmas lights
		brightness = new int[SIZE][SIZE];
	}

	public boolean getStatus(int x, int y) {
		// return status at coordinates (x, y)
		return brightness[x][y] > 0;
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
				brightness[x][y]++;
			}
		}
	}

	public void turnOff(int startX, int startY, int endX, int endY) {
		// turn off range
		for (int y = startY; y < endY + 1; y++) {
			for (int x = startX; x < endX + 1; x++) {
				brightness[x][y] = brightness[x][y] == 0 ? 0 : brightness[x][y] - 1;
			}
		}
	}

	public void toggle(int startX, int startY, int endX, int endY) {
		// toggle range
		for (int y = startY; y < endY + 1; y++) {
			for (int x = startX; x < endX + 1; x++) {
				brightness[x][y] += 2;
			}
		}
	}

	public int getTotalOn() {
		// get total number on
		int counter = 0;
		for (int y = 0; y < ChristmasLights.SIZE; y++) {
			for (int x = 0; x < ChristmasLights.SIZE; x++) {
				if (brightness[x][y] > 0) {
					counter++;
				}
			}
		}
		return counter;
	}
	
	public int getTotalBrightness() {
		// sum all brightness values
		int sum = 0;
		for (int y = 0; y < ChristmasLights.SIZE; y++) {
			for (int x = 0; x < ChristmasLights.SIZE; x++) {
				sum += brightness[x][y];
			}
		}
		return sum;
	}
}
