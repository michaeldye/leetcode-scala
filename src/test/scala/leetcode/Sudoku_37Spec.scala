package leetcode

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class Sudoku_37Spec extends AnyFunSpec with Matchers {
  val inputS1: Array[Array[Char]] = Array(
    Array('5', '3', '.', '.', '7', '.', '.', '.', '.'),
    Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
    Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
    Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
    Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
    Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
    Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
    Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
    Array('.', '.', '.', '.', '8', '.', '.', '7', '9')
  )

  val inputS1Solved: Array[Array[Char]] = Array(
    Array('5', '3', '4', '6', '7', '8', '9', '1', '2'),
    Array('6', '7', '2', '1', '9', '5', '3', '4', '8'),
    Array('1', '9', '8', '3', '4', '2', '5', '6', '7'),
    Array('8', '5', '9', '7', '6', '1', '4', '2', '3'),
    Array('4', '2', '6', '8', '5', '3', '7', '9', '1'),
    Array('7', '1', '3', '9', '2', '4', '8', '5', '6'),
    Array('9', '6', '1', '5', '3', '7', '2', '8', '4'),
    Array('2', '8', '7', '4', '1', '9', '6', '3', '5'),
    Array('3', '4', '5', '2', '8', '6', '1', '7', '9')
  )

  val inputS1InvalidLocalA: Array[Array[Char]] = Array(
    Array('5', '3', '4', '6', '7', '8', '9', '1', '2'),
    Array('6', '7', '9', '1', '9', '5', '3', '4', '8'),
    Array('1', '9', '8', '3', '4', '2', '5', '6', '7'),
    Array('8', '5', '9', '7', '6', '1', '4', '2', '3'),
    Array('4', '2', '6', '8', '5', '3', '7', '9', '1'),
    Array('7', '1', '3', '9', '2', '4', '8', '5', '6'),
    Array('9', '6', '1', '5', '3', '7', '2', '8', '4'),
    Array('2', '8', '7', '4', '1', '9', '6', '3', '5'),
    Array('3', '4', '5', '2', '8', '6', '1', '7', '9')
  )

  describe("Sudoku_37Spec") {
    describe("Board companion object") {
      it("should init from given representation") {
        val b = Board(inputS1)

        b.end should be(81)
        // b.rowSize should be(9)
        b.game(6) should be(Space(given = true, None))
        b.game(60) should be(Space(given = true, Some(2)))
      }
    }

    describe("Puzzle object") {
      it("should solve") {
        val solved = Sudoku_37.solve(Board(inputS1), 0)
        println(Board.output(solved))
        solved should be("foo")
      }
    }

    describe("Validator object") {
      it("should generate grouped, indexed space lists") {
        val spaces = Validator.genLocalIndices()
        spaces.size should be(9)
        val flat = spaces.flatten

        flat.size should be (81)
        flat.sorted should equal(0 until 81)
      }

      it("should show locals valid if so") {
        val b = Board(inputS1Solved)

        Validator.validate(Validator.genLocalIndices, b) should be (true)
      }

      it("should show locals invalid if so") {
        val b = Board(inputS1InvalidLocalA)

        Validator.validate(Validator.genLocalIndices, b) should be (false)
      }

      it("should show rows invalid if so") {
        val b = Board(inputS1InvalidLocalA)

        Validator.validate(Validator.genRows, b) should be (false)
      }
    }
  }
}
