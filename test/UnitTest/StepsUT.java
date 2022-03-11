package UnitTest;

import models.Steps;
import models.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StepsUT {

    @Test
    public void testData() {

        Steps steps = new Steps();
        steps.setSteps("Pasos de prueba");

        assertEquals("Pasos de prueba", steps.getSteps());
    }
}
