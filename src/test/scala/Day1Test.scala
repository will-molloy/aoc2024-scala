package aoc2024

import common.DayTest

import org.scalatest.funsuite.AnyFunSuite

import scala.io.Source

class Day1Test extends DayTest(Day1) {
  override def convertInput: Source => (Seq[Int], Seq[Int]) = input => {
    input.getLines()
      .map(_.split("\\s+").map(_.toInt))
      .foldLeft((Seq.empty[Int], Seq.empty[Int])) { case ((l1, l2), pair) =>
        (l1 :+ pair(0), l2 :+ pair(1))
      }
  }

  override def part1Expected = Expected(11, 1722302)

  override def part2Expected = Expected(31, 20373490)
}
