package controllers

import play.api.mvc._
import javax.inject.Inject
import play.api.Configuration

class Application @Inject() (val configuration: Configuration) extends Controller {
  def index = Action { implicit request =>
    Redirect(routes.Products.list())
  }

}