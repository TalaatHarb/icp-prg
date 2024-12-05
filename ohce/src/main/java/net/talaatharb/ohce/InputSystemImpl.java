package net.talaatharb.ohce;

import java.util.Scanner;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InputSystemImpl implements InputSystem {

	private final OutputSystem outputSystem;

	private final Scanner scanner;

	@Override
	public String getInput() {
		outputSystem.output("$ ");
		return scanner.nextLine();
	}

}
