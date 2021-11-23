name := "leetcode"

version := "0.1"


lazy val commonSettings = Seq(
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % "test"
)

lazy val root = (project in file("."))
  .settings(commonSettings)

scalaVersion := "2.13.7"
