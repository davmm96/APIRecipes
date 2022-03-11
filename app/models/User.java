package models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;
import validators.Password;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends Model
{
    private static final Finder<Long,User> finder = new Finder<>(User.class);

    //Attributes
    @Id
    private Long id;

    @Constraints.Required(message = "error_required")
    @Constraints.MinLength(value=3,message = "error_extension")
    private String nick;

    @Constraints.Required(message = "error_required")
    @Password(message = "error_pass")
    private String pass;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentUser")
    @JsonManagedReference
    private List<Recipe> recipes = new ArrayList<>();

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

    public static List<User> findAllUsers(Integer offset){ return finder.query().where().setMaxRows(5).setFirstRow(offset).findList();}

    public static User findUserByNick(String nick)
    {
        return finder.query().where().eq("nick",nick).findOne();
    }

    public static boolean nickExists(String nick){return (findUserByNick(nick) != null); }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void addRecipe(Recipe recipe)
    {
        this.recipes.add(recipe);
        recipe.setParentUser(this);
    }

    public void updateRecipe(Recipe recipe, Recipe recipeAux)
    {
        this.recipes.set(this.recipes.indexOf(recipeAux), recipe);
    }

    public void removeRecipe(Recipe recipe)
    {
        recipe.removeParentUser();
        this.recipes.remove(recipe);
    }
}
