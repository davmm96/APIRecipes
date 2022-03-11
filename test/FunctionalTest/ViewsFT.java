package FunctionalTest;

import models.Ingredient;
import models.User;
import org.junit.Test;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;
import play.twirl.api.Content;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ViewsFT extends WithApplication {

    @Test
    public void testUserView() {
        User user = new User();
        user.setNick("David");
        user.setPass("123456Aa");

        Content result = views.xml.user.render(user);
        assertEquals("application/xml", result.contentType());
        assertTrue(result.body().contains("<user>"));
        assertTrue(result.body().contains("<nick>"));
        assertTrue(result.body().contains("<pass>"));
    }

    @Test
    public void testIngredientView() {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Arroz");

        Content result = views.xml.ingredient.render(ingredient);
        assertEquals("application/xml", result.contentType());
        assertTrue(result.body().contains("<ingredient>"));
        assertTrue(result.body().contains("<name>"));
    }
}
