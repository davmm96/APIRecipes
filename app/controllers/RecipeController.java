package controllers;

import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

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
        return ok();
    }

    public Result deleteRecipe(Http.Request request, String recipeId)
    {
        return ok();
    }
}
