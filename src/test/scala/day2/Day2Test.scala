package aoc2024
package day2

import org.scalatest.funsuite.AnyFunSuiteLike
import scala.io.Source

class Day2Test extends AnyFunSuiteLike {
  private val test = true

  test("part1") {
    val input = readInput((if test then "test_input" else "real_input") + "/day2_input.txt")
    assert(Day2.part1(input) === 2)
  }

  test("part2") {
    val input = readInput((if test then "test_input" else "real_input") + "/day2_input.txt")
    assert(Day2.part2(input) === 4)
  }

  def readInput(fileName: String): Seq[Seq[Int]] = {
    val input = Source.fromResource(fileName)
    input.getLines().toSeq.map(_.split("\\s+").map(_.toInt))
  }
}
