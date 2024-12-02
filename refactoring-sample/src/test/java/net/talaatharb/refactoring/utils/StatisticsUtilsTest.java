package net.talaatharb.refactoring.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsUtilsTest {

    @Test
    void calculateMean_withValidArray_shouldReturnCorrectMean() {
        double[] values = {1.0, 2.0, 3.0, 4.0, 5.0};
        double expectedMean = 3.0;

        double result = StatisticsUtils.calculateMean(values);

        assertEquals(expectedMean, result, 1e-9, "Mean should be correctly calculated.");
    }

    @Test
    void calculateMean_withEmptyArray_shouldReturnZero() {
        double[] values = {};
        double expectedMean = 0.0;

        double result = StatisticsUtils.calculateMean(values);

        assertEquals(expectedMean, result, "Mean of an empty array should be 0.");
    }

    @Test
    void calculateMean_withSingleElementArray_shouldReturnElementValue() {
        double[] values = {42.0};
        double expectedMean = 42.0;

        double result = StatisticsUtils.calculateMean(values);

        assertEquals(expectedMean, result, "Mean of a single-element array should equal the element value.");
    }

    @Test
    void calculateStandardDeviation_withValidArray_shouldReturnCorrectValue() {
        double[] values = {1.0, 2.0, 3.0, 4.0, 5.0};
        double mean = StatisticsUtils.calculateMean(values);
        double expectedStdDev = Math.sqrt(2.0); // Pre-computed for this input

        double result = StatisticsUtils.calculateStandardDeviation(values, mean);

        assertEquals(expectedStdDev, result, 1e-9, "Standard deviation should be correctly calculated.");
    }

    @Test
    void calculateStandardDeviation_withEmptyArray_shouldReturnZero() {
        double[] values = {};
        double mean = 0.0;

        double result = StatisticsUtils.calculateStandardDeviation(values, mean);

        assertEquals(0.0, result, "Standard deviation of an empty array should be 0.");
    }

    @Test
    void calculateStandardDeviation_withSingleElementArray_shouldReturnZero() {
        double[] values = {42.0};
        double mean = 42.0;

        double result = StatisticsUtils.calculateStandardDeviation(values, mean);

        assertEquals(0.0, result, "Standard deviation of a single-element array should be 0.");
    }

    @Test
    void calculateStandardDeviation_withIdenticalValues_shouldReturnZero() {
        double[] values = {5.0, 5.0, 5.0};
        double mean = 5.0;

        double result = StatisticsUtils.calculateStandardDeviation(values, mean);

        assertEquals(0.0, result, "Standard deviation of identical values should be 0.");
    }

    @Test
    void calculateStandardDeviation_withNegativeValues_shouldHandleCorrectly() {
        double[] values = {-3.0, -2.0, -1.0};
        double mean = StatisticsUtils.calculateMean(values);
        double expectedStdDev = Math.sqrt(2.0 / 3.0); // Pre-computed for this input

        double result = StatisticsUtils.calculateStandardDeviation(values, mean);

        assertEquals(expectedStdDev, result, 1e-9, "Standard deviation should be calculated correctly for negative values.");
    }

    @Test
    void calculateMean_withNegativeValues_shouldReturnCorrectMean() {
        double[] values = {-3.0, -2.0, -1.0};
        double expectedMean = -2.0;

        double result = StatisticsUtils.calculateMean(values);

        assertEquals(expectedMean, result, 1e-9, "Mean should be correctly calculated for negative values.");
    }
}

