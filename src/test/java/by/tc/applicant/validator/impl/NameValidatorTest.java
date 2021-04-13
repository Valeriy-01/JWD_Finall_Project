package by.tc.applicant.validator.impl;

import org.junit.Assert;
import org.junit.Test;


public class NameValidatorTest {
	@Test
    public void testValidateX0() {
        String input = "Валерий";
        Assert.assertTrue(NameValidator.getInstance().validate(input));
    }
	
	@Test
    public void testValidateX1() {
        String input = "Alex";
        Assert.assertTrue(NameValidator.getInstance().validate(input));
    }
	
	@Test
    public void testValidateX2() {
        String input = "Алексей_01";
        Assert.assertFalse(NameValidator.getInstance().validate(input));
    }
	
	@Test
    public void testValidateX3() {
        String input = "";
        Assert.assertFalse(NameValidator.getInstance().validate(input));
    }
}
