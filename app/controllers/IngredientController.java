package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Ingredient;
import models.RecipeType;
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

public class IngredientController extends Controller
{
    @Inject
    FormFactory formFactory;

    @Inject
    MessagesApi messagesApi;

    public Result getAllIngredients(Http.Request request)
    {
        List<Ingredient> array_ingredients = Ingredient.findAllIngredients();

        if(!array_ingredients.isEmpty())
        {
            if (request.accepts("application/xml"))
            {
                Content content = views.xml.ingredients.render(array_ingredients);
                return Results.ok(content);
            }
            else if (request.accepts("application/json"))
            {
                return ok(Json.toJson(array_ingredients));
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

    public Result getIngredient(Http.Request request, String ingredientId)
    {
        Ingredient ingredientFound = Ingredient.findIngredientById(Long.valueOf(ingredientId));

        if(ingredientFound == null)
        {
            return Results.notFound();
        }

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.ingredient.render(ingredientFound);
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            return ok(Json.toJson(ingredientFound));
        }
        else
        {
            Messages messages = messagesApi.preferred(request);

            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
    }

    public Result updateIngredient(Http.Request request, String ingredientId)
    {
        Form<Ingredient> ingredientForm = formFactory.form(Ingredient.class).bindFromRequest(request);
        Messages messages = messagesApi.preferred(request);

        if(ingredientForm.hasErrors())
        {
            return Results.notAcceptable(ingredientForm.errorsAsJson());
        }

        Ingredient ingredient = ingredientForm.get();
        Ingredient ingredientFound = Ingredient.findIngredientById(Long.valueOf(ingredientId));

        if(ingredientFound == null)
        {
            return Results.notFound();
        }

        if(Ingredient.ingredientExists(ingredient.getName()))
        {
            ObjectNode result = Json.newObject();
            result.put("conflict",messages.at("conflict_ingredient_exists"));
            return Results.status(409, result);
        }

        ingredientFound.setName(ingredient.getName());
        ingredientFound.update();

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.ingredient.render(ingredientFound);
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            return ok(Json.toJson(ingredientFound));
        }
        else {
            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
    }

}