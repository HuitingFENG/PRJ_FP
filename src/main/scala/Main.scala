import zio._
import zio.Console._
import zio.json._
import zio.nio.file.{Path, Files}

object Main extends zio.App {

  def readJsonFile(path: String): ZIO[Any, Throwable, List[List[Option[Int]]]] =
    for {
      content <- Files.readAllBytes(Path(path))
      sudoku <- ZIO.fromEither(content.fromJson[List[List[Option[Int]]]])
    } yield sudoku

  def run: ZIO[zio.ZEnv, Throwable, Unit] =
    for {
      _ <- putStrLn("Enter the path to the JSON file containing the Sudoku problem:")
      path <- getStrLn
      _ <- putStrLn(s"You entered: $path")
      sudoku <- readJsonFile(path)
      // Use the 'sudoku' list in your Sudoku solver logic
    } yield ()
}
