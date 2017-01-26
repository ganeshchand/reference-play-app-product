package controllers

import models.Product
import play.api.i18n.{I18nSupport, Messages, MessagesApi}
import play.api.mvc.{Action, Controller}
import javax.inject.Inject
import play.api.Configuration
/**
  * Created by ganeshchand on 1/18/17.
  */
class Products @Inject()(val messagesApi: MessagesApi, implicit val configuration: Configuration)  extends Controller  with I18nSupport {

  def list = Action { implicit request =>
    val products = Product.findAll
    Ok(views.html.products.list(products))
  }

  def show(ean: Long) = Action  { implicit request =>
    Product.findByEan(ean).map { product =>
      Ok(views.html.products.details(product))
    }.getOrElse(NotFound)

  }

}


