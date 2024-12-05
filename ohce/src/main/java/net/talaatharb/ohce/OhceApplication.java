package net.talaatharb.ohce;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OhceApplication {
	
	public static void main(String[] args) {
		log.trace("Application Started");

		final String userName = args != null && args.length > 0 ? args[0] : "User";
		
		// constructor can change
		final var ohce = new Ohce(userName);

		ohce.run();
		
		log.trace("Application finished");
	}
}