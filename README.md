# Sudoku Solver

This project provides a Sudoku solver implemented in Scala. It allows you to solve Sudoku puzzles by providing a JSON file containing the puzzle, and it will display the solved Sudoku grid.

## Main.scala

This file contains the main logic of the Sudoku solver. Here's an explanation of the different parts of the code:

### Dependencies

The following dependencies are imported:

- `zio`: The core ZIO library.
- `zio.Console`: The ZIO library for console interactions.
- `zio.json`: The ZIO library for JSON parsing.
- `java.nio.charset.StandardCharsets`: The Java library for character sets.
- `zio.nio.file.{Path, Files}`: The ZIO library for file operations.
- `scala.collection.mutable`: The Scala library for mutable collections.

### Reading and Parsing JSON

- `readJsonString`: This function takes a file path as input and reads the contents of the file as a string using the `zio.nio.file.Files` API.

- `parseSudoku`: This function takes a JSON string as input and parses it into a `List[List[Option[Int]]]`. It uses the `fromJson` method provided by the `zio.json` library to parse the JSON string.

### Displaying the Sudoku Table

- `displaySudokuTable`: This function takes a Sudoku grid represented as a `List[List[Option[Int]]]` and displays it on the console. It uses the `ZIO.foreach` combinator to iterate over each row of the grid and prints each element.

### Solving the Sudoku Game

- `solveSudoku`: This function takes a Sudoku grid represented as a `List[List[Option[Int]]]` and solves the puzzle by replacing the `None` values with the correct numbers. It uses a backtracking algorithm to find the solution.

- `solve`: This is a helper function used by `solveSudoku`. It recursively solves the Sudoku puzzle using a backtracking algorithm. It finds an empty cell, tries different numbers, and checks if the number is valid in the current position. If a solution is found, it returns `true`.

- `findEmptyCells`: This is a helper function used by `solve`. It finds all the empty cells (cells with a value of `None`) in the Sudoku grid and returns a list of their coordinates.

- `isValid`: This is a helper function used by `solve`. It checks if a number is valid in a given position (row, column, and box) of the Sudoku grid.

### Run Function

The `run` function is the entry point of the program. It prompts the user to enter the path to the JSON file containing the Sudoku problem, reads the file, parses the JSON, displays the Sudoku problem, solves it using the `solveSudoku` function, and finally displays the solved Sudoku grid.

## build.sbt

This file contains the build configuration for the project. It specifies the dependencies and settings for the build. Here's an explanation of the code:

- `zioVersion`: The version of the ZIO library used in the project.
- `scala3Version`: The version of Scala used in the project.

- `lazy val root`: This defines the project and its settings.
  - `name`: The name of the project.
  - `version`: The version of the project.
  - `scalaVersion`: The version of Scala used in the project.
  - `libraryDependencies`: This defines the dependencies for the project. It includes the ZIO Test library, ZIO Test SBT plugin, and other ZIO libraries like `zio-json` and `zio-nio`.

## SudokuSolver.scala

This file contains a simplified version of the Sudoku solver logic. It provides the `solve

Sudoku` function, which takes a Sudoku grid represented as a `List[List[Option[Int]]]` and solves the puzzle by replacing the `None` values with the correct numbers. It uses a backtracking algorithm to find the solution. This code is used in the `Main.scala` file.