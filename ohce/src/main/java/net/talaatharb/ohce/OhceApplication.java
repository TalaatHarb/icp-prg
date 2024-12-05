package net.talaatharb.ohce;

import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OhceApplication {
	
	public static void main(String[] args) {
		log.trace("Application Started");

		final String userName = args != null && args.length > 0 ? args[0] : "User";
		final SystemTime systemTime = new SystemTimeImpl();
		final OutputSystem outputSystem = new OutputSystemImpl(System.out);
		final InputSystem inputSystem = new InputSystemImpl(outputSystem, new Scanner(System.in));
		
		final var ohce = new Ohce(userName, systemTime, inputSystem, outputSystem);

		ohce.run();
		
		log.trace("Application finished");
	}
}