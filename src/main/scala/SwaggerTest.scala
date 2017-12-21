import io.swagger.models.{Operation, Path, Swagger}

import scala.collection.JavaConverters._
class SwaggerTest(val swagger: Swagger) {

  def generate() = {
    for {
      (uri: String, path: Path) <- swagger.getPaths.asScala
      (httpMethod, operation)   <- path.getOperationMap.asScala
    } yield ()
  }

}
