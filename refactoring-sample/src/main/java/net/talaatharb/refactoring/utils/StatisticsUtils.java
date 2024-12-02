package net.talaatharb.refactoring.utils;

import java.util.Arrays;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StatisticsUtils {
	/**
	 * Calculate the mean of a random variable
	 * @param x Random variable value as array
	 * @return The mean
	 */
	public static double calculateMean(final double[] x) {
		return Arrays.stream(x).average().orElse(0.0);
	}

	/**
	 * Calculate the standard variation of a random variable
	 * @param x Random variable value as array
	 * @param mean The mean of the random variable
	 * @return The standard variation
	 */
	public static double calculateStandardDeviation(final double[] x, final double mean) {
		return Math.sqrt(Arrays.stream(x).map(xi -> Math.pow(xi - mean, 2)).average().orElse(0.0));
	}

}
