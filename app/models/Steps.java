package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Steps extends Model
{
    private static final Finder<Long, Steps> finder = new Finder<>(Steps.class);

    //Attributes
    @Id
    private Long id;

    @Constraints.Required(message = "error_required")
    private String steps;

    @OneToOne(mappedBy = "steps")
    @JsonBackReference
    private Recipe parentRecipe;


    //Getters and setters
    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
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
        if(obj instanceof Steps)
        {
            Steps objUser = (Steps) obj;

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

    public Recipe getParentRecipe() {
        return parentRecipe;
    }

    public static Steps findStepsById(Long id)
    {
        return finder.byId(id);
    }

    public Long getParentRecipeId()
    {
        return parentRecipe.getId();
    }

    public void setParentRecipe(Recipe parentRecipe) {
        this.parentRecipe = parentRecipe;
        parentRecipe.setSteps(this);
    }
}
