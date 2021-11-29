package leetcode

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers.contain
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

import scala.util.{Failure, Success}

class TwoSumSpec extends AnyFlatSpec {

  "TwoSum" should "find indices of target" in {
    val tt = TwoSum.twoSum(Array(3,2,4), 6)

    tt should contain allOf (1, 2)
  }

  "TwoSum" should "find indices of target when not adjacent" in {
    val tt = TwoSum.twoSum(Array(0,6,3,12,7), 13)

    tt should contain allOf (1, 4)
  }

  "TwoSum" should "not find indices of target when unavail" in {

    assertThrows[ IllegalStateException ] {
      // important that this doesn't just fart on index at end of bounds or something

      TwoSum.twoSum(Array(0,6,3,12,7), 99)
    }
  }

  "TwoSum" should "find indices of target with long input" in {
    val biggun = (0 until 10000-1).toArray

    val v1 = biggun.length-1
    val v2 = biggun.length-2

    val tt = TwoSum.twoSum(biggun, v1 + v2)

    tt should contain allOf (v1, v2)

  }
}
