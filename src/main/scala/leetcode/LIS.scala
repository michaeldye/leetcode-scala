package leetcode

object LIS {

  def record(piles: Vector[Vector[Int]], c: Int): (Boolean, Vector[Vector[Int]]) = {
    var written = false

    val mod = piles.map { p: Vector[Int] =>
      val hh = p.head
      if (!written && hh >= c) { // only write if we haven't written to a pile already
        written = true
        Vector(c) ++ p
      }
      else p
    }

    (written, mod)
  }

  def psortPhase1(pile: Vector[Int]): Vector[Vector[Int]] = {

    var out = Vector[Vector[Int]]()

    pile.foreach { c: Int =>

      out = record(out, c) match {
        case (false, _) => out :+ Vector(c)
        case (true, no) => no
      }
    }

    out
  }

  def lengthOfLIS(nums: List[Int]): Int = {
    psortPhase1(nums.toVector).size
  }
}
