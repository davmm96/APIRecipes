// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:14
  class ReverseRecipeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def getOneRecipe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.getOneRecipe",
      """
        function(recipeId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0))})
        }
      """
    )
  
    // @LINE:14
    def getAllRecipes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.getAllRecipes",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recetas"})
        }
      """
    )
  
    // @LINE:17
    def createRecipe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.createRecipe",
      """
        function(userId0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "usuario/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0)) + "/recetas"})
        }
      """
    )
  
    // @LINE:18
    def deleteRecipe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.deleteRecipe",
      """
        function(recipeId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "receta/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("recipeId", recipeId0))})
        }
      """
    )
  
    // @LINE:15
    def getUserRecipes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RecipeController.getUserRecipes",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "usuario/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0)) + "/recetas"})
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
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "usuario/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:7
    def getUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getUser",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "usuario/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:8
    def createUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.createUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "usuarios"})
        }
      """
    )
  
    // @LINE:10
    def updateUserNick: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.updateUserNick",
      """
        function(userId0) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "usuario/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:9
    def updateUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.updateUser",
      """
        function(userId0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "usuario/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:6
    def getAllUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getAllUsers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "usuarios"})
        }
      """
    )
  
  }


}
