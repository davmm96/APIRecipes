package FunctionalTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import controllers.UserController;
import models.Ingredient;
import models.Recipe;
import models.User;
import org.junit.Test;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import play.test.Helpers;
import play.test.WithApplication;
import play.twirl.api.Content;

import static org.junit.Assert.*;

public class ControllersFT extends WithApplication {

    @Test
    public void testUserController() {

        Http.Request request = Helpers.fakeRequest()
                .method("GET")
                .uri("/user/6")
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .build();

        UserController controller = new UserController();
        Result result = controller.getUser(request,"6");

        JsonNode node = Json.parse(Helpers.contentAsString(result));
        assertNotNull(node);
        assertEquals("Dani",node.get("nick").asText());
    }
}
