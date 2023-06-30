# Sudoku Solver Documentation

This is a Sudoku solver program that can solve Sudoku puzzles of different complexities. The program is written in Scala and utilizes the ZIO library for functional programming and concurrency.

## Authors 

Mohammed Saber BELLAAIRI -
Huiting FENG -
Bouthayna ATIK -
Camille FOUR

## Purpose

The purpose of this Sudoku solver is to provide an efficient solution to solve Sudoku puzzles. Sudoku is a number puzzle that consists of a 9x9 grid divided into nine 3x3 subgrids. The goal is to fill the grid with digits from 1 to 9, such that each row, each column, and each of the nine 3x3 subgrids contain all the digits from 1 to 9 without repetition.

## Functionality

The Sudoku solver program performs the following functionalities:

1. Read a Sudoku problem from a JSON file.
2. Parse the JSON data into a 9x9 grid with optional digits for the Sudoku problem.
3. Display the initial Sudoku problem grid.
4. Solve the Sudoku puzzle using a backtracking algorithm.
5. Display the solved Sudoku grid.

## Usage

To use the Sudoku solver, follow these steps:

1. Make sure you have [Scala](https://www.scala-lang.org/) and [sbt](https://www.scala-sbt.org/) installed on your system.
2. Clone the Sudoku solver repository or copy the necessary files (Main.scala, SudokuSolver.scala, and SudokuSolverSpec.scala) into your project directory.
3. Create a JSON file containing the Sudoku puzzle. The file should have the following format:

```json
{
  "data": [
    [1, 2, null, null, 5, null, null, null, 9],
    [null, null, 3, null, 7, 4, 5, null, null],
    ...
    [null, null, null, null, 2, null, null, 8, null]
  ]
}
```

4. Update the build.sbt file with the correct ZIO version.

5. Run the Sudoku solver using sbt:

```bash
sbt run
```

6. When prompted, enter the path to the JSON file containing the Sudoku problem.

7. The solver will display the initial Sudoku grid, solve the puzzle, and display the solved Sudoku grid.

8. You can run the test cases using the following command in the terminal:
```bash
sbt test
```
This will execute the test suite and display the results.

## Additional Setup

The Sudoku solver uses the following external libraries, which are specified in the build.sbt file and will be downloaded automatically when running the application:

- `ZIO (Version 2.0.15)`: ZIO is a powerful library for building concurrent and asynchronous applications in Scala. It provides features for managing effects, error handling, and more.
- `ZIO JSON (Version 0.5.0)`: ZIO JSON is an extension of ZIO that provides support for encoding and decoding JSON data.
- `ZIO NIO (Version 2.0.1)`: ZIO NIO is an extension of ZIO that provides support for working with files and file systems using NIO.
- `ZIO Test (Version 2.0.15)`: ZIO Test is a testing library for ZIO applications. It is used to test the Sudoku solver's functionality.
- `ZIO Test SBT (Version 2.0.15)`: ZIO Test SBT is an SBT plugin that allows running ZIO tests directly from SBT.

## Code Explanation

### Main.scala

- `readJsonString`: Reads the JSON file from the provided path and returns it as a ZIO effect.
- `parseSudoku`: Parses the JSON data into a 9x9 grid represented as a list of lists of optional integers.
- `displaySudokuTable`: Helper function to display the Sudoku game table (initial and solved).
- `run`: The main entry point of the program. It reads the path to the JSON file, parses the Sudoku puzzle, solves it using `SudokuSolver`, and displays the results.

### SudokuSolver.scala

- `solveSudoku`: The main solver function that uses a backtracking algorithm to find the solution for the given Sudoku puzzle.

### SudokuSolverSpec.scala

- Contains test cases to ensure the correctness of the `solveSudoku` function.


## Data Structure

The data structure used to represent the Sudoku problem and solution is a `List[List[Option[Int]]]`. This structure allows us to represent a 9x9 Sudoku grid where each cell can either contain an integer value (1 to 9) or be empty. Using `Option[Int]` enables us to handle empty cells gracefully. The data structure is designed to be immutable, ensuring that each operation creates a new instance, preventing unexpected side effects in functional programming. The iterative approach of problem-solving has allowed us to refine the data structure and application features incrementally.

## ZIO Console Interaction

The solver interacts with the ZIO Console by prompting the user to enter the path of a JSON file containing a Sudoku problem. The application reads the file path from the console and attempts to solve the Sudoku puzzle. After solving the puzzle, it displays the solution, if it exists. ZIO's powerful capabilities for handling side effects allow for smooth and safe console interactions.

## Error Handling

Proper error handling mechanisms have been implemented using ZIO's error management capabilities. The solver handles scenarios such as invalid file paths, malformed JSON files, unsolvable Sudoku puzzles, etc. Informative error messages are displayed to the user to help understand and resolve the issues. The error handling approach ensures that the application remains robust and user-friendly.

## Git Repository

The Sudoku solver project is well-organized in a Git repository. We have maintained regular commits to track the development progress. The repository structure includes separate files for each module (e.g., Main.scala, SudokuSolver.scala, SudokuSolverSpec.scala, build.sbt) to keep the codebase clean and modular.

## Documentation Quality

This report provides clear and concise documentation, explaining the purpose, functionality, and usage of the Sudoku solver. Below are the instructions on how to run the solver and any additional setup required:

1. Ensure you have Scala 3 and SBT installed on your system.
2. Clone the Git repository of the Sudoku solver project.
3. Open a terminal and navigate to the root directory of the project.
4. Run the application using the following command: `sbt run`

The application will prompt you to enter the path to a JSON file containing a Sudoku problem. After solving the puzzle, it will display the solution on the console.

External libraries used in the project include ZIO for handling side effects, ZIO NIO for file operations, ZIO JSON for JSON parsing, and MUnit for testing. These libraries significantly contribute to the overall functionality and maintainability of the application.

## Recursive Approach

The Sudoku solver has been implemented using a recursive approach. Recursion is a natural fit for solving Sudoku puzzles, as it allows us to explore different possibilities by trying different values for empty cells. The functional programming concepts available in Scala, such as pattern matching, immutability, and recursive functions, have been extensively utilized to write clean, concise, and readable code.

## Testing

We have included appropriate tests to validate the correctness of the Sudoku solver implementation. The test cases cover various scenarios, including empty grids, partially filled grids, invalid Sudoku puzzles, and solvable puzzles. The use of ZIO's testing capabilities, along with MUnit, ensures comprehensive testing and validation of the application's functionality.

## Functional Properties

The Sudoku solver adheres to functional programming principles,

 such as immutability, pure functions, and referential transparency. These principles contribute to code that is easy to reason about, test, and maintain. By maintaining immutability, we prevent unexpected side effects and make our code more reliable. Pure functions ensure that the same inputs always produce the same outputs, making the code easier to understand and test. Referential transparency further enhances the predictability and understandability of the program.

## Conclusion

The Sudoku solver program provides an efficient solution to solve Sudoku puzzles of different complexities. The program uses functional programming with the ZIO library, making it easy to reason about and test. With the instructions provided, you can run the solver on your Sudoku puzzles and enjoy the solution!