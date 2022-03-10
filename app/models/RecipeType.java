package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.ebean.Finder;
import io.ebean.Model;
import io.ebean.annotation.JsonIgnore;
import play.data.validation.Constraints;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RecipeType extends Model
{
    private static final Finder<Long, RecipeType> finder = new Finder<>(RecipeType.class);

    //Attributes
    @Id
    private Long id;

    @Constraints.Required(message = "error_required")
    private String typeName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    @JsonBackReference
    private List<Recipe> recipes = new ArrayList<>();


    //Getters and setters
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
        if(obj instanceof RecipeType && obj != null)
        {
            RecipeType objUser = (RecipeType) obj;

            if(objUser.getTypeName() == null)
            {
                return false;
            }

            return objUser.getTypeName().equals(this.getTypeName());
        }
        else
        {
            return false;
        }
    }

    public static RecipeType findTypeById(Long id)
    {
        return finder.byId(id);
    }

    public static List<RecipeType> findAllTypes(){ return finder.query().where().findList();}

    public static RecipeType findTypeByName(String typeName)
    {
        return finder.query().where().eq("typeName",typeName).findOne();
    }

    public static boolean typeExists(String typeName){return (findTypeByName(typeName) != null); }

    public List<Recipe> getRecipes() {
        return recipes;
    }


    public void addRecipe(Recipe recipe)
    {
        this.recipes.add(recipe);
        recipe.setType(this);
    }
}
