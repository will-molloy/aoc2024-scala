package aoc2024

import common.{DayTest, Inputs}

import scala.io.Source

class Day2Test extends DayTest(Day2) {
  override def input: Source => Seq[Seq[Int]] = Inputs.intGrid

  override def part1 = Expected(2, 606)

  override def part2 = Expected(4, 644)
}
