package models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.Min;
import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import play.data.validation.Constraints;

import javax.persistence.*;
import javax.validation.Constraint;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends Model
{

    private static final Finder<Long,User> finder = new Finder<>(User.class);

    @Id
    private Long id;

    @Version
    private Long version;

    @WhenCreated
    private Timestamp whenCreated;

    @WhenModified
    private Timestamp whenModified;

    @Constraints.Required
    private String nick;

    @Constraints.Min(value = 18, message = "error-menor-de-edad")
    private Integer edad;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private UserBio bio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentUser")
    @JsonManagedReference
    private List<UserAddress> address = new ArrayList<>();

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

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


    public static User findUserById(Long id)
    {
        return finder.byId(id);
    }

    public static List<User> findByName(String name)
    {
        return finder.query().where().eq("name", name).findList();
    }


    public UserBio getBio() {
        return bio;
    }

    public void setBio(UserBio bio) {
        bio.setParentUser(this);
        this.bio = bio;
    }

    public List<UserAddress> getAddress() {
        return address;
    }

    public void setAddress(List<UserAddress> address) {
        this.address = address;
    }

    public void addAddress(UserAddress address)
    {
        this.address.add(address);
        address.setParentUser(this);
    }
}
