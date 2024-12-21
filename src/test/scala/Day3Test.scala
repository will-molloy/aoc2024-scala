package aoc2024

import common.{DayTest, Inputs}

import scala.io.Source

class Day3Test extends DayTest(Day3) {
  override def input: Source => String = Inputs.string

  override def part1 = Expected(161, 196826776)

  override def part2 = Expected(48, 106780429)
}
