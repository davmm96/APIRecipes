package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.User;
import models.UserAddress;
import models.UserBio;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.*;
import play.twirl.api.Content;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Optional;

public class UserController extends Controller
{
    private static ArrayList<User> users = new ArrayList<>();

    @Inject
    FormFactory formFactory;

    public Result getAllUsers()
    {
        ArrayNode array_users;

        if(!users.isEmpty())
        {
            array_users = getAll();
            return ok(array_users)
                    .withHeader("X-User-Count", String.valueOf(users.size()));
        }
        else
        {
            return Results.notFound()
                            .withHeader("X-User-Count", String.valueOf(users.size()));
        }
    }

    public Result getUser(Http.Request request, String userid)
    {
        User userFound = User.findUserById(Long.valueOf(userid));

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

        UserBio bio = new UserBio();
        bio.setTexto("19 años, Alicante");

        user.setBio(bio);

        UserAddress address1 = new UserAddress();
        address1.setStreet("Montepinar");
        user.addAddress(address1);

        UserAddress address2 = new UserAddress();
        address2.setStreet("Desengaño 21");
        user.addAddress(address2);


        if(users.contains(user))
        {
            return Results.status(409);
        }

        user.save();

        return ok(Json.toJson(user))
                        .withHeader("X-User-Count", String.valueOf(users.size()));
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

        Optional<String> opEdad = request.queryString("edad");
        String nueva_edad = opEdad.orElse(String.valueOf(userFound.getEdad()));

        userFound.setNick(nuevo_nick);
        userFound.setEdad(Integer.valueOf(nueva_edad));

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

    public ArrayNode getAll()
    {
        ArrayNode array_users = Json.newArray();

        for (int i = 0; i < users.size(); i++)
        {
            JsonNode node = Json.toJson(users.get(i));
            array_users.add(node);
        }

        return array_users;
    }
}