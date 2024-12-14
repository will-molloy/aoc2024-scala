package aoc2024
package day6

import org.scalatest.funsuite.AnyFunSuiteLike

import scala.collection.mutable
import scala.io.Source

class Day6Test extends AnyFunSuiteLike {
  private val test = true

  test("part1") {
    val input = readInput((if test then "test_input" else "real_input") + "/day6_input.txt")
    assert(Day6.part1(input) === 41)
  }

  private def readInput(fileName: String): mutable.Seq[mutable.Seq[Char]] = {
    val input = Source.fromResource(fileName)
    val grid = input.getLines().toSeq.map(_.toCharArray)
    mutable.Seq.from(grid.map(mutable.Seq.from(_)))
  }
}
