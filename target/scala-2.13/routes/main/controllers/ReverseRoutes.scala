// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def deleteUser(userId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "usuario/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:7
    def getUser(userId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "usuario/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:8
    def createUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "usuarios")
    }
  
    // @LINE:9
    def updateUser(userId:String): Call = {
      
      Call("PATCH", _prefix + { _defaultPrefix } + "usuario/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userId", userId)))
    }
  
    // @LINE:6
    def getAllUsers(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "usuarios")
    }
  
  }


}
