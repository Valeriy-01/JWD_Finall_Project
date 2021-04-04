package by.tc.finalproject.validator.impl;

import org.junit.Assert;
import org.junit.Test;

public class PassportValidatorTest {
	@Test
    public void testValidateX0() {
        String input = "ab315608";
        Assert.assertTrue(PassportValidator.getInstance().validate(input));
    }
	
	@Test
    public void testValidateX1() {
        String input = "mx008475";
        Assert.assertTrue(PassportValidator.getInstance().validate(input));
    }
	
	@Test
    public void testValidateX2() {
        String input = "аб_erh44";
        Assert.assertFalse(PassportValidator.getInstance().validate(input));
    }
	
	@Test
    public void testValidateX3() {
        String input = "";
        Assert.assertFalse(PassportValidator.getInstance().validate(input));
    }
}
