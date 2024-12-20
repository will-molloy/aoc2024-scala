package aoc2024

import common.{DayTest, Inputs}

import scala.io.Source

class Day9Test extends DayTest(Day9) {
  override def input: Source => String = Inputs.string

  override def part1: Expected = Expected(1928, 6288707484810L)

  override def part2: Expected = Expected(2858, 6311837662089L)
}
