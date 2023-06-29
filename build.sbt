val zioVersion = "2.0.15"
val scala3Version = "3.3.0"


 
lazy val root = project
  .in(file("."))
  .settings(
    name := "sudoku-solver",
    version := "1.0",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
        "dev.zio" %% "zio-test" % zioVersion % "test", // Add ZIO Test library
        "dev.zio" %% "zio-test-sbt" % zioVersion % "test", // Add ZIO Test SBT plugin
    ),

    libraryDependencies ++= Seq(
     "dev.zio" %% "zio" % zioVersion,
      // Add other libraries like zio-nio and zip-json here if needed
      "dev.zio" %% "zio-json" % "0.5.0",
      "dev.zio" %% "zio-nio" % "2.0.1",
      
      
    ).map(_ % Compile),
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "0.7.29"
    ).map(_ % Test)
  )

