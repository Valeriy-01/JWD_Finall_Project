package by.tc.finalproject.validator.impl;

import org.junit.Assert;
import org.junit.Test;

public class EmailValidatorTest {
	@Test
    public void testValidateX0() {
        String input = "goreglyad_01@mail.ru";
        Assert.assertTrue(EmailValidator.getInstance().validate(input));
    }
	
	@Test
    public void testValidateX1() {
        String input = "goreglyad_mail.ru";
        Assert.assertFalse(EmailValidator.getInstance().validate(input));
    }
}
