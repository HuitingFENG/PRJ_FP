import zio._
import zio.Console._
import zio.json._
import java.nio.charset.StandardCharsets
import zio.nio.file.{Path, Files}


 

object Main extends ZIOAppDefault {

 

  def readJsonString(path: String): ZIO[Any, Throwable, String] =
    Files
      .readAllBytes(Path(path))
      .map(bytes => new String(bytes.toArray, StandardCharsets.UTF_8))


  def parseSudoku(jsonString: String): ZIO[Any, Throwable, List[List[Option[Int]]]] =
  jsonString.fromJson[List[List[Option[Int]]]] match {
    case Left(error)     => ZIO.fail(new RuntimeException(error))
    case Right(sudoku)   => ZIO.succeed(sudoku)
  }



  // Two functions: the first to read the JSON as a string and the second to parse the string



 

  def run: ZIO[Any, Any, Unit] =
    for {
      _ <- Console.print("Enter the path to the JSON file containing the Sudoku problem:")
      path <- Console.readLine
      _ <- Console.printLine(s"You entered: $path")
      jsonString <- readJsonString(path)
      sudoku <- parseSudoku(jsonString)
      // Use the 'sudoku' list in your Sudoku solver logic
    } yield ()
}
