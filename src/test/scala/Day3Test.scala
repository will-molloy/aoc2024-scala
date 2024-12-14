package aoc2024

import org.scalatest.funsuite.AnyFunSuiteLike

import scala.io.Source

class Day3Test extends AnyFunSuiteLike {
  private val example = true

  test("part1") {
    val input = readInput((if example then "example_input" else "real_input") + "/day3_input.txt")
    assert(Day3.part1(input) === 161)
  }

  test("part2") {
    val input = readInput(if example then "example_input/day3_part2_input.txt" else "real_input/day3_input.txt")
    assert(Day3.part2(input) === 48)
  }

  private def readInput(fileName: String): String = {
    val input = Source.fromResource(fileName)
    // join string WITHOUT newlines...!
    input.getLines().mkString("")
  }
}
