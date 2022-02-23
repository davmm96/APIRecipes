package models;

import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;
import validators.Password;

import javax.persistence.*;
import java.util.List;

@Entity
public class User extends Model
{
    private static final Finder<Long,User> finder = new Finder<>(User.class);

    //Attributes
    @Id
    private Long id;

    @Constraints.Required(message = "error_nick")
    @Constraints.MinLength(value=2,message = "error_nick_extension")
    private String nick;

    @Constraints.Required(message = "error_pass_required")
    @Password(message = "error_pass")
    private String pass;

    //Getters and setters
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Custom methods
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof User && obj != null)
        {
            User objUser = (User) obj;

            if(objUser.getNick() == null)
            {
                return false;
            }

            return objUser.getNick().equals(this.getNick());
        }
        else
        {
            return false;
        }
    }

    public static User findUserById(Long id)
    {
        return finder.byId(id);
    }

    public static List<User> findAllUsers(Integer offset)
    {
        return finder.query().where().setMaxRows(55).setFirstRow(offset).findList();
    }

    public static User findUserByNick(String nick)
    {
        return finder.query().where().eq("nick",nick).findOne();
    }

    public static boolean nickExists(String nick){return (findUserByNick(nick) != null); }

    public static boolean idExists(Long id){return (findUserById(id) != null); }
}
