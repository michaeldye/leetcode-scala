package mdye.leetcode.add_numbers_2

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x

  override def toString: String = {
    /* Beware, this prints the linked list's value in reverse (as the problem likes to show it); the proper integer value can be had by unapply on the companion object
     */
    @scala.annotation.tailrec
    def b(ln: ListNode, seq: Seq[Int]): String = {
      if (ln == null) seq.mkString("[", ",", "]")
      else b(ln.next, seq :+ ln.x)
    }

    b(this, Seq.empty[Int])
  }
}

// ***** N.B.: copy all below into solution and noting from above

import scala.annotation.tailrec

object ListNode {

  // used in apply
  implicit def asSeq(value: BigInt): Seq[Int] = {

    @tailrec
    def c0(v: BigInt, s: Seq[Int]): Seq[Int] = {
      if (v == 0) {
        if (s.isEmpty) Seq[Int](0) // special case is 0 as input, not 0 as result of division given multiple calls
        else s
      } else {
        // incredible, scala
        val (q, r) = v /% 10
        c0(q, r.toInt +: s)
      }
    }

    c0(value, Seq.empty[Int])
  }

  @tailrec
  def nest(ln: ListNode, seq: Seq[Int]): ListNode = {
    // sequence has least significant digit at end
    if (seq.isEmpty) ln
    else nest(new ListNode(seq.head, ln), seq.tail)
  }

  def apply(value: Int): ListNode = nest(null, BigInt(value))

  def apply(value: BigInt): ListNode = nest(null, value)

  def apply(seq: Seq[Int]): ListNode = nest(null, seq)

  @tailrec
  def unnest(ln: ListNode, seq: Seq[Int]): Seq[Int] = {
    if (ln == null) seq
    else unnest(ln.next, ln.x +: seq)
  }

  def unapply(ln: ListNode): Option[BigInt] = Some(unnest(ln, Seq.empty[Int]).foldLeft(BigInt(0))(_ * 10 + _))
}