package net.talaatharb.ohce;

import java.io.PrintStream;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OutputSystemImpl implements OutputSystem {
	
	private final PrintStream outputStream;

	@Override
	public void output(String text) {
		if (text != null) {
			if (text.startsWith("$ ")) {
				outputStream.print(text);
			} else {
				outputStream.println("> " + text);
			}
		}
	}

}
