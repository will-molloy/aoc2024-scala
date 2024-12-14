package aoc2024

import org.scalatest.funsuite.AnyFunSuiteLike

import scala.io.Source

class Day7Test extends AnyFunSuiteLike {
  private val example = false

  test("part1") {
    val input = readInput((if example then "example_input" else "real_input") + "/day7_input.txt")
    assert(Day7.part1(input) === 3749)
  }

  private def readInput(fileName: String): Seq[String] = {
    val input = Source.fromResource(fileName)
    input.getLines().toSeq
  }
}
