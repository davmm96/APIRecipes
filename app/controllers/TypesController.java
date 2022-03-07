package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Types;
import models.User;
import models.User_patch;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TypesController extends Controller
{
    @Inject
    FormFactory formFactory;

    @Inject
    MessagesApi messagesApi;

    public Result getAllTypes(Http.Request request)
    {
        List<Types> array_types = Types.findAllTypes();

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
        Types typeFound = Types.findTypeById(Long.valueOf(typeId));

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
        Form<Types> typeForm = formFactory.form(Types.class).bindFromRequest(request);

        if(typeForm.hasErrors())
        {
            return Results.notAcceptable(typeForm.errorsAsJson());
        }

        Types type = typeForm.get();
        Types typeFound = Types.findTypeByName(type.getName());

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
        Form<Types> typeForm = formFactory.form(Types.class).bindFromRequest(request);
        Messages messages = messagesApi.preferred(request);

        if(typeForm.hasErrors())
        {
            return Results.notAcceptable(typeForm.errorsAsJson());
        }

        Types type = typeForm.get();
        Types typeFound = Types.findTypeById(Long.valueOf(typeId));

        if(typeFound == null)
        {
            return Results.notFound();
        }

        if(Types.typeExists(type.getName()))
        {
            ObjectNode result = Json.newObject();
            result.put("conflict",messages.at("conflict_type_exists"));
            return Results.status(409, result);
        }

        typeFound.setName(type.getName());
        typeFound.update();

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.typeElement.render(type);
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
        Types typeFound = Types.findTypeById(Long.valueOf(typeId));

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