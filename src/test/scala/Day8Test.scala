package aoc2024

import common.{DayTest, Inputs}

import scala.io.Source

class Day8Test extends DayTest(Day8) {
  override def convertInput: Source => Seq[Seq[Char]] = Inputs.grid

  override def part1Expected = Expected(14, 240)

  override def part2Expected = Expected(34, 955)
}
