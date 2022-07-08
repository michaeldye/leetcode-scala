package mdye.leetcode.its_334

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class SolutionSpec extends AnyFlatSpec {

  "ITS" should "find triplet among seq 1 to 5" in {
    assert(Solution.increasingTriplet(Array(1,2,3,4,5)))
  }

  "ITS" should "not find triplet among seq 5 to 1" in {
    assert(!Solution.increasingTriplet(Array(5,4,3,2,1)))
  }

  "ITS" should "find triplet among increasing (ex 3)" in {
    assert(Solution.increasingTriplet(Array(2,1,5,0,4,6)))
  }

  "ITS" should "not find triplet among [6,7,1,2]" in {
    assert(!Solution.increasingTriplet(Array(6,7,1,2)))
  }

  "ITS" should "find triple among [20,100,10,12,5,13]" in {
    assert(Solution.increasingTriplet(Array(20,100,10,12,5,13)))
  }

  "ITS" should "find triple among [1,5,0,4,1,3]" in {
    assert(Solution.increasingTriplet(Array(1,5,0,4,1,3)))
  }

}
