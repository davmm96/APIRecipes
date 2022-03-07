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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UserController.getAllUsers(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """userId<[^/]+>""", """controllers.UserController.getUser(request:Request, userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UserController.createUser(request:Request)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """userId<[^/]+>""", """controllers.UserController.updateUser(request:Request, userId:String)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """userId<[^/]+>""", """controllers.UserController.updateUserNick(request:Request, userId:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """userId<[^/]+>""", """controllers.UserController.deleteUser(request:Request, userId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recipes""", """controllers.RecipeController.getAllRecipes(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recipe/""" + "$" + """recipeId<[^/]+>""", """controllers.RecipeController.getOneRecipe(request:Request, recipeId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """userId<[^/]+>/recipes""", """controllers.RecipeController.getUserRecipes(request:Request, userId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """userId<[^/]+>/recipes""", """controllers.RecipeController.createRecipe(request:Request, userId:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """userId<[^/]+>/recipe/""" + "$" + """recipeId<[^/]+>""", """controllers.RecipeController.updateRecipe(request:Request, userId:String, recipeId:String)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """userId<[^/]+>/recipe/""" + "$" + """recipeId<[^/]+>""", """controllers.RecipeController.patchRecipe(request:Request, userId:String, recipeId:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """userId<[^/]+>/recipe/""" + "$" + """recipeId<[^/]+>""", """controllers.RecipeController.deleteRecipe(request:Request, userId:String, recipeId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recipe/""" + "$" + """recipeId<[^/]+>/steps""", """controllers.RecipeController.getSteps(request:Request, recipeId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recipe/""" + "$" + """recipeId<[^/]+>/steps""", """controllers.RecipeController.createSteps(request:Request, recipeId:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recipe/""" + "$" + """recipeId<[^/]+>/steps/""" + "$" + """stepsId<[^/]+>""", """controllers.RecipeController.updateSteps(request:Request, recipeId:String, stepsId:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recipe/""" + "$" + """recipeId<[^/]+>/steps/""" + "$" + """stepsId<[^/]+>""", """controllers.RecipeController.deleteSteps(request:Request, recipeId:String, stepsId:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_UserController_getAllUsers0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
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
      this.prefix + """users""",
      """USERS""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_UserController_getUser1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("userId", """[^/]+""",true)))
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
      this.prefix + """user/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_UserController_createUser2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
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
      this.prefix + """users""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_UserController_updateUser3_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("userId", """[^/]+""",true)))
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
      this.prefix + """user/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_UserController_updateUserNick4_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("userId", """[^/]+""",true)))
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
      this.prefix + """user/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_UserController_deleteUser5_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("userId", """[^/]+""",true)))
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
      this.prefix + """user/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_RecipeController_getAllRecipes6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recipes")))
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
      this.prefix + """recipes""",
      """RECIPES""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_RecipeController_getOneRecipe7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recipe/"), DynamicPart("recipeId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecipeController_getOneRecipe7_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_0.getOneRecipe(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "getOneRecipe",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """recipe/""" + "$" + """recipeId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_RecipeController_getUserRecipes8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("userId", """[^/]+""",true), StaticPart("/recipes")))
  )
  private[this] lazy val controllers_RecipeController_getUserRecipes8_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_0.getUserRecipes(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "getUserRecipes",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """user/""" + "$" + """userId<[^/]+>/recipes""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_RecipeController_createRecipe9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("userId", """[^/]+""",true), StaticPart("/recipes")))
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
      this.prefix + """user/""" + "$" + """userId<[^/]+>/recipes""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_RecipeController_updateRecipe10_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("userId", """[^/]+""",true), StaticPart("/recipe/"), DynamicPart("recipeId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecipeController_updateRecipe10_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_0.updateRecipe(fakeValue[play.mvc.Http.Request], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "updateRecipe",
      Seq(classOf[play.mvc.Http.Request], classOf[String], classOf[String]),
      "PUT",
      this.prefix + """user/""" + "$" + """userId<[^/]+>/recipe/""" + "$" + """recipeId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_RecipeController_patchRecipe11_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("userId", """[^/]+""",true), StaticPart("/recipe/"), DynamicPart("recipeId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecipeController_patchRecipe11_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_0.patchRecipe(fakeValue[play.mvc.Http.Request], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "patchRecipe",
      Seq(classOf[play.mvc.Http.Request], classOf[String], classOf[String]),
      "PATCH",
      this.prefix + """user/""" + "$" + """userId<[^/]+>/recipe/""" + "$" + """recipeId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_RecipeController_deleteRecipe12_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("userId", """[^/]+""",true), StaticPart("/recipe/"), DynamicPart("recipeId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecipeController_deleteRecipe12_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_0.deleteRecipe(fakeValue[play.mvc.Http.Request], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "deleteRecipe",
      Seq(classOf[play.mvc.Http.Request], classOf[String], classOf[String]),
      "DELETE",
      this.prefix + """user/""" + "$" + """userId<[^/]+>/recipe/""" + "$" + """recipeId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_RecipeController_getSteps13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recipe/"), DynamicPart("recipeId", """[^/]+""",true), StaticPart("/steps")))
  )
  private[this] lazy val controllers_RecipeController_getSteps13_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_0.getSteps(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "getSteps",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """recipe/""" + "$" + """recipeId<[^/]+>/steps""",
      """STEPS""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_RecipeController_createSteps14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recipe/"), DynamicPart("recipeId", """[^/]+""",true), StaticPart("/steps")))
  )
  private[this] lazy val controllers_RecipeController_createSteps14_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_0.createSteps(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "createSteps",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "POST",
      this.prefix + """recipe/""" + "$" + """recipeId<[^/]+>/steps""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_RecipeController_updateSteps15_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recipe/"), DynamicPart("recipeId", """[^/]+""",true), StaticPart("/steps/"), DynamicPart("stepsId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecipeController_updateSteps15_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_0.updateSteps(fakeValue[play.mvc.Http.Request], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "updateSteps",
      Seq(classOf[play.mvc.Http.Request], classOf[String], classOf[String]),
      "PUT",
      this.prefix + """recipe/""" + "$" + """recipeId<[^/]+>/steps/""" + "$" + """stepsId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_RecipeController_deleteSteps16_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recipe/"), DynamicPart("recipeId", """[^/]+""",true), StaticPart("/steps/"), DynamicPart("stepsId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RecipeController_deleteSteps16_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      RecipeController_0.deleteSteps(fakeValue[play.mvc.Http.Request], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RecipeController",
      "deleteSteps",
      Seq(classOf[play.mvc.Http.Request], classOf[String], classOf[String]),
      "DELETE",
      this.prefix + """recipe/""" + "$" + """recipeId<[^/]+>/steps/""" + "$" + """stepsId<[^/]+>""",
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
    case controllers_RecipeController_getOneRecipe7_route(params@_) =>
      call(params.fromPath[String]("recipeId", None)) { (recipeId) =>
        controllers_RecipeController_getOneRecipe7_invoker.call(
          req => RecipeController_0.getOneRecipe(req, recipeId))
      }
  
    // @LINE:16
    case controllers_RecipeController_getUserRecipes8_route(params@_) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_RecipeController_getUserRecipes8_invoker.call(
          req => RecipeController_0.getUserRecipes(req, userId))
      }
  
    // @LINE:17
    case controllers_RecipeController_createRecipe9_route(params@_) =>
      call(params.fromPath[String]("userId", None)) { (userId) =>
        controllers_RecipeController_createRecipe9_invoker.call(
          req => RecipeController_0.createRecipe(req, userId))
      }
  
    // @LINE:18
    case controllers_RecipeController_updateRecipe10_route(params@_) =>
      call(params.fromPath[String]("userId", None), params.fromPath[String]("recipeId", None)) { (userId, recipeId) =>
        controllers_RecipeController_updateRecipe10_invoker.call(
          req => RecipeController_0.updateRecipe(req, userId, recipeId))
      }
  
    // @LINE:19
    case controllers_RecipeController_patchRecipe11_route(params@_) =>
      call(params.fromPath[String]("userId", None), params.fromPath[String]("recipeId", None)) { (userId, recipeId) =>
        controllers_RecipeController_patchRecipe11_invoker.call(
          req => RecipeController_0.patchRecipe(req, userId, recipeId))
      }
  
    // @LINE:20
    case controllers_RecipeController_deleteRecipe12_route(params@_) =>
      call(params.fromPath[String]("userId", None), params.fromPath[String]("recipeId", None)) { (userId, recipeId) =>
        controllers_RecipeController_deleteRecipe12_invoker.call(
          req => RecipeController_0.deleteRecipe(req, userId, recipeId))
      }
  
    // @LINE:23
    case controllers_RecipeController_getSteps13_route(params@_) =>
      call(params.fromPath[String]("recipeId", None)) { (recipeId) =>
        controllers_RecipeController_getSteps13_invoker.call(
          req => RecipeController_0.getSteps(req, recipeId))
      }
  
    // @LINE:24
    case controllers_RecipeController_createSteps14_route(params@_) =>
      call(params.fromPath[String]("recipeId", None)) { (recipeId) =>
        controllers_RecipeController_createSteps14_invoker.call(
          req => RecipeController_0.createSteps(req, recipeId))
      }
  
    // @LINE:25
    case controllers_RecipeController_updateSteps15_route(params@_) =>
      call(params.fromPath[String]("recipeId", None), params.fromPath[String]("stepsId", None)) { (recipeId, stepsId) =>
        controllers_RecipeController_updateSteps15_invoker.call(
          req => RecipeController_0.updateSteps(req, recipeId, stepsId))
      }
  
    // @LINE:26
    case controllers_RecipeController_deleteSteps16_route(params@_) =>
      call(params.fromPath[String]("recipeId", None), params.fromPath[String]("stepsId", None)) { (recipeId, stepsId) =>
        controllers_RecipeController_deleteSteps16_invoker.call(
          req => RecipeController_0.deleteSteps(req, recipeId, stepsId))
      }
  }
}
