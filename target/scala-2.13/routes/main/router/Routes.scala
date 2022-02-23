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
  // @LINE:14
  RecipeController_0: controllers.RecipeController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    UserController_1: controllers.UserController,
    // @LINE:14
    RecipeController_0: controllers.RecipeController
  ) = this(errorHandler, UserController_1, RecipeController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, UserController_1, RecipeController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """usuarios""", """controllers.UserController.getAllUsers(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """usuario/""" + "$" + """userId<[^/]+>""", """controllers.UserController.getUser(request:Request, userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """usuarios""", """controllers.UserController.createUser(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """usuario/""" + "$" + """userId<[^/]+>""", """controllers.UserController.updateUser(request:Request, userId:String)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """usuario/""" + "$" + """userId<[^/]+>""", """controllers.UserController.updateUserNick(request:Request, userId:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """usuario/""" + "$" + """userId<[^/]+>""", """controllers.UserController.deleteUser(request:Request, userId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recetas""", """controllers.RecipeController.getAllRecipes(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """usuario/""" + "$" + """userId<[^/]+>/recetas""", """controllers.RecipeController.getUserRecipes(request:Request, userId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """recipeId<[^/]+>""", """controllers.RecipeController.getOneRecipe(request:Request, recipeId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """usuario/""" + "$" + """userId<[^/]+>/recetas""", """controllers.RecipeController.createRecipe(request:Request, userId:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """receta/""" + "$" + """recipeId<[^/]+>""", """controllers.RecipeController.deleteRecipe(request:Request, recipeId:String)"""),
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
    
    (req:play.mvc.Http.Request) =>
      UserController_1.getAllUsers(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getAllUsers",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """usuarios""",
      """USUARIOS""",
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
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("usuario/"), DynamicPart("userId", """[^/]+""",true)))
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
      this.prefix + """usuario/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_UserController_updateUserNick4_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("usuario/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_updateUserNick4_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UserController_1.updateUserNick(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "updateUserNick",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "PATCH",
      this.prefix + """usuario/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_UserController_deleteUser5_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("usuario/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_deleteUser5_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      UserController_1.deleteUser(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "deleteUser",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "DELETE",
      this.prefix + """usuario/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_RecipeController_getAllRecipes6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recetas")))
  )
  private[this] lazy val controllers_RecipeController_getAllRecipes6_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_0.getAllRecipes(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "getAllRecipes",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """recetas""",
      """RECETAS""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_RecipeController_getUserRecipes7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("usuario/"), DynamicPart("userId", """[^/]+""",true), StaticPart("/recetas")))
  )
  private[this] lazy val controllers_RecipeController_getUserRecipes7_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_0.getUserRecipes(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "getUserRecipes",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """usuario/""" + "$" + """userId<[^/]+>/recetas""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_RecipeController_getOneRecipe8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("recipeId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecipeController_getOneRecipe8_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_0.getOneRecipe(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "getOneRecipe",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """receta/""" + "$" + """recipeId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_RecipeController_createRecipe9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("usuario/"), DynamicPart("userId", """[^/]+""",true), StaticPart("/recetas")))
  )
  private[this] lazy val controllers_RecipeController_createRecipe9_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_0.createRecipe(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "createRecipe",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "POST",
      this.prefix + """usuario/""" + "$" + """userId<[^/]+>/recetas""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_RecipeController_deleteRecipe10_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("receta/"), DynamicPart("recipeId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecipeController_deleteRecipe10_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_0.deleteRecipe(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "deleteRecipe",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "DELETE",
      this.prefix + """receta/""" + "$" + """recipeId<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_UserController_getAllUsers0_route(params@_) =>
      call { 
        controllers_UserController_getAllUsers0_invoker.call(
          req => UserController_1.getAllUsers(req))
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
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_UserController_updateUser3_invoker.call(
          req => UserController_1.updateUser(req, userId))
      }
  
    // @LINE:10
    case controllers_UserController_updateUserNick4_route(params@_) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_UserController_updateUserNick4_invoker.call(
          req => UserController_1.updateUserNick(req, userId))
      }
  
    // @LINE:11
    case controllers_UserController_deleteUser5_route(params@_) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_UserController_deleteUser5_invoker.call(
          req => UserController_1.deleteUser(req, userId))
      }
  
    // @LINE:14
    case controllers_RecipeController_getAllRecipes6_route(params@_) =>
      call { 
        controllers_RecipeController_getAllRecipes6_invoker.call(
          req => RecipeController_0.getAllRecipes(req))
      }
  
    // @LINE:15
    case controllers_RecipeController_getUserRecipes7_route(params@_) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_RecipeController_getUserRecipes7_invoker.call(
          req => RecipeController_0.getUserRecipes(req, userId))
      }
  
    // @LINE:16
    case controllers_RecipeController_getOneRecipe8_route(params@_) =>
      call(params.fromPath[String]("recipeId", None)) { (recipeId) =>
        controllers_RecipeController_getOneRecipe8_invoker.call(
          req => RecipeController_0.getOneRecipe(req, recipeId))
      }
  
    // @LINE:17
    case controllers_RecipeController_createRecipe9_route(params@_) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_RecipeController_createRecipe9_invoker.call(
          req => RecipeController_0.createRecipe(req, userId))
      }
  
    // @LINE:18
    case controllers_RecipeController_deleteRecipe10_route(params@_) =>
      call(params.fromPath[String]("recipeId", None)) { (recipeId) =>
        controllers_RecipeController_deleteRecipe10_invoker.call(
          req => RecipeController_0.deleteRecipe(req, recipeId))
      }
  }
}
