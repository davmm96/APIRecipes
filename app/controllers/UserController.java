package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.*;
import play.twirl.api.Content;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserController extends Controller
{
    private static ArrayList<User> users = new ArrayList<>();

    @Inject
    FormFactory formFactory;

    public Result getAllUsers(Http.Request request)
    {
        Optional<String> opOffset = request.queryString("offset");
        String offset = opOffset.orElse("0");

        List<User> array_users = User.findAllUsers(Integer.valueOf(offset));;

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
            else {
                ObjectNode result = Json.newObject();
                result.put("error","Unsupported format");
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
        else {
            ObjectNode result = Json.newObject();
            result.put("error","Unsupported format");
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


        if(users.contains(user))
        {
            return Results.status(409);
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
            result.put("error","Unsupported format");
            return Results.status(406,result);
        }
    }

    public Result updateUser(Http.Request request, String userNick)
    {
        User user = new User();
        user.setNick(userNick);

        int indexFound = users.indexOf(user);

        if(indexFound == -1)
        {
            return Results.notFound("Usuario no encontrado");
        }

        User userFound = users.get(indexFound);

        Optional<String> opNick = request.queryString("nick");
        String nuevo_nick = opNick.orElse(userFound.getNick());

        userFound.setNick(nuevo_nick);

         return ok(Json.toJson(user))
                        .withHeader("X-User-Count", String.valueOf(users.size()));
    }

    public Result deleteUser(String nick)
    {
        User user = new User();
        user.setNick(nick);

        int indexFound = users.indexOf(user);

        if(indexFound == -1)
        {
            return Results.notFound();
        }

        User userFound = users.get(indexFound);
        users.remove(userFound);

        return ok("Usuario borrado correctamente")
                    .withHeader("X-User-Count", String.valueOf(users.size()));
    }
}