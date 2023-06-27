
// The simplest possible sbt build file is just one line:

/* scalaVersion := "2.13.8"

name := "hello-world"
organization := "ch.epfl.scala"
version := "1.0"

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.1.1"
 */

val zioVersion = "2.0.15"
val scala3Version = "3.3.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "sudoku-solver",
    version := "1.0",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % zioVersion,
      // Add other libraries like zio-nio and zip-json here if needed
    ).map(_ % Compile),
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "0.7.29"
    ).map(_ % Test)
  )