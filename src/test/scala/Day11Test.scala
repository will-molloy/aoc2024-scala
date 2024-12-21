package aoc2024

import common.{DayTest, Inputs}

import org.scalatest.funsuite.AnyFunSuite

import scala.io.Source

class Day11Test extends DayTest(Day11) {
  override def input: Source => Seq[Long] = Inputs.lines.andThen(_.head).andThen(_.split("\\s+").map(_.toLong))

  override def part1 = Expected(55312, 239714)

  override def part2 = Expected(31, 20373490)
}
