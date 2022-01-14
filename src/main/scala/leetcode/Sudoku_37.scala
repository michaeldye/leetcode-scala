package leetcode

import scala.annotation.tailrec
import scala.collection.immutable.HashMap

object Sudoku_37 {

  def solveSudoku(initial: Array[Array[Char]]): Unit = {

    val solved = solve(Board(initial), 0)

    // is this how they want the solution submitted?
    println(Board.output(solved))
  }

  @tailrec
  def solve(board: Board, position: Int): Board = {
    if (position == board.end)
      if (!board.isComplete) throw new IllegalStateException(s"Board should be complete but isn't, $board")
      else board // success!
    else if (position == -1) throw new IllegalStateException("Bug in processing or input was really fucked")
    else {
      board.solveAtPosition(position) match {
        // no solution with board state as we provided it, time to move back and let solve() increment the space counter
        case None => solve(board, position - 1)
        // shit is fresh so far, move forward
        case Some(b) => solve(b, position + 1)
      }
    }
  }
}

class Board(val game: Map[Int, Space]) {
  val end = 81
  val maxValue = 9

  def solveAtPosition(position: Int): Option[Board] = {
    // TODO: make boards with speculative entries for this space until valid. If we exhaust possible space values, we bail with None; if we get a valid board, we return Some(thatGoodOne)

    val exi = game(position)

    // handle given space by skipping it if it's valid
    if (exi.given) {
      if (isValid) Some(this)
      else None
    } else tryValues(position, exi.value.getOrElse(1))
  }

  @tailrec
  private def tryValues(position: Int, value: Int): Option[Board] = {

    if (value == maxValue) None
    else {
      val b = updateGame(position, value)

      if (isValid) Some(b)
      else tryValues(position, value + 1)
    }
  }

  def spacesAtIndices(indices: Vector[Int]): Vector[Space] = indices.flatMap(game.get)

  def updateGame(position: Int, value: Int): Board = new Board(game + (position -> Space(given = false, Some(value))))

  // a little redundant checking here
  def isComplete: Boolean = (0 until end).toSet.diff(game.keySet).isEmpty && !game.values.exists(_.value.isDefined)

  private def isValid: Boolean = List[() => Seq[Vector[Int]]](Validator.genRows, Validator.genCols, Validator.genLocalIndices).forall(idxFn => Validator.validate(idxFn, this))

}

object Board {
  def apply(board: Array[Array[Char]]): Board = {

    val rowSize = board(0).length
    val end = board.length * rowSize

    val gameInit: Map[Int, Space] = board.flatMap { line =>
      line.map{c =>
        val (g, v) = if (c == '.') (false, None) else (true, Some(Integer.parseInt(c.toString)))
        Space(g, v)
      }
    }.zipWithIndex.map(_.swap).toMap

    new Board(gameInit)
  }

  def output(board: Board): String = {
    // TODO: fill with non-horseshit

    board.game.mkString("\n")
  }
}

case class Space(val given: Boolean, var value: Option[Int])

object Validator {
  val rowSize: Int = 9
  val end: Int = 81

  // encapsulated validation here instead of packing it into the Board class b/c it's filthy

  private def collUnique(spaces: Seq[Space]): Boolean = {
    // valid if ints are all unique in given spaces structure; it's ok if there are Nones
    val vals = spaces.flatMap(_.value)
    vals.size == vals.toSet.size
  }

  def genLocalIndices(): Seq[Vector[Int]] = {
    // reuse the whole range as we cut it up below
    val tr = (0 until end).sliding(3, 3).zipWithIndex.toVector

    // outer map operation yields ix with values 0, 3, 6 and that determines the offset for where we slice into the array to get a local box's row of values
    (0 until 7 by 3).flatMap{ ix =>
      // inner map operation yields jx with values 0, 1, 2 that are used to select the right "group" (by modded index number) of values from tr
      (0 until 3).map{ jx =>
        // output of this is a collection of indices for just a local
        tr.filter(_._2 % 3 == jx).slice(0+ix, 3+ix).flatMap(_._1)
      }
    }
  }

  def genRows(): Seq[Vector[Int]] = (0 until end)
  def genCols(): Seq[Vector[Int]] = ???

  def validate(idxFn: () => Seq[Vector[Int]], b: Board): Boolean = idxFn().foldLeft(true) { (tv, grouped) => collUnique(b.spacesAtIndices(grouped)) && tv }
}