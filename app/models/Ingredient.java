package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient extends Model
{
    private static final Finder<Long, Ingredient> finder = new Finder<>(Ingredient.class);

    //Attributes
    @Id
    private Long id;

    @Constraints.Required(message = "error_required")
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    @JsonBackReference
    private List<Recipe> recipes = new ArrayList<>();


    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
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
        if(obj instanceof Ingredient && obj != null)
        {
            Ingredient objUser = (Ingredient) obj;

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

    public static Ingredient findIngredientById(Long id)
    {
        return finder.byId(id);
    }

    public static List<Ingredient> findAllIngredients(){ return finder.query().where().findList();}

    public static Ingredient findIngredientByName(String name)
    {
        return finder.query().where().eq("name",name).findOne();
    }

    public static boolean ingredientExists(String name){return (findIngredientByName(name) != null); }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void deleteRecipe(Recipe recipe)
    {
        this.recipes.remove(recipe);
    }
}
