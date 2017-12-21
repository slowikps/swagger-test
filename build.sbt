name := "swagger-test"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "io.swagger" % "swagger-parser" % "1.0.33",
  "org.typelevel" %% "cats-core" % "1.0.0-MF",
  "org.specs2" %% "specs2-core" % "4.0.0",
  "org.specs2" %% "specs2-scalacheck" % "4.0.0"
)
