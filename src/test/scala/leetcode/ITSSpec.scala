package leetcode

import org.scalatest.flatspec.AnyFlatSpec


class ITSSpec extends AnyFlatSpec {

  "ITS" should "find triplet among seq 1 to 5" in {
    assert(ITS.increasingTriplet(Array(1,2,3,4,5)))
  }

  "ITS" should "not find triplet among seq 5 to 1" in {
    assert(!ITS.increasingTriplet(Array(5,4,3,2,1)))
  }

  "ITS" should "find triplet among increasing (ex 3)" in {
    assert(ITS.increasingTriplet(Array(2,1,5,0,4,6)))
  }

  "ITS" should "not find triplet among [6,7,1,2]" in {
    assert(!ITS.increasingTriplet(Array(6,7,1,2)))

  }

  "ITS" should "find triple among [20,100,10,12,5,13]" in {
    assert(ITS.increasingTriplet(Array(20,100,10,12,5,13)))
  }
}
