package awscala

import scala.collection.JavaConverters._
import com.amazonaws.auth.{ policy => aws }

case class Statement(
  effect: aws.Statement.Effect,
  actions: collection.Seq[Action],
  resources: collection.Seq[Resource],
  id: Option[String] = None,
  conditions: collection.Seq[Condition] = Nil,
  principals: collection.Seq[aws.Principal] = Nil) extends aws.Statement(effect) {

  id.foreach(i => setId(i))
  setEffect(effect)
  setActions(actions.map(_.asInstanceOf[aws.Action]).asJava)
  setConditions(conditions.map(_.asInstanceOf[aws.Condition]).asJava)
  setPrincipals(principals.asJava)
  setResources(resources.map(_.asInstanceOf[aws.Resource]).asJava)
}
