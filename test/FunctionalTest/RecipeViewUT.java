package FunctionalTest;

import models.Recipe;
import models.RecipeType;
import org.junit.Test;
import play.test.WithApplication;
import play.twirl.api.Content;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecipeViewUT extends WithApplication {

    @Test
    public void test() {

        Recipe recipe = new Recipe();
        recipe.setName("Pollo");

        assertEquals("Pollo", recipe.getName());
    }
}
