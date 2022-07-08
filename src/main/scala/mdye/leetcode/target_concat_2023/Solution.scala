package mdye.leetcode.target_concat_2023

// Problem: https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/

object Solution {

  def pairsIndexed(nums: Array[String], target: String): Array[(Int, Int)] = {
    val nx: Array[(String, Int)] = nums.zipWithIndex

    nx.foldLeft(Array[(Int, Int)]()) { (acc, e) =>

      // assemble a list that disallows i == j
      val patched = nx.take(e._2) ++ nx.drop(e._2 + 1)

      acc :++ patched.foldLeft(Array[(Int, Int)]()) { (accI, eI) =>
        if (e._1 + eI._1 == target) accI :+ (e._2, eI._2) // return coords
        else accI
      }
    }
  }

  def numOfPairs(nums: Array[String], target: String): Int = pairsIndexed(nums, target).length
}
