package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.User;
import models.User_patch;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.Messages;
import play.i18n.MessagesApi;
import play.libs.Json;
import play.mvc.*;
import play.twirl.api.Content;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class UserController extends Controller
{
    @Inject
    FormFactory formFactory;

    @Inject
    MessagesApi messagesApi;

    public Result getAllUsers(Http.Request request)
    {
        Optional<String> opOffset = request.queryString("offset");
        String offset = opOffset.orElse("0");

        List<User> array_users = User.findAllUsers(Integer.valueOf(offset));

        if(!array_users.isEmpty())
        {
            if (request.accepts("application/xml"))
            {
                Content content = views.xml.users.render(array_users);
                return Results.ok(content);
            }
            else if (request.accepts("application/json"))
            {
                return ok(Json.toJson(array_users));
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

    public Result getUser(Http.Request request, String userId)
    {
        User userFound = User.findUserById(Long.valueOf(userId));

        if(userFound == null)
        {
            return Results.notFound();
        }

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.user.render(userFound);
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            return ok(Json.toJson(userFound));
        }
        else
        {
            Messages messages = messagesApi.preferred(request);

            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
    }

    public Result createUser(Http.Request request)
    {
        Form<User> userForm = formFactory.form(User.class).bindFromRequest(request);

        if(userForm.hasErrors())
        {
            return Results.notAcceptable(userForm.errorsAsJson());
        }

        User user = userForm.get();
        User userFound = User.findUserByNick(user.getNick());

        Messages messages = messagesApi.preferred(request);

        if(userFound != null)
        {
            ObjectNode result = Json.newObject();
            result.put("conflict",messages.at("conflict_user_exists"));
            return Results.status(409, result);
        }

        user.save();

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.user.render(user);
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            return ok(Json.toJson(user));
        }
        else {
            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
    }

    public Result updateUserNick(Http.Request request, String userId)
    {
        Form<User_patch> userForm = formFactory.form(User_patch.class).bindFromRequest(request);
        Messages messages = messagesApi.preferred(request);

        if(userForm.hasErrors())
        {
            return Results.notAcceptable(userForm.errorsAsJson());
        }

        User_patch user = userForm.get();
        User userFound = User.findUserById(Long.valueOf(userId));

        if(userFound == null)
        {
            return Results.notFound();
        }

        if(User.nickExists(user.getNick()) && !userFound.getNick().equals(user.getNick()))
        {
            ObjectNode result = Json.newObject();
            result.put("conflict",messages.at("conflict_user_exists"));
            return Results.status(409, result);
        }

        if(user.getNick() != null) {
            userFound.setNick(user.getNick());
        }

        userFound.update();

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.user.render(userFound);
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            return ok(Json.toJson(userFound));
        }
        else {
            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
    }

    public Result updateUser(Http.Request request, String userId)
    {
        Form<User> userForm = formFactory.form(User.class).bindFromRequest(request);
        Messages messages = messagesApi.preferred(request);

        if(userForm.hasErrors())
        {
            return Results.notAcceptable(userForm.errorsAsJson());
        }

        User user = userForm.get();
        User userFound = User.findUserById(Long.valueOf(userId));

        if(userFound == null)
        {
            return Results.notFound();
        }

        if(!user.getId().equals(Long.valueOf(userId)))
        {
            ObjectNode result = Json.newObject();
            result.put("conflict",messages.at("conflict_userid"));
            return Results.status(409, result);
        }

        if(User.nickExists(user.getNick()) && !userFound.getNick().equals(user.getNick()))
        {
            ObjectNode result = Json.newObject();
            result.put("conflict",messages.at("conflict_user_exists"));
            return Results.status(409, result);
        }

        userFound.setNick(user.getNick());
        userFound.setPass(user.getPass());

        userFound.update();

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.user.render(userFound);
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            return ok(Json.toJson(userFound));
        }
        else {
            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
    }

    public Result deleteUser(Http.Request request, String userId)
    {
        User userFound = User.findUserById(Long.valueOf(userId));

        if(userFound == null)
        {
            return Results.notFound();
        }

        userFound.delete();

        Messages messages = messagesApi.preferred(request);

        if (request.accepts("application/xml"))
        {
            Content content = views.xml.message.render(messages.at("message_user_deleted"));
            return Results.ok(content);
        }
        else if (request.accepts("application/json"))
        {
            ObjectNode result = Json.newObject();
            result.put("message",messages.at("message_user_deleted"));
            return ok(result);
        }
        else {
            ObjectNode result = Json.newObject();
            result.put("error",messages.at("conflict_format"));
            return Results.status(406,result);
        }
    }
}