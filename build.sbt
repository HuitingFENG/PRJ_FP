val zioVersion = "2.0.15"
val scala3Version = "3.3.0"

<<<<<<< HEAD

=======
 
>>>>>>> 53ed905f934f7299ca63e55ed24a6707f3a6c46d
lazy val root = project
  .in(file("."))
  .settings(
    name := "sudoku-solver",
    version := "1.0",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % zioVersion,
      // Add other libraries like zio-nio and zip-json here if needed
      "dev.zio" %% "zio-json" % "0.5.0",
      "dev.zio" %% "zio-nio" % "2.0.1",
<<<<<<< HEAD
      
=======

>>>>>>> 53ed905f934f7299ca63e55ed24a6707f3a6c46d
    ).map(_ % Compile),
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "0.7.29"
    ).map(_ % Test)
  )