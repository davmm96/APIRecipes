// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:29
  class ReverseRecipeTypeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def deleteType: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeTypeController.deleteType",
      """
        function(typeId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "type/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("typeId", typeId0))})
        }
      """
    )
  
    // @LINE:29
    def getAllTypes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeTypeController.getAllTypes",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "types"})
        }
      """
    )
  
    // @LINE:30
    def getType: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeTypeController.getType",
      """
        function(typeId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "type/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("typeId", typeId0))})
        }
      """
    )
  
    // @LINE:31
    def createType: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeTypeController.createType",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "types"})
        }
      """
    )
  
    // @LINE:32
    def updateType: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeTypeController.updateType",
      """
        function(typeId0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "type/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("typeId", typeId0))})
        }
      """
    )
  
  }

  // @LINE:36
  class ReverseIngredientController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:40
    def deleteIngredient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredientController.deleteIngredient",
      """
        function(ingredientId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "ingredient/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("ingredientId", ingredientId0))})
        }
      """
    )
  
    // @LINE:37
    def getIngredient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredientController.getIngredient",
      """
        function(ingredientId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ingredient/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("ingredientId", ingredientId0))})
        }
      """
    )
  
    // @LINE:39
    def updateIngredient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredientController.updateIngredient",
      """
        function(ingredientId0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "ingredient/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("ingredientId", ingredientId0))})
        }
      """
    )
  
    // @LINE:36
    def getAllIngredients: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.IngredientController.getAllIngredients",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ingredients"})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseRecipeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def createSteps: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.createSteps",
      """
        function(recipeId0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "recipe/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/steps"})
        }
      """
    )
  
    // @LINE:15
    def getOneRecipe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.getOneRecipe",
      """
        function(recipeId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recipe/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0))})
        }
      """
    )
  
    // @LINE:14
    def getAllRecipes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.getAllRecipes",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recipes"})
        }
      """
    )
  
    // @LINE:19
    def patchRecipe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.patchRecipe",
      """
        function(userId0,recipeId1) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0)) + "/recipe/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId1))})
        }
      """
    )
  
    // @LINE:17
    def createRecipe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.createRecipe",
      """
        function(userId0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0)) + "/recipes"})
        }
      """
    )
  
    // @LINE:41
    def deleteIngredients: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.deleteIngredients",
      """
        function(recipeId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "recipe/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/ingredients"})
        }
      """
    )
  
    // @LINE:20
    def deleteRecipe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.deleteRecipe",
      """
        function(userId0,recipeId1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0)) + "/recipe/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId1))})
        }
      """
    )
  
    // @LINE:25
    def updateSteps: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.updateSteps",
      """
        function(recipeId0,stepsId1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "recipe/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/steps/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("stepsId", stepsId1))})
        }
      """
    )
  
    // @LINE:18
    def updateRecipe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.updateRecipe",
      """
        function(userId0,recipeId1) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0)) + "/recipe/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId1))})
        }
      """
    )
  
    // @LINE:23
    def getSteps: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.getSteps",
      """
        function(recipeId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recipe/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/steps"})
        }
      """
    )
  
    // @LINE:16
    def getUserRecipes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.getUserRecipes",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0)) + "/recipes"})
        }
      """
    )
  
    // @LINE:42
    def deleteIngredient: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.deleteIngredient",
      """
        function(recipeId0,ingredientId1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "recipe/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/ingredient/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("ingredientId", ingredientId1))})
        }
      """
    )
  
    // @LINE:38
    def getIngredients: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.getIngredients",
      """
        function(recipeId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recipe/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/ingredients"})
        }
      """
    )
  
    // @LINE:26
    def deleteSteps: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.deleteSteps",
      """
        function(recipeId0,stepsId1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "recipe/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0)) + "/steps/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("stepsId", stepsId1))})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def deleteUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.deleteUser",
      """
        function(userId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:7
    def getUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getUser",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:8
    def createUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.createUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
    // @LINE:10
    def updateUserNick: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.updateUserNick",
      """
        function(userId0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:9
    def updateUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.updateUser",
      """
        function(userId0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:6
    def getAllUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getAllUsers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
  }


}
