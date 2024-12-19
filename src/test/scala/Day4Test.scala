package aoc2024

import common.{DayTest, Inputs}

import scala.io.Source

class Day4Test extends DayTest(Day4) {
  override def convertInput: Source => Seq[Seq[Char]] = Inputs.grid

  override def part1Expected = Expected(18, 2593)

  override def part2Expected = Expected(9, 1950)
}
