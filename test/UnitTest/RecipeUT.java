package UnitTest;

import models.Recipe;
import models.RecipeType;
import models.Steps;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecipeUT {

    @Test
    public void testData() {

        Recipe recipe = new Recipe();
        recipe.setName("Pollo");
        recipe.setMinutes(40);
        recipe.setServes(4);

        Steps steps = new Steps();
        steps.setSteps("Pasos de prueba");
        recipe.setSteps(steps);

        RecipeType type = new RecipeType();
        type.setTypeName("Primer plato");
        recipe.setType(type);

        assertEquals("Pollo", recipe.getName());
        assertEquals(Integer.valueOf(40), recipe.getMinutes());
        assertEquals(Integer.valueOf(4), recipe.getServes());
        assertEquals("Primer plato", recipe.getType().getTypeName());
        assertEquals("Pasos de prueba", recipe.getSteps().getSteps());
    }
}
