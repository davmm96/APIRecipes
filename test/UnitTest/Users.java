package UnitTest;

import models.User;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Users{

    @Test
    public void checkNick() {

        User user = new User();
        user.setNick("david");

        assertEquals("david", user.getNick());
    }

    @Test
    public void checkPass() {

        User user = new User();
        user.setPass("123456aA");

        assertEquals("123456aA", user.getPass());
    }
}
