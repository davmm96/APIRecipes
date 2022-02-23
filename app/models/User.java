package models;

import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import play.data.validation.Constraints;
import validators.Password;

import javax.persistence.*;
import javax.validation.Constraint;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class User extends Model
{
    private static final Finder<Long,User> finder = new Finder<>(User.class);

    //Attributes
    @Id
    private Long id;

    @Version
    private Long version;

    @WhenCreated
    private Timestamp whenCreated;

    @WhenModified
    private Timestamp whenModified;

    @Constraints.Required(message = "error-nick")
    @Constraints.MinLength(value=4,message = "error-nick_extension")
    private String nick;

    @Password(message = "error-pass")
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Timestamp getWhenCreated() {
        return whenCreated;
    }

    public void setWhenCreated(Timestamp whenCreated) {
        this.whenCreated = whenCreated;
    }

    public Timestamp getWhenModified() {
        return whenModified;
    }

    public void setWhenModified(Timestamp whenModified) {
        this.whenModified = whenModified;
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
}
