package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Recipe;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.Messages;
import play.i18n.MessagesApi;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import play.twirl.api.Content;

import javax.inject.Inject;

public class RecipeController extends Controller {

    @Inject
    FormFactory formFactory;

    @Inject
    MessagesApi messagesApi;

    public Result getAllRecipes(Http.Request request)
    {
        return ok();
    }

    public Result getOneRecipe(Http.Request request, String recipeId)
    {
        return ok();
    }

    public Result getUserRecipes(Http.Request request, String recipeId)
    {
        return ok();
    }

    public Result createRecipe(Http.Request request, String userId)
    {
        Form<Recipe> recipeForm = formFactory.form(Recipe.class).bindFromRequest(request);

        if(recipeForm.hasErrors())
        {
            return Results.notAcceptable(recipeForm.errorsAsJson());
        }

        Recipe recipe = recipeForm.get();
        User userFound = User.findUserById(Long.valueOf(userId));

        Messages messages = messagesApi.preferred(request);

        if(userFound == null)
        {
            return Results.notFound();
        }

        userFound.addRecipe(recipe);
        recipe.save();

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.recipe.render(recipe);
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            return ok(Json.toJson(recipe));
        }
        else {
            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
    }

    public Result deleteRecipe(Http.Request request, String recipeId)
    {
        return ok();
    }
}
