import io.swagger.parser.SwaggerParser

object SwaggerParserTest extends App {

  val swagger = new SwaggerParser().read("pet-store.yaml")

  print(swagger.getDefinitions)

}
