
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
    <version>"""),_display_(/*6.15*/user/*6.19*/.getVersion()),format.raw/*6.32*/("""</version>
    <whenCreated>"""),_display_(/*7.19*/user/*7.23*/.getWhenCreated()),format.raw/*7.40*/("""</whenCreated>
    <whenModified>"""),_display_(/*8.20*/user/*8.24*/.getWhenModified()),format.raw/*8.42*/("""</whenModified>
    <nick>"""),_display_(/*9.12*/user/*9.16*/.getNick()),format.raw/*9.26*/("""</nick>
    <pass>"""),_display_(/*10.12*/user/*10.16*/.getPass()),format.raw/*10.26*/("""</pass>
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
                  HASH: 5733ec495af108368fe97ae1e21df65bd86214eb
                  MATRIX: 898->1|1004->13|1034->17|1117->74|1129->78|1157->86|1204->107|1216->111|1249->124|1305->154|1317->158|1354->175|1415->210|1427->214|1465->232|1519->260|1531->264|1561->274|1608->294|1621->298|1652->308
                  LINES: 27->1|32->1|34->3|36->5|36->5|36->5|37->6|37->6|37->6|38->7|38->7|38->7|39->8|39->8|39->8|40->9|40->9|40->9|41->10|41->10|41->10
                  -- GENERATED --
              */
          