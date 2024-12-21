package aoc2024

import common.{DayTest, Inputs}

import org.scalatest.funsuite.AnyFunSuite

import scala.io.Source

class Day1Test extends DayTest(Day1) {
  override def input: Source => (Seq[Int], Seq[Int]) = Inputs.numLines
    .andThen(_.foldLeft((Seq.empty[Int], Seq.empty[Int])) { case ((list1, list2), pair) =>
      (list1 :+ pair(0), list2 :+ pair(1))
    })

  override def part1 = Expected(11, 1722302)

  override def part2 = Expected(31, 20373490)
}
