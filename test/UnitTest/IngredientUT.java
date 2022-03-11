package UnitTest;

import models.Ingredient;
import models.Steps;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientUT {

    @Test
    public void testData() {

        Ingredient ingredient = new Ingredient();
        ingredient.setName("Arroz");

        assertEquals("Arroz", ingredient.getName());
    }
}
