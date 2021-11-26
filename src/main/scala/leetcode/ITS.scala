package leetcode

import scala.collection.mutable.ArrayBuffer

object ITS {
  /**
   * 334. Increasing Triplet Subsequence
   *
   *
   */

    /*
    *
    * TODO: Fails b/c it doesn't consider valid sequences after a poisoning, high value. So in [20,100,10,12,5,13],
    * it records 20, then 100 and then can't find 10, 12, 13 later b/c 100 is the last recorded number.
    *
    * To fix this, try first mapping all in given array to a sequence that starts with the current number, so :
    * [
    *  [ 20, 100, 10, 12, 5, 13 ]
    *  [ 100, 10, 12, 5, 13 ]
    *  [ 10, 12, 5, 13 ]
    *  [ 12, 5, 13 ]
    *  [ 5, 13 ]
    *  [ 13 ]
    * ]
    *
    * .. then reduce these using the foldleft we have right now, then return true if any of the vectors in vector have size >= 3
    *
    * A possible optimization of this is to skip the last 2 lists
    *
    * !!insight!! Another possible optimization is to only generate the sequence for the current position in the sequence
    * ( that way they wouldn't need to be pre-generated)
    *
    */

  def increasingTriplet(nums: Array[Int]): Boolean = {
    val ixes = nums.zipWithIndex.foldLeft(Vector[(Int, Int)]()) { (v: Vector[(Int, Int)], n) =>
      val num = n._1
      val ix = n._2

      if (v.isEmpty) v :+ (num, ix)
      else if (v.last._1 < num) v :+ (num, ix)
      else v
    }

    ixes.size >= 3
  }
}
