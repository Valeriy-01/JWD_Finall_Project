package by.tc.applicant.validator.impl;

import org.junit.Assert;
import org.junit.Test;

public class PasswordValidatorTest {
	@Test
    public void testValidateX0() {
        String input = "ght09nfoeghg";
        Assert.assertTrue(PasswordValidator.getInstance().validate(input));
    }
	
	@Test
    public void testValidateX1() {
        String input = "12_igj5Mei";
        Assert.assertTrue(PasswordValidator.getInstance().validate(input));
    }
	
	@Test
    public void testValidateX2() {
        String input = null;
        Assert.assertFalse(PasswordValidator.getInstance().validate(input));
    }
	
	@Test
    public void testValidateX3() {
        String input = "";
        Assert.assertFalse(PasswordValidator.getInstance().validate(input));
    }
}
