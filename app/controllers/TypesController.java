package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
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

public class TypesController extends Controller
{
    @Inject
    FormFactory formFactory;

    @Inject
    MessagesApi messagesApi;

    public Result getAllTypes(Http.Request request)
    {
        List<RecipeType> array_types = RecipeType.findAllTypes();

        if(!array_types.isEmpty())
        {
            if (request.accepts("application/xml"))
            {
                Content content = views.xml.types.render(array_types);
                return Results.ok(content);
            }
            else if (request.accepts("application/json"))
            {
                return ok(Json.toJson(array_types));
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

    public Result getType(Http.Request request, String typeId)
    {
        RecipeType typeFound = RecipeType.findTypeById(Long.valueOf(typeId));

        if(typeFound == null)
        {
            return Results.notFound();
        }

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.typeElement.render(typeFound);
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            return ok(Json.toJson(typeFound));
        }
        else
        {
            Messages messages = messagesApi.preferred(request);

            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
    }

    public Result createType(Http.Request request)
    {
        Form<RecipeType> typeForm = formFactory.form(RecipeType.class).bindFromRequest(request);

        if(typeForm.hasErrors())
        {
            return Results.notAcceptable(typeForm.errorsAsJson());
        }

        RecipeType type = typeForm.get();
        RecipeType typeFound = RecipeType.findTypeByName(type.getTypeName());

        Messages messages = messagesApi.preferred(request);

        if(typeFound != null)
        {
            ObjectNode result = Json.newObject();
            result.put("conflict",messages.at("conflict_type_exists"));
            return Results.status(409, result);
        }

        type.save();

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.typeElement.render(type);
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            return ok(Json.toJson(type));
        }
        else {
            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
    }

    public Result updateType(Http.Request request, String typeId)
    {
        Form<RecipeType> typeForm = formFactory.form(RecipeType.class).bindFromRequest(request);
        Messages messages = messagesApi.preferred(request);

        if(typeForm.hasErrors())
        {
            return Results.notAcceptable(typeForm.errorsAsJson());
        }

        RecipeType type = typeForm.get();
        RecipeType typeFound = RecipeType.findTypeById(Long.valueOf(typeId));

        if(typeFound == null)
        {
            return Results.notFound();
        }

        if(RecipeType.typeExists(type.getTypeName()))
        {
            ObjectNode result = Json.newObject();
            result.put("conflict",messages.at("conflict_type_exists"));
            return Results.status(409, result);
        }

        typeFound.setTypeName(type.getTypeName());
        typeFound.update();

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.typeElement.render(typeFound);
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            return ok(Json.toJson(typeFound));
        }
        else {
            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
    }

    public Result deleteType(Http.Request request, String typeId)
    {
        RecipeType typeFound = RecipeType.findTypeById(Long.valueOf(typeId));

        if(typeFound == null)
        {
            return Results.notFound();
        }

        typeFound.delete();

        Messages messages = messagesApi.preferred(request);

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.message.render(messages.at("message_type_deleted"));
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            ObjectNode result = Json.newObject();
            result.put("message",messages.at("message_type_deleted"));
            return ok(result);
        }
        else {
            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
    }

}