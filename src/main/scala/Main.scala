import zio._
import zio.Console._
import zio.json._
import java.nio.charset.StandardCharsets
import zio.nio.file.{Path, Files}
import scala.collection.mutable



 

object Main extends ZIOAppDefault {

 
   // Two functions: the first to read the JSON as a string and the second to parse the string


  def readJsonString(path: String): ZIO[Any, Throwable, String] =
    Files
      .readAllBytes(Path(path))
      .map(bytes => new String(bytes.toArray, StandardCharsets.UTF_8))


  def parseSudoku(jsonString: String): ZIO[Any, Throwable, List[List[Option[Int]]]] =
  jsonString.fromJson[Map[String, List[List[Option[Int]]]]] match {
    case Left(error)     => ZIO.fail(new RuntimeException(error))
    case Right(data)     => ZIO.fromOption(data.get("data")).orElse(ZIO.succeed(List.empty[List[Option[Int]]]))
  }

  /**def displayJsonData(jsonString: String): ZIO[Any, Throwable, Unit] =
    Console.printLine(jsonString).as(())**/


     // Helper function to display the Sudoku game table
  def displaySudokuTable(sudoku: List[List[Option[Int]]]): ZIO[Any, Throwable, Unit] =
    ZIO.foreach(sudoku) { row =>
      val rowString = row.map {
        case Some(0) => "_"
        case Some(value) => value.toString
        case None => "_"
      }.mkString(" ")
      Console.printLine(rowString)
    }.as(())

 

  def run: ZIO[Any, Any, Unit] =
    for {
      _ <- Console.print("Enter the path to the JSON file containing the Sudoku problem:")
      path <- Console.readLine
      _ <- Console.printLine(s"You entered the next path: $path")
      _ <- Console.printLine("Sudoku problem:")
      jsonString <- readJsonString(path)
      //_ <- displayJsonData(jsonString)
      sudoku <- parseSudoku(jsonString)
      _ <- displaySudokuTable(sudoku)
      // Use the 'sudoku' list in your Sudoku solver logic
      solvedSudoku = SudokuSolver.solveSudoku(sudoku)
      _ <- Console.printLine("Solved Sudoku:")
      _ <- displaySudokuTable(solvedSudoku.map(_.map(Some(_))))
    } yield ()
}
