package leetcode

object MedianOfArrays_4 {


  def mergeSorted(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val n2Lazy = nums2.view

    val (n2pos, merged) = nums1.foldLeft((0, Array[Int]())) { (posAcc, n1) =>
      // is there a better way to pack the nums2 position into each call foldLeft makes?
      val pos = posAcc._1
      val acc = posAcc._2

      val n2Sub = n2Lazy.drop(pos).takeWhile(_ <= n1).toArray

      (pos + n2Sub.length, acc ++ n2Sub :+ n1)
    }

    // append any that exist in nums2
    merged ++ nums2.array.drop(n2pos)
  }

  def calcMedianRange(length: Int): (Int, Int) = {

    val ix = length / 2
    val offset = if (length % 2 == 0) 1 else 0
    (ix - offset, ix + 1)
  }

  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {

    val merged = mergeSorted(nums1, nums2)

    // use tupled to pass return value from calcMeanRange as args 1, 2 to merged.slice ...
    val medianCalcSub = Function.tupled(merged.slice _)(calcMedianRange(merged.length))

    medianCalcSub.sum.asInstanceOf[Double] / medianCalcSub.length
  }
}
