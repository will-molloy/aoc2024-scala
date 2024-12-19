package aoc2024

import common.Day

/**
 * https://adventofcode.com/2024/day/1
 */
object Day1 extends Day[(Seq[Int], Seq[Int]), Int](2024, 1) {

  override def part1(input: (Seq[Int], Seq[Int])): Int = input match
    case (list1, list2) => {
      list1.sorted.zip(list2.sorted)
        .map((e1, e2) => Math.abs(e1 - e2))
        .sum
    }

  override def part2(input: (Seq[Int], Seq[Int])): Int = input match
    case (list1, list2) => {
      val list2Freq = list2.groupMapReduce(identity)(_ => 1)(_ + _).withDefaultValue(0)
      list1.map(v => v * list2Freq(v)).sum
    }
}
