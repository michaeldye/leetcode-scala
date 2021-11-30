package leetcode

import org.scalatest.flatspec.AnyFlatSpec

class MedianOfArraysSpec_4 extends AnyFlatSpec {

  "MediaOfArrays.calcMeanRange" should "yield range slicing 1 from odd array" in {
    val interval = MedianOfArrays_4.calcMedianRange(3)

    assert(interval._1 == 1)
    assert(interval._2 == 2)
  }

  "MediaOfArrays.calcMeanRange" should "yield range slicing 2 from even array" in {
    val interval = MedianOfArrays_4.calcMedianRange(6)

    assert(interval._1 == 2)
    assert(interval._2 == 4)
  }

  "MediaOfArrays.mergeSorted" should "yield merge of sorted with same length" in {
    val s1 = Array(1, 3, 5, 7)
    val s2 = Array(2, 4, 6, 8)

    val merged = MedianOfArrays_4.mergeSorted(s1, s2)
    assert(merged.length == s1.length + s2.length)
    assert(merged(6) == 7)
  }

  "MediaOfArrays.mergeSorted" should "yield merge of sorted with longer s1" in {
    val s1 = Array(1, 3, 5)
    val s2 = Array(2, 4, 6, 8)

    val merged = MedianOfArrays_4.mergeSorted(s1, s2)
    assert(merged.length == s1.length + s2.length)
    assert(merged(6) == 8)
  }

  "MediaOfArrays.mergeSorted" should "yield merge of sorted with longer s2" in {
    val s1 = Array(1, 3, 5, 7)
    val s2 = Array(2, 4, 6)

    val merged = MedianOfArrays_4.mergeSorted(s1, s2)
    assert(merged.length == s1.length + s2.length)
    assert(merged(6) == 7)
  }

  "MediaOfArrays.mergeSorted" should "yield merge of sorted with duplicates" in {
    val s1 = Array(1, 3, 3, 5, 7)
    val s2 = Array(2, 3, 4, 6, 8)

    val merged = MedianOfArrays_4.mergeSorted(s1, s2)
    assert(merged.length == s1.length + s2.length)
    assert(merged(5) == 4)
  }

  "MediaOfArrays.findMediaSortedArrays" should "yield median of [1,3], [2]" in {
    val s1 = Array(1, 3)
    val s2 = Array(2)

    assert(MedianOfArrays_4.findMedianSortedArrays(s1, s2) == 2)
  }

  "MediaOfArrays.findMediaSortedArrays" should "yield median of [1,2], [3,4]" in {
    val s1 = Array(1, 2)
    val s2 = Array(3, 4)

    assert(MedianOfArrays_4.findMedianSortedArrays(s1, s2) == 2.5d)
  }
}
