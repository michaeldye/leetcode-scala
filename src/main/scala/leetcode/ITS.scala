package leetcode

import scala.annotation.tailrec

object ITS {
  /**
   * 334. Increasing Triplet Subsequence
   *
   *
   */

  // clipped from LIS solution
  def record(piles: Array[Array[Int]], c: Int): (Boolean, Array[Array[Int]]) = {
    var written = false

    val mod = piles.map { p: Array[Int] =>
      val hh = p.head
      if (!written && hh >= c) { // only write if we haven't written to a pile already
        written = true
        Array(c) ++ p
      }
      else p
    }

    (written, mod)
  }

  // clipped from LIS solution, modified to return early
  def psortToLim(pile: Array[Int], lim: Int): Boolean = {

    var out = Array[Array[Int]]()

    for (c <- pile) {

      out = record(out, c) match {
        case (false, _) => out :+ Array(c)
        case (true, no) => no
      }

      // early return
      if (out.size == lim) return true
    }

    return false
  }

  def highLow(nums: Array[Int]): Boolean = {
    /**
     * This solution returns true after finding a series of increasing ints in nums of size exactly three. A general
     * solution adapts LIS and counts sorted piles; this solution is optimized for this specific subproblem and has made
     * the following considerations:
     *
     * - The min and max values are given in the problem, -231 <= nums[i] <= 231 - 1, which is the range of a 32-bit
     * two's complement integer in Java, which is the same range as Scala's Int can have.
     *
     * - Given the foregoing, we initially set min and mid to the max and min Int values. We know we're done processing
     * when we've found legitimate numbers at both those "slots" *and* an entry in the list that is greater than both
     * (cur). This is the key insight that makes this shortcut solution possible.
     *
     * - Scala isn't good at efficient looping w/ an index so we use tail recursion which is unwound to a loop by
     * the compiler.
     *
     * - Initially we used a Vector b/c Array is sort of lame and just exists for compat, *but* the difference in speed
     * matters compared with other Scala solutions so we avoid the conversion
     *
     **/

    @tailrec
    def highLowRec(nums: Array[Int], min: Int, mid: Int, ix: Int): Boolean = {


      // base case, end recursion
      if (ix == nums.length) false
      else {
        val cur = nums(ix)

        if (min < mid && mid < cur) true
        else {
          // no legal value found yet so we adjust our min and mid then recur
          val m_min = if (cur <= min) cur else min
          val m_mid = if (cur > min) cur else mid
          highLowRec(nums, m_min, m_mid, ix + 1)
        }
      }
    }

    highLowRec(nums, Int.MaxValue, Int.MinValue, 0)
  }


  def increasingTriplet(nums: Array[Int]): Boolean = {
    // the fast, but specialized way
    highLow(nums)

    // the slow, but generalized way that reuses LIS
    // psortToLim(nums, 3)
  }

}
