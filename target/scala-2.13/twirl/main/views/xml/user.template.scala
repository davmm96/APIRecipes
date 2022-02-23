
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
    <id>"""),_display_(/*5.10*/user/*5.14*/.getId()),format.raw/*5.22*/("""</id>
    <nick>"""),_display_(/*6.12*/user/*6.16*/.getNick()),format.raw/*6.26*/("""</nick>
    <pass>"""),_display_(/*7.12*/user/*7.16*/.getPass()),format.raw/*7.26*/("""</pass>
</user>"""))
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
                  HASH: ce83e1f4ddcf1a01f509d0aa438679706266280b
                  MATRIX: 898->1|1004->13|1034->17|1117->74|1129->78|1157->86|1201->104|1213->108|1243->118|1289->138|1301->142|1331->152
                  LINES: 27->1|32->1|34->3|36->5|36->5|36->5|37->6|37->6|37->6|38->7|38->7|38->7
                  -- GENERATED --
              */
          