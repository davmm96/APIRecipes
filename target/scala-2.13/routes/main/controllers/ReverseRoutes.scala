// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:15
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:6
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
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
    def updateUser(userNick:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "usuario/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userNick", userNick)))
    }
  
    // @LINE:10
    def deleteUser(userNick:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "usuario/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userNick", userNick)))
    }
  
    // @LINE:6
    def getAllUsers(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "usuarios")
    }
  
  }


}
