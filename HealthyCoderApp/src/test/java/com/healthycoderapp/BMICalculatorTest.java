package com.healthycoderapp;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BMICalculatorTest {

	@ParameterizedTest
	@ValueSource(doubles = { 73.3, 75.3, 1.75 })
	void isDietRecommendedTest(double weight) {
		double height = 1.75;
		boolean result = BMICalculator.isDietRecommended(weight, height);
		Assert.assertFalse(result);

	}

	@ParameterizedTest
	@CsvSource(value = { "78.6,1.75", "76.8,1.75" })
	void isDietRecommendedTests(double weight, double height) {
		boolean result = BMICalculator.isDietRecommended(weight, height);
		assertTrue(result);
	}

	@Test
	void findCoderWithWorstBMITest() {
		List<Coder> coders = List.of(new Coder(73.3, 1.75));
		BMICalculator.findCoderWithWorstBMI(coders);
	}

	@Test
	void getBMIScoresTest() {
		
		List<Coder> coders = List.of(new Coder(73.3, 1.75));
		BMICalculator.getBMIScores(coders);
		
	}

	@Test
	void getBMIScoresThrowTest() {
		List<Coder> coder = List.of(new Coder(0.0,0.0));
		Executable exe = () -> BMICalculator.getBMIScores(coder);
		assertThrows(ArithmeticException.class, exe);
		Executable executable = () -> BMICalculator.isDietRecommended(73.3, 0);
		assertThrows(ArithmeticException.class, executable);
	}
}
