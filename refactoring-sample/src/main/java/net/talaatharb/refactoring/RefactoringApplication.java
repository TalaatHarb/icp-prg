package net.talaatharb.refactoring;

import lombok.extern.slf4j.Slf4j;
import net.talaatharb.refactoring.utils.StatisticsUtils;

@Slf4j
public class RefactoringApplication {
	
	public static void main(String[] args) {
		log.trace("Application Started");

		final double[] x = { 10, 20, 30, 40, 50 };

		final double meanX = StatisticsUtils.calculateMean(x);
		double standardDeviationX = StatisticsUtils.calculateStandardDeviation(x, meanX);
		
		log.info("E(x) = {}, S(x) = {}", meanX, standardDeviationX);
		
		final double[] y = { 10, 20, 30, 40, 50, 60, 70 };

		final double meanY = StatisticsUtils.calculateMean(y);
		double standardDeviationY = StatisticsUtils.calculateStandardDeviation(y, meanY);
		
		log.info("E(y) = {}, S(y) = {}", meanY, standardDeviationY);
		
		log.trace("Application finished");
	}
}