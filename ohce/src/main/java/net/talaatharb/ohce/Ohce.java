package net.talaatharb.ohce;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Ohce implements Runnable {
	
	public static final String STOP_PHRASE = "Stop!";
	
	private final String userName;
	private final SystemTime systemTime;
	private final InputSystem inputSystem;
	private final OutputSystem outputSystem;

	@Override
	public void run() {
		welcomeMessage();
		
		String message;
		do {
			message = inputSystem.getInput();
			handle(message);
		} while (!STOP_PHRASE.equals(message));
		
		goodByeMessage();		
	}
	
	void welcomeMessage() {
		final int hour = systemTime.getHour();

		String message = "";
		if (hour >= 20 && hour <= 24 || hour >= 0 && hour <= 6) {
			message = "¡Buenas noches " + userName;
		} else if (hour > 6 && hour <= 12) {
			message = "¡Buenos días " + userName;
		} else {
			message = "¡Buenas tardes " + userName;
		}

		outputSystem.output(message);
	}
	
	void handle(String message) {
		if (!STOP_PHRASE.equals(message)) {
			final String reversedString = reverseMessage(message);
			outputSystem.output(reversedString);
			if (message != null && message.equals(reversedString)) {
				outputSystem.output("¡Bonita palabra!");
			}
		}
	}
	
	String reverseMessage(String message) {
		if (message == null) {
			return null;
		}

		final StringBuilder builder = new StringBuilder();
		for (int i = message.length() - 1; i >= 0; i--) {
			builder.append(message.charAt(i));
		}
		return builder.toString();
	}
	
	void goodByeMessage() {
		outputSystem.output("Adios " + userName);
	}

}
