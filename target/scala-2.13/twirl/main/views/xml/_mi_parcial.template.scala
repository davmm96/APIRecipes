
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

object _mi_parcial extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[Int,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(edad: Int):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.13*/("""
"""),_display_(/*2.2*/if(edad > 0)/*2.14*/ {_display_(Seq[Any](format.raw/*2.16*/("""
    """),format.raw/*3.5*/("""<age> """),_display_(/*3.12*/edad),format.raw/*3.16*/("""</age>
""")))}),format.raw/*4.2*/("""
"""))
      }
    }
  }

  def render(edad:Int): play.twirl.api.XmlFormat.Appendable = apply(edad)

  def f:((Int) => play.twirl.api.XmlFormat.Appendable) = (edad) => apply(edad)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/_mi_parcial.scala.xml
                  HASH: f823e0c84d0be815991310f0a23a31800590ded2
                  MATRIX: 904->1|1009->12|1037->15|1057->27|1096->29|1128->35|1161->42|1185->46|1223->55
                  LINES: 27->1|32->1|33->2|33->2|33->2|34->3|34->3|34->3|35->4
                  -- GENERATED --
              */
          