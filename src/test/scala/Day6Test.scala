package aoc2024

import common.{DayTest, Inputs}

import scala.io.Source

class Day6Test extends DayTest(Day6) {
  override def convertInput: Source => Seq[Seq[Char]] = Inputs.grid

  override def part1Expected = Expected(41, 5409)

  override def part2Expected = Expected(6, 2022)
}
