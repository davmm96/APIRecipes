package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;
import validators.Password;

import javax.persistence.*;
import java.util.ArrayList;
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

    @Constraints.Required(message = "error_required")
    @Constraints.Min(value=1,message = "error_number_min")
    private Integer minutes;

    @Constraints.Required(message = "error_required")
    @Constraints.Min(value=1,message = "error_number_min")
    @Constraints.Max(value=10,message = "error_number_max")
    private Integer serves;

    @ManyToOne
    @JsonBackReference
    private User parentUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Steps steps;

    @ManyToOne
    @JsonManagedReference
    private RecipeType type;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Ingredient> ingredients = new ArrayList<>();


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

    public static List<Recipe> findAllRecipes(Integer offset){ return finder.query().where().setMaxRows(5).setFirstRow(offset).findList();}

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

    public Steps getSteps() {
        return steps;
    }

    public void setSteps(Steps steps) {
        this.steps = steps;
    }

    public void removeSteps()
    {
        this.steps = null;
    }

    public RecipeType getType() {
        return type;
    }

    public void setType(RecipeType type) {
        this.type = type;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean hasIngredient (Ingredient ingredient)
    {
        return this.ingredients.contains(ingredient);
    }

    public void removeIngredient(Ingredient ingredient)
    {
        ingredient.deleteRecipe(this);
        this.ingredients.remove(ingredient);
    }

    public void removeIngredients()
    {
        for(Ingredient ingredient: this.ingredients)
        {
            ingredient.deleteRecipe(this);
        }

        this.ingredients = new ArrayList<>();;
    }
}
