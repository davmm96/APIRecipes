package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.*;
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
import java.util.List;
import java.util.Optional;

public class RecipeController extends Controller {

    @Inject
    FormFactory formFactory;

    @Inject
    MessagesApi messagesApi;

    public Result getAllRecipes(Http.Request request)
    {
        Optional<String> opOffset = request.queryString("offset");
        String offset = opOffset.orElse("0");

        List<Recipe> array_recipes = Recipe.findAllRecipes(Integer.valueOf(offset));

        if(!array_recipes.isEmpty())
        {
            if (request.accepts("application/xml"))
            {
                Content content = views.xml.recipes.render(array_recipes);
                return Results.ok(content);
            }
            else if (request.accepts("application/json"))
            {
                return ok(Json.toJson(array_recipes));
            }
            else
            {
                Messages messages = messagesApi.preferred(request);

                ObjectNode result = Json.newObject();
                result.put("error",messages.at("conflict_format"));
                return Results.status(406,result);
            }
        }
        else
        {
            return Results.notFound();
        }
    }

    public Result getOneRecipe(Http.Request request, String recipeId)
    {
        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));

        if(recipeFound == null)
        {
            return Results.notFound();
        }

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.recipe.render(recipeFound);
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            return ok(Json.toJson(recipeFound));
        }
        else
        {
            Messages messages = messagesApi.preferred(request);

            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
    }

    public Result getUserRecipes(Http.Request request, String userId)
    {
        User userFound = User.findUserById(Long.valueOf(userId));

        if(userFound == null)
        {
            return Results.notFound();
        }

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.recipes.render(userFound.getRecipes());
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            return ok(Json.toJson(userFound.getRecipes()));
        }
        else
        {
            Messages messages = messagesApi.preferred(request);

            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
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

        Recipe recipe_new = new Recipe();

        recipe_new.setName(recipe.getName());
        recipe_new.setMinutes(recipe.getMinutes());
        recipe_new.setServes(recipe.getServes());

        if(recipe.getSteps() != null) {
            Steps steps = new Steps();
            steps.setSteps(recipe.getSteps().getSteps());

            recipe_new.setSteps(steps);
        }

        userFound.addRecipe(recipe_new);
        recipe_new.save();

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.recipe.render(recipe_new);
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            return ok(Json.toJson(recipe_new));
        }
        else {
            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
    }

    public Result deleteRecipe(Http.Request request, String userId, String recipeId)
    {
        User userFound = User.findUserById(Long.valueOf(userId));

        if(userFound == null)
        {
            return Results.notFound();
        }

        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));

        if(recipeFound == null || !recipeFound.getParentUserId().equals(Long.valueOf(userId)))
        {
            return Results.notFound();
        }

        userFound.removeRecipe(recipeFound);
        recipeFound.delete();

        Messages messages = messagesApi.preferred(request);

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.message.render(messages.at("message_recipe_deleted"));
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            ObjectNode result = Json.newObject();
            result.put("message",messages.at("message_recipe_deleted"));
            return ok(result);
        }
        else {
            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
    }

    public Result updateRecipe(Http.Request request, String userId, String recipeId) {

        Form<Recipe> recipeForm = formFactory.form(Recipe.class).bindFromRequest(request);
        Messages messages = messagesApi.preferred(request);

        if (recipeForm.hasErrors()) {
            return Results.notAcceptable(recipeForm.errorsAsJson());
        }

        Recipe recipe = recipeForm.get();
        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));
        User userFound = User.findUserById(Long.valueOf(userId));

        if (userFound == null || recipeFound == null) {
            return Results.notFound();
        }

        Recipe recipeAux = recipeFound;
        recipeFound.setName(recipe.getName());
        recipeFound.setMinutes(recipe.getMinutes());
        recipeFound.setServes(recipe.getServes());

        userFound.updateRecipe(recipeFound,recipeAux);
        recipeFound.update();

        if (request.accepts("application/xml")) {
            Content content = views.xml.recipe.render(recipeFound);
            return Results.ok(content);
        } else if (request.accepts("application/json")) {
            return ok(Json.toJson(recipeFound));
        } else {
            ObjectNode result = Json.newObject();
            result.put("error", messages.at("conflict_format"));
            return Results.status(406, result);
        }
    }

    public Result patchRecipe(Http.Request request, String userId, String recipeId)
    {
        Form<Recipe_patch> recipeForm = formFactory.form(Recipe_patch.class).bindFromRequest(request);
        Messages messages = messagesApi.preferred(request);

        if(recipeForm.hasErrors())
        {
            return Results.notAcceptable(recipeForm.errorsAsJson());
        }

        Recipe_patch recipe = recipeForm.get();
        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));
        User userFound = User.findUserById(Long.valueOf(userId));

        if(userFound == null  || recipeFound == null)
        {
            return Results.notFound();
        }

        Recipe recipeAux = recipeFound;

        if(recipe.getName() != null)
        {
            recipeFound.setName(recipe.getName());
        }

        if(recipe.getServes() != null)
        {
            recipeFound.setServes(recipe.getServes());
        }

        if(recipe.getMinutes() != null)
        {
            recipeFound.setMinutes(recipe.getMinutes());
        }

        userFound.updateRecipe(recipeFound,recipeAux);
        recipeFound.update();

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.recipe.render(recipeFound);
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            return ok(Json.toJson(recipeFound));
        }
        else {
            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
    }


    //Steps

    public Result getSteps(Http.Request request, String recipeId)
    {
        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));

        if(recipeFound == null || recipeFound.getSteps() == null)
        {
            return Results.notFound();
        }

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.steps.render(recipeFound.getSteps());
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            return ok(Json.toJson(recipeFound.getSteps()));
        }
        else
        {
            Messages messages = messagesApi.preferred(request);

            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
    }

    public Result createSteps(Http.Request request, String recipeId)
    {
        Form<Steps> stepsForm = formFactory.form(Steps.class).bindFromRequest(request);

        if(stepsForm.hasErrors())
        {
            return Results.notAcceptable(stepsForm.errorsAsJson());
        }

        Steps steps = stepsForm.get();
        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));

        Messages messages = messagesApi.preferred(request);

        if(recipeFound == null)
        {
            return Results.notFound();
        }

        if(recipeFound.getSteps() != null)
        {
            ObjectNode result = Json.newObject();
            result.put("conflict",messages.at("conflict_has_steps"));
            return Results.status(409, result);
        }

        Steps steps_new = new Steps();
        steps_new.setSteps(steps.getSteps());

        steps_new.setParentRecipe(recipeFound);

        steps_new.save();
        recipeFound.update();

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.recipe.render(recipeFound);
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            return ok(Json.toJson(recipeFound));
        }
        else {
            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
    }

    public Result updateSteps(Http.Request request, String recipeId, String stepsId)
    {
        Form<Steps> stepsForm = formFactory.form(Steps.class).bindFromRequest(request);
        Messages messages = messagesApi.preferred(request);

        if (stepsForm.hasErrors()) {
            return Results.notAcceptable(stepsForm.errorsAsJson());
        }

        Steps steps = stepsForm.get();

        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));
        Steps stepsFound = Steps.findStepsById(Long.valueOf(stepsId));

        if (recipeFound == null || stepsFound == null) {
            return Results.notFound();
        }

        stepsFound.setSteps(steps.getSteps());

        recipeFound.setSteps(stepsFound);
        stepsFound.update();

        if (request.accepts("application/xml")) {
            Content content = views.xml.steps.render(stepsFound);
            return Results.ok(content);
        } else if (request.accepts("application/json")) {
            return ok(Json.toJson(stepsFound));
        } else {
            ObjectNode result = Json.newObject();
            result.put("error", messages.at("conflict_format"));
            return Results.status(406, result);
        }
    }

    public Result deleteSteps(Http.Request request, String recipeId, String stepsId)
    {
        Recipe recipeFound = Recipe.findRecipeById(Long.valueOf(recipeId));

        if(recipeFound == null)
        {
            return Results.notFound();
        }

        Steps stepsFound = Steps.findStepsById(Long.valueOf(stepsId));

        if(stepsFound == null || !stepsFound.getParentRecipeId().equals(Long.valueOf(recipeId)))
        {
            return Results.notFound();
        }

        recipeFound.removeSteps();
        recipeFound.update();
        stepsFound.delete();

        Messages messages = messagesApi.preferred(request);

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.message.render(messages.at("message_steps_deleted"));
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            ObjectNode result = Json.newObject();
            result.put("message",messages.at("message_steps_deleted"));
            return ok(result);
        }
        else {
            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
    }
}
