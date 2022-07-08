package mdye.leetcode.add_numbers_2

import scala.language.implicitConversions

object Solution {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {

    (l1, l2) match {
      case (ListNode(one: BigInt), ListNode(two: BigInt)) => ListNode(one + two)
      case _ => throw new IllegalStateException("Unable to extract input")
    }
  }
}



