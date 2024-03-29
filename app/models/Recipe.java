package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @Constraints.Required(message = "error_required")
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Steps steps;

    @Constraints.Required(message = "error_required")
    @ManyToOne
    @JsonManagedReference
    private RecipeType type;

    @Constraints.Required(message = "error_required")
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

    public static boolean recipeExists(String name, Long userId)
    {
        Recipe recipeFound = finder.query().where().eq("name",name).eq("parent_user_id",userId).findOne();
        return (recipeFound != null);
    }

    public static List<Recipe> findAllRecipes(Integer offset)
    {
        return finder.query().where().setMaxRows(10).setFirstRow(offset).findList();
    }

    public static List<Recipe> findRecipesByMinuteMax(Integer offset, Integer minuteMax)
    {
        return finder.query().where().le("minutes",minuteMax).setMaxRows(10).setFirstRow(offset).findList();
    }

    public static List<Recipe> findRecipesByMinuteMin(Integer offset, Integer minuteMin)
    {
        return finder.query().where().ge("minutes",minuteMin).setMaxRows(10).setFirstRow(offset).findList();
    }

    public static List<Recipe> findRecipesByServes(Integer offset, Integer serves)
    {
        return finder.query().where().eq("serves",serves).setMaxRows(10).setFirstRow(offset).findList();
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

    public void removeParentUser() {
        this.parentUser = null;
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

    public void addIngredient(Ingredient ingredient)
    {
        this.ingredients.add(ingredient);
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
