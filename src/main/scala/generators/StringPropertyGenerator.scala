package generators

import io.swagger.models.properties.StringProperty
import org.scalacheck.Gen
import org.scalacheck.Gen.alphaNumChar
import scala.collection.JavaConverters._

class StringPropertyGenerator(val property: StringProperty) {

  def generator(): Gen[String] = {
    if (property.getReadOnly) Gen.fail[String]
    else if (property.getRequired) innerGen()
    else Gen.frequency((5, innerGen()), (1, Gen.fail[String]))
  }

  private def innerGen(): Gen[String] = {
    if (property.getPattern != null) throw new IllegalArgumentException("String pattern not implemented by this tool")
    else if (property.getFormat != null) throw new IllegalArgumentException("String format not implemented by this tool")
    else if (!property.getEnum.isEmpty) Gen.oneOf(property.getEnum.asScala)
    else {
      val min: Int = Option[Int](property.getMinLength).getOrElse(0)
      val max: Int = Option[Int](property.getMaxLength).getOrElse(350)
      for {
        len <- Gen.choose(min, max)
        res <- Gen.listOfN(len, alphaNumChar)
      } yield res.toString
    }
  }
}
