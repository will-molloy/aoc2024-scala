package aoc2024

import org.scalatest.funsuite.AnyFunSuiteLike

import scala.io.Source

class Day8Test extends AnyFunSuiteLike {
  private val example = true

  test("part1") {
    val input = readInput((if example then "example_input" else "real_input") + "/day8_input.txt")
    assert(Day8.part1(input) === 14)
  }

  test("part2") {
    val input = readInput((if example then "example_input" else "real_input") + "/day8_input.txt")
    assert(Day8.part2(input) === 34)
  }

  private def readInput(fileName: String): Seq[Seq[Char]] = {
    val input = Source.fromResource(fileName)
    input.getLines().toSeq.map(_.toCharArray)
  }
}
