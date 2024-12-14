package aoc2024

import org.scalatest.funsuite.AnyFunSuiteLike

import scala.io.Source

class Day5Test extends AnyFunSuiteLike {
  private val example = true

  test("part1") {
    val input = readInput((if example then "example_input" else "real_input") + "/day5_input.txt")
    assert(Day5.part1.tupled(input) === 143)
  }

  test("part2") {
    val input = readInput((if example then "example_input" else "real_input") + "/day5_input.txt")
    assert(Day5.part2.tupled(input) === 123)
  }

  private def readInput(fileName: String): (Set[(Int, Int)], Seq[Seq[Int]]) = {
    val input = Source.fromResource(fileName)
    val lines = input.getLines().toSeq

    val rules = lines.takeWhile(s => s.contains('|'))
      .map(_.split('|').map(_.toInt)).map(a => (a(0), a(1)))
      .toSet

    val updates = lines.dropWhile(s => s.contains('|')).drop(1)
      .map(_.split(',').map(_.toInt).toSeq)

    (rules, updates)
  }
}
