package mdye.leetcode.target_concat_2023

import org.scalatest.flatspec.AnyFlatSpec

class SolutionSpec extends AnyFlatSpec {

  "numOfPairs" should "find targets of sevs" in {
    val in = Array("777", "7", "77", "77")

    assert(Solution.numOfPairs(in, "7777") == 4)
  }
}
