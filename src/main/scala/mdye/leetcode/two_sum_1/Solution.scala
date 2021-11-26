package mdye.leetcode.two_sum_1

// Problem: https://leetcode.com/problems/two-sum/

import scala.util.{Failure, Success, Try}

object Solution {

  def twoSumIndexed(nums: Array[Int], target: Int): Try[Array[Int]] = {
    val v = nums.view.indices

    // N.B. this isn't the fastest way to iterate over indicies in scala, but it is cleaner than the alternatives
    for (ix <- v)
      for (jx <- v.drop(ix + 1)) {
        val ni = nums(ix)
        val nj = nums(jx)
        if (ni + nj == target) return Success(Array(ix, jx))
      }

    Failure(new IllegalStateException(s"Failed to find indexes that sum to target, $target"))
  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    twoSumIndexed(nums, target) match {
      case Success(arr: Array[Int]) => arr
      case Failure(th: Throwable) => throw th // rethrow since caller doesn't have contract for handling errors
    }
  }
}
