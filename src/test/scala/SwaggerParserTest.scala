import io.swagger.models.Swagger
import io.swagger.parser.SwaggerParser

object SwaggerParserTest extends App {

  val swagger: Swagger = new SwaggerParser().read("pet-store.yaml")

  print(swagger.getDefinitions)

}
