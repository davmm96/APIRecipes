package FunctionalTest;

import models.Recipe;
import models.RecipeType;
import org.junit.Test;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;
import play.twirl.api.Content;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RoutesFT extends WithApplication {

    @Test
    public void testUserPath() {
        Http.RequestBuilder request = Helpers.fakeRequest()
                .method("GET")
                .uri("/users");

        Result result = Helpers.route(app, request);
        assertEquals(200, result.status());
    }

    @Test
    public void testRecipePath() {
        Http.RequestBuilder request = Helpers.fakeRequest()
                .method("GET")
                .uri("/recipes");

        Result result = Helpers.route(app, request);
        assertEquals(200, result.status());
    }

    @Test
    public void testIncorrectRecipeTypePath() {
        Http.RequestBuilder request = Helpers.fakeRequest()
                .method("GET")
                .uri("/RecipeTypes");

        Result result = Helpers.route(app, request);
        assertEquals(404, result.status());
    }
}
