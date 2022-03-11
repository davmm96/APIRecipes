package FunctionalTest;

import models.Ingredient;
import models.Recipe;
import models.User;
import org.junit.Test;
import play.test.WithApplication;
import play.twirl.api.Content;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ModelsFT extends WithApplication {

    @Test
    public void tetsUserModel() {
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
    public void testRecipeIngredientModel() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient = new Ingredient();
        ingredient.setName("Arroz");

        ingredient.addRecipe(recipe);

        assertEquals(1, ingredient.getRecipes().size());
        assertEquals("Arroz", recipe.getIngredients().get(0).getName());
    }
}
