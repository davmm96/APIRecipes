// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseTypesController TypesController = new controllers.ReverseTypesController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseRecipeController RecipeController = new controllers.ReverseRecipeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseTypesController TypesController = new controllers.javascript.ReverseTypesController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseRecipeController RecipeController = new controllers.javascript.ReverseRecipeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
  }

}
