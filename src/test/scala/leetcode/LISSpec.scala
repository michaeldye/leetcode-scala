package leetcode

import leetcode.LIS.lengthOfLIS
import org.scalatest.flatspec.AnyFlatSpec


class LISSpec extends AnyFlatSpec {

  "LIS" should "find 4-element subs" in {
    assert(lengthOfLIS(List(10, 9, 2, 5, 3, 7, 101, 18)) === 4)
  }

  "LIS" should "find 4-element subs in branching sequence" in {
    assert(lengthOfLIS(List(0, 1, 0, 3, 2, 3)) === 4)
  }

  "LIS" should "find 1-element subs amongst duplicates" in {
    assert(lengthOfLIS(List(7, 7, 7, 7, 7, 7)) === 1)
  }

  "LIS" should "find 3-element subs" in {
    assert(lengthOfLIS(List(10, 9, 2, 5, 3, 4)) === 3)
  }

  "LIS" should "find 3-element sub with dups" in {
    assert(lengthOfLIS(List(4, 10, 4, 3, 8, 9)) === 3)

  }
}