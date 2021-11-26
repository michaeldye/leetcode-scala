package mdye.leetcode.add_numbers_2

import org.scalatest.Failed
import org.scalatest.flatspec.AnyFlatSpec

class SolutionSpec extends AnyFlatSpec {

  "ListNode object" should "create ListNode from int" in {
    // remember that the problem wants 2 as the head of the list but when we do
    // operations on the numbers we want head to be the least significant digit
    val ln = ListNode(342)

    assert(ln.x == 2)
    assert(ln.next.x == 4)
    assert(ln.next.next.x == 3)

  }

  "ListNode.asSeq" should "convert decimal to seq in intuitive order" in {
    assert(ListNode.asSeq(634) == Seq(6, 3, 4))
  }

  "addTwoNumbers" should "yield ListNode object" in {
    Solution.addTwoNumbers(ListNode(342), ListNode(465)) match {
      // returned value is 807, which is represented in our linked list as 7 -> 0 -> 8
      case ln: ListNode =>
        assert(ln.x == 7)
        assert(ln.next.x == 0)
        assert(ln.next.next.x == 8)

        // and then check that the destructuring gives the right value
        ln match {
          case ListNode(v) =>
            assert(v == 807)
        }
      case _ => Failed
    }
  }

  "addTwoNumbers" should "handle 0 input as specified" in {
    Solution.addTwoNumbers(ListNode(0), ListNode(0)) match {
      case ListNode(v) => assert(v == 0)
      case _ => Failed
    }
  }

  "addTwoNumbers" should "handle l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]" in {
    Solution.addTwoNumbers(ListNode(9_999_999), ListNode(9_999)) match {
      case ln: ListNode =>
        assert(ln.toString == "[8,9,9,9,0,0,0,1]")

        // and then check the actual value
        ln match {
          case ListNode(v) => assert(v == 10_009_998)
        }
      case _ => Failed
    }
  }

  "addTwoNumbers" should "handle [9], [1,9,9,9,9,9,9,9,9,9] as sequences" in {
    Solution.addTwoNumbers(ListNode(Seq(9)), ListNode(Seq(9,9,9,9,9,9,9,9,9,1))) match {
      case ln: ListNode =>
        assert(ln.toString == "[0,0,0,0,0,0,0,0,0,0,1]")
        ln match {
          case ListNode(v) => assert(v == BigInt(10_000_000_000L))
        }
      case _ => Failed
    }
  }

  "addTwoNumbers" should "handle [9], [1,9,9,9,9,9,9,9,9,9] as bigints " in {
    Solution.addTwoNumbers(ListNode(9), ListNode(BigInt(9_999_999_991L))) match {
      case ln: ListNode =>
        assert(ln.toString == "[0,0,0,0,0,0,0,0,0,0,1]")
        ln match {
          case ListNode(v) => assert(v == BigInt(10_000_000_000L))
        }
      case _ => Failed
    }
  }
}
