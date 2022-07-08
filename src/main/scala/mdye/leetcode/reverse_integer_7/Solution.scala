package mdye.leetcode.reverse_integer_7

import scala.annotation.tailrec
import scala.math.Integral.Implicits.infixIntegralOps

object Solution {
  def intToDigitsRev(x: Int): Seq[Int] = {

    @tailrec
    def intToDigits0(x: Int, seq: Seq[Int]): Seq[Int] = {
      if (x == 0) seq
      else {
        val (q, r) = x /% 10
        intToDigits0(q, seq :+ r)
      }
    }

    intToDigits0(x, Seq.empty[Int])
  }

  def digitsToInt(seq: Seq[Int]): Int = {

    @tailrec
    def digitsToInt0(seq: Seq[Int], x: Int): Int = {
      if (seq.isEmpty) x
      else if (x > Int.MaxValue / 10) 0 // that boy is too big
      else {
        val x10 = x * 10
        if (x10 < 0) 0 // that boy is too small
        else {
          val value = x10 + seq.head
          digitsToInt0(seq.tail, value)
        }
      }
    }

    digitsToInt0(seq, 0)
  }

  def reverse(x: Int): Int = {
    val isNeg = x < 0
    val rev = digitsToInt(intToDigitsRev(x.abs))

    if (isNeg) rev * -1
    else rev
  }
}
