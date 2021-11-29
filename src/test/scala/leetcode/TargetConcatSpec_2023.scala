package leetcode

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class TargetConcatSpec_2023 extends AnyFlatSpec {

  "numOfPairs" should "find targets of sevs" in {
    val in = Array("777", "7", "77", "77")

    assert(TargetConcat_2023.numOfPairs(in, "7777") == 4)
  }
}
