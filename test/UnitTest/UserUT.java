package UnitTest;

import models.User;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserUT {

    @Test
    public void testData() {

        User user = new User();
        user.setNick("david");
        user.setPass("123456aA");

        assertEquals("david", user.getNick());
        assertEquals("123456aA", user.getPass());

    }
}
