package UnitTest;

import models.User;
import org.junit.Test;
import validators.PassValidator;

import static org.junit.Assert.*;

public class UserUT {

    @Test
    public void testData() {

        User user = new User();
        user.setNick("david");
        user.setPass("123456aA");

        assertEquals("david", user.getNick());
        assertEquals("123456aA", user.getPass());

    }

    @Test
    public void testPassValidator() {

        PassValidator validator = new PassValidator();

        String pass1 = "1234";
        String pass2 = "12345678";
        String pass3 = "123456aa";
        String pass4 = "123456AA";
        String pass5 = "123456Aa";

        assertFalse(validator.isValid(pass1));
        assertFalse(validator.isValid(pass2));
        assertFalse(validator.isValid(pass3));
        assertFalse(validator.isValid(pass4));
        assertTrue(validator.isValid(pass5));

    }
}
