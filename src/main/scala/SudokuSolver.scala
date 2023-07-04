import scala.collection.mutable

object SudokuSolver {

  def isSolvable(sudoku: List[List[Option[Int]]]): Boolean = {
    val board = Array.ofDim[Int](9, 9)
    for {
      row <- 0 until 9
      col <- 0 until 9
    } {
      sudoku(row)(col).foreach(board(row)(col) = _)
    }
    solve(board)
  }

  
  // Function to solve the Sudoku game by replacing null values
  def solveSudoku(sudoku: List[List[Option[Int]]]): List[List[Int]] = {
    val board = Array.ofDim[Int](9, 9)
    for {
      row <- 0 until 9
      col <- 0 until 9
    } {
      sudoku(row)(col).foreach(board(row)(col) = _)
    }
    solve(board)
    board.map(_.toList).toList
  }

  private def solve(board: Array[Array[Int]]): Boolean = {
    val emptyCells = findEmptyCells(board)

    if (emptyCells.isEmpty)
      return true

    val (row, col) = emptyCells.head

    for (num <- 1 to 9) {
      if (isValid(board, row, col, num)) {
        board(row)(col) = num

        if (solve(board))
          return true

        board(row)(col) = 0
      }
    }

    false
  }

  private def findEmptyCells(board: Array[Array[Int]]): List[(Int, Int)] = {
    val emptyCells = mutable.ListBuffer[(Int, Int)]()

    for (row <- board.indices) {
      for (col <- board(row).indices) {
        if (board(row)(col) == 0)
          emptyCells += ((row, col))
      }
    }

    emptyCells.toList
  }

  private def isValid(board: Array[Array[Int]], row: Int, col: Int, num: Int): Boolean = {
    for (i <- board.indices) {
      if (board(row)(i) == num || board(i)(col) == num)
        return false
    }

    val startRow = 3 * (row / 3)
    val startCol = 3 * (col / 3)

    for (i <- startRow until startRow + 3) {
      for (j <- startCol until startCol + 3) {
        if (board(i)(j) == num)
          return false
      }
    }

    true
  }
}
