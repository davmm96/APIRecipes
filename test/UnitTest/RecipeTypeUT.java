package UnitTest;

import models.RecipeType;
import models.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecipeTypeUT {

    @Test
    public void testData() {

        RecipeType recipeType = new RecipeType();
        recipeType.setTypeName("Entrante");

        assertEquals("Entrante", recipeType.getTypeName());
    }
}
