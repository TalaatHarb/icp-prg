package net.talaatharb.refactoring;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RefactoringApplication {
	
	public static void main(String[] args) {
		log.trace("Application Started");

		final double[] x = { 10, 20, 30, 40, 50 };

		final double ex = Arrays.stream(x).average().orElse(0.0);
		double sx = Math.sqrt(Arrays.stream(x).map(xi -> Math.pow(xi - ex, 2)).average().orElse(0.0));
		
		log.info("E(x) = {}, S(x) = {}", ex, sx);
		
		final double[] y = { 10, 20, 30, 40, 50, 60, 70 };

		final double ey = Arrays.stream(y).average().orElse(0.0);
		double sy = Math.sqrt(Arrays.stream(y).map(yi -> Math.pow(yi - ey, 2)).average().orElse(0.0));
		
		log.info("E(y) = {}, S(y) = {}", ey, sy);
		
		log.trace("Application finished");
	}
}