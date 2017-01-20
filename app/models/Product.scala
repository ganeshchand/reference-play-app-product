package models

/**
  * Created by ganeshchand on 1/18/17.
  */
case class Product(ean: Long, name: String, description: String) {
  override def toString = s"$ean - $name"
}

object Product {
  var products = Set(
    Product(5010255079763L, "Paperclips Large", "Large Plain Pack of 1000"),
    Product(5018206244666L, "Giant Paperclips", "Giant Plain 51mm 100 pack"),
    Product(5018306332812L, "Paperclip Giant Plain", "Giant Plain Pack of 10000"),
    Product(5018306312913L, "No Tear Paper Clip", "No Tear Extra Large Pack of 1000"),
    Product(5018206244611L, "Zebra Paperclips", "Zebra Length 28mm Assorted 150 Pack")
  )

  /**
    *
    * @return returns a list of [[Product]] sorted by `EAN code`
    */
  def findAll = products.toList.sortBy(_.ean)

  /**
    *
    * @param ean the EAN code of the [[Product]]
    * @return returns a [[Product]] that matches the given EAN code
    */
  def findByEan(ean: Long) = products.filter(_.ean == ean)


  /**
    *
    * @param name the `name` of the [[Product]]
    * @return returns a [[Product]] matching the given `name`
    */
  def findByName(name: String) = products.filter(_.name.toLowerCase == name.toLowerCase)


  /**
    * Adds a given product to an existing set of products
    * @param product an instance of [[Product]]
    * @return returns an updated set of products
    */
  def add(product: Product) = products + product

  def remove(product: Product) = {
    val oldProducts = products
    products = products - product
    oldProducts.contains(product)
  }


}


