ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "leetcode-away",
    libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.2.12" % "test",
  )
)