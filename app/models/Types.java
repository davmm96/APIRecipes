package models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;
import validators.Password;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Types extends Model
{
    private static final Finder<Long, Types> finder = new Finder<>(Types.class);

    //Attributes
    @Id
    private Long id;

    @Constraints.Required(message = "error_required")
    @Constraints.MinLength(value=2,message = "error_extension")
    private String name;

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String nick) {
        this.name = name;
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
        if(obj instanceof Types && obj != null)
        {
            Types objUser = (Types) obj;

            if(objUser.getName() == null)
            {
                return false;
            }

            return objUser.getName().equals(this.getName());
        }
        else
        {
            return false;
        }
    }

    public static Types findTypeById(Long id)
    {
        return finder.byId(id);
    }

    public static List<Types> findAllTypes(){ return finder.query().where().findList();}

    public static Types findTypeByName(String name)
    {
        return finder.query().where().eq("name",name).findOne();
    }

    public static boolean typeExists(String name){return (findTypeByName(name) != null); }

}
