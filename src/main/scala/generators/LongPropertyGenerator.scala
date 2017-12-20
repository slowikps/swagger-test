package generators

import io.swagger.models.properties.LongProperty
import org.scalacheck.Gen

import scala.collection.JavaConverters._

class LongPropertyGenerator(property: LongProperty) {

  def generator(): Gen[Long] = {
    if (property.getReadOnly) Gen.fail[Long]
    else if (property.getRequired) innerGen()
    else Gen.frequency((5, innerGen()), (1, Gen.fail[Long]))
  }

  private def innerGen(): Gen[Long] = {
    if (!property.getEnum.isEmpty) Gen.oneOf(property.getEnum.asScala.map(_.toLong))
    else {
      val min: BigDecimal = {
        val minExclusive    = Option[Boolean](property.getExclusiveMinimum).getOrElse(false)
        val min: BigDecimal = Option[BigDecimal](property.getMinimum).getOrElse(0)
        if (minExclusive) min + 1
        else min
      }
      val max: BigDecimal = {
        val maxExclusive    = Option[Boolean](property.getExclusiveMaximum).getOrElse(false)
        val max: BigDecimal = Option[BigDecimal](property.getMaximum).getOrElse(350)
        if (maxExclusive) max - 1
        else max
      }
      Gen.choose(min, max).map(_.toLong)
    }
  }
}
