package aoc2024

import org.scalatest.funsuite.AnyFunSuite

import scala.io.Source

class Day1Test extends AnyFunSuite {
  private val example = true

  test("part1") {
    val input = readInput((if example then "example_input" else "real_input") + "/day1_input.txt")
    assert(Day1.part1.tupled(input) === 11)
  }

  test("part2") {
    val input = readInput((if example then "example_input" else "real_input") + "/day1_input.txt")
    assert(Day1.part2.tupled(input) === 31)
  }

  private def readInput(fileName: String): (Seq[Int], Seq[Int]) = {
    val input = Source.fromResource(fileName)
    input.getLines()
      .map(_.split("\\s+").map(_.toInt))
      .foldLeft((Seq.empty[Int], Seq.empty[Int])) { case ((l1, l2), pair) =>
        (l1 :+ pair(0), l2 :+ pair(1))
      }
  }
}
