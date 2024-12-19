package aoc2024

import common.{DayTest, MutableGrid, Inputs}

import scala.io.Source

class Day4Test extends DayTest(Day4) {
  override def input: Source => MutableGrid[Char] = Inputs.charGrid

  override def part1 = Expected(18, 2593)

  override def part2 = Expected(9, 1950)
}
