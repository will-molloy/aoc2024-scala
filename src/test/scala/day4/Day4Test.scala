package aoc2024
package day4

import org.scalatest.funsuite.AnyFunSuiteLike

import scala.io.Source

class Day4Test extends AnyFunSuiteLike {
  private val test = true

  test("part1") {
    val input = readInput((if test then "test_input" else "real_input") + "/day4_input.txt")
    assert(Day4.part1(input) === 18)
  }

  test("part2") {
    val input = readInput((if test then "test_input" else "real_input") + "/day4_input.txt")
    assert(Day4.part2(input) === 9)
  }

  private def readInput(fileName: String): Seq[Seq[Char]] = {
    val input = Source.fromResource(fileName)
    input.getLines().toSeq.map(_.toCharArray)
  }
}
