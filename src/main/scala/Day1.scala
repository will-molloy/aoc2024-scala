package aoc2024

import common.{Day, Input}

/**
 * https://adventofcode.com/2024/day/1
 */
object Day1 extends Day(2024, 1) {

  override def part1(input: Input): Int = {
    val lines = input.numLines()
    val list1 = lines.map(_.head)
    val list2 = lines.map(_.last)

    list1.sorted.zip(list2.sorted)
      .map((e1, e2) => Math.abs(e1 - e2))
      .sum
  }

  override def part2(input: Input): Int = {
    val lines = input.numLines()
    val list1 = lines.map(_.head)
    val list2 = lines.map(_.last)

    val list2Freq = list2.groupMapReduce(identity)(_ => 1)(_ + _).withDefaultValue(0)
    list1.map(v => v * list2Freq(v)).sum
  }
}
