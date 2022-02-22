// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  UserController_1: controllers.UserController,
  // @LINE:15
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    UserController_1: controllers.UserController,
    // @LINE:15
    Assets_0: controllers.Assets
  ) = this(errorHandler, UserController_1, Assets_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, UserController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """usuarios""", """controllers.UserController.getAllUsers()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """usuario/""" + "$" + """userId<[^/]+>""", """controllers.UserController.getUser(request:Request, userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """usuarios""", """controllers.UserController.createUser(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """usuario/""" + "$" + """userNick<[^/]+>""", """controllers.UserController.updateUser(request:Request, userNick:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """usuario/""" + "$" + """userNick<[^/]+>""", """controllers.UserController.deleteUser(userNick:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_UserController_getAllUsers0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("usuarios")))
  )
  private[this] lazy val controllers_UserController_getAllUsers0_invoker = createInvoker(
    UserController_1.getAllUsers(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getAllUsers",
      Nil,
      "GET",
      this.prefix + """usuarios""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_UserController_getUser1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("usuario/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_getUser1_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UserController_1.getUser(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getUser",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """usuario/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_UserController_createUser2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("usuarios")))
  )
  private[this] lazy val controllers_UserController_createUser2_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UserController_1.createUser(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "createUser",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """usuarios""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_UserController_updateUser3_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("usuario/"), DynamicPart("userNick", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_updateUser3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UserController_1.updateUser(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "updateUser",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "PUT",
      this.prefix + """usuario/""" + "$" + """userNick<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_UserController_deleteUser4_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("usuario/"), DynamicPart("userNick", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_deleteUser4_invoker = createInvoker(
    UserController_1.deleteUser(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "deleteUser",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """usuario/""" + "$" + """userNick<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Assets_versioned5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned5_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_UserController_getAllUsers0_route(params@_) =>
      call { 
        controllers_UserController_getAllUsers0_invoker.call(UserController_1.getAllUsers())
      }
  
    // @LINE:7
    case controllers_UserController_getUser1_route(params@_) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_UserController_getUser1_invoker.call(
          req => UserController_1.getUser(req, userId))
      }
  
    // @LINE:8
    case controllers_UserController_createUser2_route(params@_) =>
      call { 
        controllers_UserController_createUser2_invoker.call(
          req => UserController_1.createUser(req))
      }
  
    // @LINE:9
    case controllers_UserController_updateUser3_route(params@_) =>
      call(params.fromPath[String]("userNick", None)) { (userNick) =>
        controllers_UserController_updateUser3_invoker.call(
          req => UserController_1.updateUser(req, userNick))
      }
  
    // @LINE:10
    case controllers_UserController_deleteUser4_route(params@_) =>
      call(params.fromPath[String]("userNick", None)) { (userNick) =>
        controllers_UserController_deleteUser4_invoker.call(UserController_1.deleteUser(userNick))
      }
  
    // @LINE:15
    case controllers_Assets_versioned5_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned5_invoker.call(Assets_0.versioned(path, file))
      }
  }
}
