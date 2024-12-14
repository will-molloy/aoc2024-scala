package aoc2024
package day1

import org.scalatest.funsuite.AnyFunSuite

import scala.io.Source

class Day1Test extends AnyFunSuite {
  private val test = true

  test("part1") {
    val input = readInput((if test then "test_input" else "real_input") + "/day1_input.txt")
    assert(Day1.part1(input._1, input._2) === 11)
  }

  test("part2") {
    val input = readInput((if test then "test_input" else "real_input") + "/day1_input.txt")
    assert(Day1.part2(input._1, input._2) === 31)
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
