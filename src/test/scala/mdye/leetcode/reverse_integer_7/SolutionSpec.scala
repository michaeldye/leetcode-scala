package mdye.leetcode.reverse_integer_7

import org.scalatest.flatspec.AnyFlatSpec

class SolutionSpec extends AnyFlatSpec {

  "intToDigitsRev" should "return reversed int" in {
    assert(Seq[Int](1,2,3) == Solution.intToDigitsRev(321))
  }

  "digitsToInt" should "return 0 if trivial overflow" in {
    val over = Solution.intToDigitsRev(Int.MaxValue)
    assert(0 == Solution.digitsToInt(over))
  }

  "digitsToInt" should "return 0 even if not trivial overflow" in {
    val over = Solution.intToDigitsRev(1534236469)
    assert(0 == Solution.digitsToInt(over))
  }

  "digitsToInt" should "convert to digits in correct order" in {
    assert(123 == Solution.digitsToInt(Seq[Int](1, 2, 3)))
  }

  "reverse" should "handle 123" in {
    assert(321 == Solution.reverse(123))
  }

  "reverse" should "handle -123" in {
    assert(-321 == Solution.reverse(-123))
  }

  "reverse" should "handle 120" in {
    assert(21 == Solution.reverse(120))
  }

  "reverse" should "return 0 if underflow" in {
    val under = Int.MinValue
    assert(0 == Solution.reverse(under))
  }

}
