import zio.test._
import zio.test.Assertion._
import zio.{IO, ZIO}

object SudokuSolverSpec extends DefaultRunnableSpec {

  import SudokuSolver._

  val solvedGrid: List[List[Option[Int]]] = List(
    List(Some(5), Some(3), Some(4), Some(6), Some(7), Some(8), Some(9), Some(1), Some(2)),
    List(Some(6), Some(7), Some(2), Some(1), Some(9), Some(5), Some(3), Some(4), Some(8)),
    List(Some(1), Some(9), Some(8), Some(3), Some(4), Some(2), Some(5), Some(6), Some(7)),
    List(Some(8), Some(5), Some(9), Some(7), Some(6), Some(1), Some(4), Some(2), Some(3)),
    List(Some(4), Some(2), Some(6), Some(8), Some(5), Some(3), Some(7), Some(9), Some(1)),
    List(Some(7), Some(1), Some(3), Some(9), Some(2), Some(4), Some(8), Some(5), Some(6)),
    List(Some(9), Some(6), Some(1), Some(5), Some(3), Some(7), Some(2), Some(8), Some(4)),
    List(Some(2), Some(8), Some(7), Some(4), Some(1), Some(9), Some(6), Some(3), Some(5)),
    List(Some(3), Some(4), Some(5), Some(2), Some(8), Some(6), Some(1), Some(7), Some(9))
  )

  def solveEmptySudokuGrid: ZSpec[Any, Nothing] =
    test("Solves an empty Sudoku grid") {
      val grid = List.fill(9)(List.fill(9)(None))
      assert(solveSudoku(grid))(equalTo(Some(solvedGrid)))
    }

  def solvePartiallyFilledSudokuGrid: ZSpec[Any, Nothing] =
    test("Solves a partially filled Sudoku grid") {
      val grid = List(
        List(Some(5), Some(3), None, None, Some(7), None, None, None, None),
        List(Some(6), None, None, Some(1), Some(9), Some(5), None, None, None),
        List(None, Some(9), Some(8), None, None, None, None, Some(6), None),
        List(Some(8), None, None, None, Some(6), None, None, None, Some(3)),
        List(Some(4), None, None, Some(8), None, Some(3), None, None, Some(1)),
        List(Some(7), None, None, None, Some(2), None, None, None, Some(6)),
        List(None, Some(6), None, None, None, None, Some(2), Some(8), None),
        List(None, None, None, Some(4), Some(1), Some(9), None, None, Some(5)),
        List(None, None, None, None, Some(8), None, None, Some(7), Some(9))
      )
      assert(solveSudoku(grid))(equalTo(Some(solvedGrid)))
    }

  def handleInvalidSudokuGrid: ZSpec[Any, Nothing] =
    test("Handles an invalid Sudoku grid") {
      val invalidGrid = List.fill(9)(List.fill(9)(Some(1))) // All cells filled with 1
      assert(solveSudoku(invalidGrid))(equalTo(None))
    }

  def handleUnsolvableSudokuPuzzle: ZSpec[Any, Nothing] =
    test("Handles an unsolvable Sudoku puzzle") {
      val unsolvableGrid = List(
        List(Some(5), Some(3), None, None, Some(7), None, None, None, None),
        List(Some(6), None, None, Some(1), Some(9), Some(5), None, None, None),
        List(None, Some(9), Some(8), None, None, None, None, Some(6), None),
        List(Some(8), None, None, None, Some(6), None, None, None, Some(3)),
        List(Some(4), None, None, Some(8), None, Some(3), None, None, Some(1)),
        List(Some(7), None, None, None, Some(2), None, None, None, Some(6)),
        List(None, Some(6), None, None, None, None, Some(2), Some(8), None),
        List(None, None, None, Some(4), Some(1), Some(9), None, None, Some(5)),
        List(None, None, None, None, Some(8), None, None, Some(7), None) // Missing one number in the last row
      )
      assert(solveSudoku(unsolvableGrid))(equalTo(None))
    }

  def solveSolvableSudokuPuzzle: ZSpec[Any, Nothing] =
    test("Solves a solvable Sudoku puzzle") {
      val solvableGrid = List(
        List(None, None, None, None, None, None, None, None, Some(7)),
        List(None, None, None, None, None, None, Some(8), Some(4), Some(3)),
        List(Some(2), None, Some(7), None, Some(5), None, None, None, None),
        List(None, None, None, None, None, None, Some(5), Some(1), None),
        List(None, None, Some(9), None, None, None, Some(3), None, None),
        List(Some(3), Some(6), Some(1), None, None, None, None, None, None),
        List(None, None, None, None, Some(6), None, Some(2), None, Some(8)),
        List(Some(8), Some(1), Some(6), None, None, None, None, None, None),
        List(Some(5), Some(4), None, None, None, None, None, None, None)
      )
      assert(solveSudoku(solvableGrid))(equalTo(Some(solvedGrid)))
    }

  def spec: ZSpec[Environment, Failure] =
    suite("Sudoku Solver")(
      solveEmptySudokuGrid,
      solvePartiallyFilledSudokuGrid,
      handleInvalidSudokuGrid,
      handleUnsolvableSudokuPuzzle,
      solveSolvableSudokuPuzzle
    )
}


