package swagger.model

import io.swagger.models.Model
import io.swagger.models.properties.Property
import io.swagger.models.refs.GenericRef

trait Parameter {
  def in: String
  def access: String
  def name: String
  def description: String
  def required: Boolean
  def pattern: String
  def readOnly: Boolean
  def allowEmptyValue: Boolean
}

case class RefParameter(genericRef: GenericRef,
                        in: String,
                        access: String,
                        name: String,
                        description: String,
                        required: Boolean,
                        pattern: String,
                        readOnly: Boolean,
                        allowEmptyValue: Boolean)
    extends Parameter

case class BodyParameter(schema: Model,
                         examples: Map[String, String],
                         genericRef: GenericRef,
                         in: String,
                         access: String,
                         name: String,
                         description: String,
                         required: Boolean,
                         pattern: String,
                         readOnly: Boolean,
                         allowEmptyValue: Boolean)
    extends Parameter

trait ExtendedParameter extends Parameter {
  def `type`: String
  def format: String
  def collectionFormat: String
  def items: Property
  def exclusiveMaximum: Boolean
  def maximum: Boolean
  def exclusiveMinimum: Boolean
  def minimum: BigDecimal
  def example: String
  def maxItems: Int
  def minItems: Int

  def defaultCollectionFormat = "csv"
}

case class HeaderParameter(schema: Model,
                           examples: Map[String, String],
                           genericRef: GenericRef,
                           access: String,
                           name: String,
                           description: String,
                           required: Boolean,
                           pattern: String,
                           readOnly: Boolean,
                           allowEmptyValue: Boolean,
                           `type`: String,
                           format: String,
                           collectionFormat: String,
                           items: Property,
                           exclusiveMaximum: Boolean,
                           maximum: Boolean,
                           exclusiveMinimum: Boolean,
                           minimum: BigDecimal,
                           example: String,
                           maxItems: Int,
                           minItems: Int)
    extends ExtendedParameter {
  val in = "header"
}

case class FormParameter(schema: Model,
                         examples: Map[String, String],
                         genericRef: GenericRef,
                         access: String,
                         name: String,
                         description: String,
                         required: Boolean,
                         pattern: String,
                         readOnly: Boolean,
                         allowEmptyValue: Boolean,
                         `type`: String,
                         format: String,
                         collectionFormat: String,
                         items: Property,
                         exclusiveMaximum: Boolean,
                         maximum: Boolean,
                         exclusiveMinimum: Boolean,
                         minimum: BigDecimal,
                         example: String,
                         maxItems: Int,
                         minItems: Int)
    extends ExtendedParameter {

  val in = "formData"

  override def defaultCollectionFormat: String = "multi"
}

case class PathParameter(schema: Model,
                         examples: Map[String, String],
                         genericRef: GenericRef,
                         access: String,
                         name: String,
                         description: String,
                         pattern: String,
                         readOnly: Boolean,
                         allowEmptyValue: Boolean,
                         `type`: String,
                         format: String,
                         collectionFormat: String,
                         items: Property,
                         exclusiveMaximum: Boolean,
                         maximum: Boolean,
                         exclusiveMinimum: Boolean,
                         minimum: BigDecimal,
                         example: String,
                         maxItems: Int,
                         minItems: Int)
    extends ExtendedParameter {

  val in       = "path"
  val required = true

}

case class CookieParameter(schema: Model,
                           examples: Map[String, String],
                           genericRef: GenericRef,
                           access: String,
                           name: String,
                           description: String,
                           required: Boolean,
                           pattern: String,
                           readOnly: Boolean,
                           allowEmptyValue: Boolean,
                           `type`: String,
                           format: String,
                           collectionFormat: String,
                           items: Property,
                           exclusiveMaximum: Boolean,
                           maximum: Boolean,
                           exclusiveMinimum: Boolean,
                           minimum: BigDecimal,
                           example: String,
                           maxItems: Int,
                           minItems: Int)
    extends ExtendedParameter {

  val in = "cookie"

}

case class QueryParameter(schema: Model,
                          examples: Map[String, String],
                          genericRef: GenericRef,
                          access: String,
                          name: String,
                          description: String,
                          required: Boolean,
                          pattern: String,
                          readOnly: Boolean,
                          allowEmptyValue: Boolean,
                          `type`: String,
                          format: String,
                          collectionFormat: String,
                          items: Property,
                          exclusiveMaximum: Boolean,
                          maximum: Boolean,
                          exclusiveMinimum: Boolean,
                          minimum: BigDecimal,
                          example: String,
                          maxItems: Int,
                          minItems: Int)
    extends ExtendedParameter {

  val in                                       = "query"
  override def defaultCollectionFormat: String = "multi"

}
