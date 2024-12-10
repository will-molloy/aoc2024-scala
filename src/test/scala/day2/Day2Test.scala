package aoc2024
package day2

import org.scalatest.funsuite.AnyFunSuiteLike
import scala.io.Source

class Day2Test extends AnyFunSuiteLike {

  test("part1") {
    val input = readInput()
    assert(Day2.part1(input) === 2)
  }

  test("part2") {
    val input = readInput()
    assert(Day2.part2(input) === 4)
  }

  def readInput(): Seq[Seq[Int]] = {
    val input = Source.fromResource("test_input/day2_input.txt")
    input.getLines().toSeq.map(_.split("\\s+").map(_.toInt))
  }
}
