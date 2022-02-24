package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;
import validators.Password;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Recipe extends Model
{
    private static final Finder<Long, Recipe> finder = new Finder<>(Recipe.class);

    //Attributes
    @Id
    private Long id;

    @Constraints.Required(message = "error_required")
    @Constraints.MinLength(value=2,message = "error_extension")
    private String name;

    @Constraints.Min(value=1,message = "error_number_min")
    private Integer minutes;

    @Constraints.Min(value=1,message = "error_number_min")
    @Constraints.Max(value=10,message = "error_number_max")
    private Integer serves;

    @ManyToOne
    @JsonBackReference
    private User parentUser;


    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getServes() {
        return serves;
    }

    public void setServes(Integer serves) {
        this.serves = serves;
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
        if(obj instanceof Recipe)
        {
            Recipe objUser = (Recipe) obj;

            if(objUser.getId() == null)
            {
                return false;
            }

            return objUser.getId().equals(this.getId());
        }
        else
        {
            return false;
        }
    }

    public static Recipe findRecipeById(Long id)
    {
        return finder.byId(id);
    }

    public User getParentUser() {
        return parentUser;
    }

    public Long getParentUserId()
    {
        return parentUser.getId();
    }

    public void setParentUser(User parentUser) {
        this.parentUser = parentUser;
    }
}
