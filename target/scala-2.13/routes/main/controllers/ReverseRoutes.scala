// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:14
  class ReverseRecipeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def createSteps(recipeId:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "recipe/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)) + "/steps")
    }
  
    // @LINE:15
    def getOneRecipe(recipeId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recipe/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)))
    }
  
    // @LINE:14
    def getAllRecipes(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recipes")
    }
  
    // @LINE:19
    def patchRecipe(userId:String, recipeId:String): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)) + "/recipe/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)))
    }
  
    // @LINE:17
    def createRecipe(userId:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)) + "/recipes")
    }
  
    // @LINE:20
    def deleteRecipe(userId:String, recipeId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)) + "/recipe/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)))
    }
  
    // @LINE:25
    def updateSteps(recipeId:String, stepsId:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "recipe/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)) + "/steps/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("stepsId", stepsId)))
    }
  
    // @LINE:18
    def updateRecipe(userId:String, recipeId:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)) + "/recipe/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)))
    }
  
    // @LINE:23
    def getSteps(recipeId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recipe/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)) + "/steps")
    }
  
    // @LINE:16
    def getUserRecipes(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)) + "/recipes")
    }
  
    // @LINE:26
    def deleteSteps(recipeId:String, stepsId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "recipe/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("recipeId", recipeId)) + "/steps/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("stepsId", stepsId)))
    }
  
  }

  // @LINE:6
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def deleteUser(userId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:7
    def getUser(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:8
    def createUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:10
    def updateUserNick(userId:String): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:9
    def updateUser(userId:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "user/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:6
    def getAllUsers(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users")
    }
  
  }


}
