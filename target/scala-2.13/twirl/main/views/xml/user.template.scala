
package views.xml

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.xml._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._
import scala.jdk.CollectionConverters._

object user extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: User):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.14*/("""

"""),format.raw/*3.1*/("""<?xml version="1.0" encoding="UTF-8"?>
<user>
    <name>"""),_display_(/*5.12*/user/*5.16*/.getNick),format.raw/*5.24*/("""</name>
    """),_display_(/*6.6*/_mi_parcial(user.getEdad)),format.raw/*6.31*/("""
"""),format.raw/*7.1*/("""</user>"""))
      }
    }
  }

  def render(user:User): play.twirl.api.XmlFormat.Appendable = apply(user)

  def f:((User) => play.twirl.api.XmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/user.scala.xml
                  HASH: e207adae6a44dd9ea8a06491d0f7f483df28dcbf
                  MATRIX: 898->1|1004->13|1034->17|1119->76|1131->80|1159->88|1198->102|1243->127|1271->129
                  LINES: 27->1|32->1|34->3|36->5|36->5|36->5|37->6|37->6|38->7
                  -- GENERATED --
              */
          