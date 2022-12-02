name := "Advent of Code"

scalaVersion := "3.1.0"

scalacOptions ++= Seq(
  "-deprecation",
  "-explain",
  "-explaintypes",
  "-feature",
  "-unchecked")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.14" % Test
)
