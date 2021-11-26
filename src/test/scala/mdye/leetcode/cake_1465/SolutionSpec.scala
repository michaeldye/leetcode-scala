package mdye.leetcode.cake_1465

import org.scalatest.flatspec.AnyFlatSpec

class SolutionSpec extends AnyFlatSpec {

  "calc" should "determine max area of trivially bounded rect" in {
    val v = Solution.maxArea(5, 4, Array[Int](1,2,4), Array[Int](1,3))
    assert(v == 4)
  }

  "calc" should "determine max area of not trivially bound rect" in {
    val v = Solution.maxArea(5, 4, Array[Int](3,1), Array[Int](1))
    assert(v == 6)
  }

  "calc" should "determine max area" in {
    val v = Solution.maxArea(5, 4, Array[Int](3), Array[Int](3))
    assert(v == 9)
  }

  "calc" should "determine max area of tall, wide boy" in {
    val v = Solution.maxArea(1000000000, 1000000000, Array[Int](2), Array[Int](2))
    assert(v == 81)
  }

}
