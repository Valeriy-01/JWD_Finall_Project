package by.tc.finalproject.validator.impl;

import org.junit.Assert;
import org.junit.Test;

public class ScoreValidatorTest {
	@Test
	public void testValidateX0() {
		int input = 45;
		Assert.assertTrue(ScoreValidator.getInstance().validate(input));
	}

	@Test
	public void testValidateX1() {
		int input = 100;
		Assert.assertTrue(ScoreValidator.getInstance().validate(input));
	}

	@Test
	public void testValidateX2() {
		int input = -89;
		Assert.assertFalse(ScoreValidator.getInstance().validate(input));
	}

	@Test
	public void testValidateX3() {
		int input = 999;
		Assert.assertFalse(ScoreValidator.getInstance().validate(input));
	}
}
