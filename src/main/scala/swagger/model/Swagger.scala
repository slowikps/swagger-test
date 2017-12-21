package swagger.model

import io.swagger.models._
import io.swagger.models.auth.SecuritySchemeDefinition
import io.swagger.models.parameters.Parameter
import io.swagger.models.{Swagger => JSwagger}

object Swagger {
  import scala.collection.JavaConverters._
  def apply(jSwagger: JSwagger): Swagger = {
    Swagger(
      swagger = jSwagger.getSwagger,
      info = jSwagger.getInfo,
      host = jSwagger.getHost,
      basePath = jSwagger.getBasePath,
      tags = jSwagger.getTags.asScala.toList,
      schemes = jSwagger.getSchemes.asScala.toList,
      consumes = jSwagger.getConsumes.asScala.toList,
      produces = jSwagger.getProduces.asScala.toList,
      security = jSwagger.getSecurity.asScala.toList,
      paths = jSwagger.getPaths.asScala.toMap,
      securityDefinitions = jSwagger.getSecurityDefinitions.asScala.toMap,
      definitions = jSwagger.getDefinitions.asScala.toMap,
      parameters = jSwagger.getParameters.asScala.toMap,
      responses = jSwagger.getResponses.asScala.toMap,
      externalDocs = jSwagger.getExternalDocs,
      vendorExtensions = jSwagger.getVendorExtensions.asScala.toMap
    )
  }
}

case class Swagger(swagger: String,
                   info: Info,
                   host: String,
                   basePath: String,
                   tags: List[Tag],
                   schemes: List[Scheme],
                   consumes: List[String],
                   produces: List[String],
                   security: List[SecurityRequirement],
                   paths: Map[String, Path],
                   securityDefinitions: Map[String, SecuritySchemeDefinition],
                   definitions: Map[String, Model],
                   parameters: Map[String, Parameter],
                   responses: Map[String, Response],
                   externalDocs: ExternalDocs,
                   vendorExtensions: Map[String, Any])
