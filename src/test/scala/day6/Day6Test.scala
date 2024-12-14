package aoc2024
package day6

import org.scalatest.funsuite.AnyFunSuiteLike

import scala.io.Source

class Day6Test extends AnyFunSuiteLike {
  private val test = true

  test("part1") {
    val input = readInput((if test then "test_input" else "real_input") + "/day6_input.txt")
    assert(Day6.part1(input) === 41)
  }

  test("part2") {
    val input = readInput((if test then "test_input" else "real_input") + "/day6_input.txt")
    assert(Day6.part2(input) === 6)
  }

  private def readInput(fileName: String): Seq[Seq[Char]] = {
    val input = Source.fromResource(fileName)
    input.getLines().toSeq.map(_.toCharArray)
  }
}
