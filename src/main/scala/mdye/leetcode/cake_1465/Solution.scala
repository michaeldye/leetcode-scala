package mdye.leetcode.cake_1465

object Solution {

  def maxArea(h: Int, w: Int, horizontalCuts: Array[Int], verticalCuts: Array[Int]): Int = {
    val c = calc(horizontalCuts ++ List(0, h), verticalCuts ++ List(0, w))

    (c % (BigInt(10).pow(9) + 7)).toInt
  }

  def calc(horizontalCuts: Array[Int], verticalCuts: Array[Int]): BigInt = {
    // N.B. This method is wasteful b/c we have to sort the data and we don't limit the search
    // for the tallest region after knowing the widest one

    val widest = largestDiff(verticalCuts.sorted)
    val tallest = largestDiff(horizontalCuts.sorted)

    // biggest area section is widest * tallest
    BigInt(widest) * BigInt(tallest)
  }


  def largestDiff(sortedSlices: Array[Int]): Int = {
    sortedSlices.zipWithIndex.flatMap { case (v, ix) =>
      if (ix > 0) Some(v - sortedSlices(ix - 1))
      else None

    }.max
  }
}
