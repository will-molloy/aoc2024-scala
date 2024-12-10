package aoc2024
package day1

/**
 * https://adventofcode.com/2024/day/1
 */
object Day1 {

  def part1(list1: Seq[Int], list2: Seq[Int]): Int = {
    list1.sorted.zip(list2.sorted)
      .map((e1, e2) => Math.abs(e1 - e2))
      .sum
  }

  def part2(list1: Seq[Int], list2: Seq[Int]): Int = {
    val list2Freq = list2.groupMapReduce(identity)(_ => 1)(_ + _).withDefaultValue(0)
    list1.map(v => v * list2Freq(v)).sum
  }
}

