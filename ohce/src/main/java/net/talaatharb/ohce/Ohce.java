package net.talaatharb.ohce;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Ohce implements Runnable {
	
	public static final String STOP_PHRASE = "Stop!";
	
	private final String userName;

	@Override
	public void run() {
		welcomeMessage();
		
		// TODO implement the logic for the application loop
		
		goodByeMessage();		
	}
	
	void welcomeMessage() {
		// TODO implement welcome message logic
	}
	
	String reverseMessage(String message) {
		// TODO implement proper reversing of string
		return message;
	}
	
	void goodByeMessage() {
		// TODO implement goodbye message
	}

}
