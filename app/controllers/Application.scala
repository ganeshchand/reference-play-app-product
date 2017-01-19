package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {
  val messages = List("Welcome to the Play Application",
    "This HelloWorld app is fully functional"
  )

  def index = Action {
    Ok(views.html.hello("world",messages ))

  }

  def hello(name: String) = Action {
//    Ok(s"Hello, $name") // just returns HTTP 200 response
    Ok(views.html.hello(name, messages)) // renders the name
  }

}