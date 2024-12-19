package aoc2024

import common.{DayTest, Inputs}

import scala.io.Source

class Day8Test extends DayTest(Day8) {
  override def input: Source => Seq[Seq[Char]] = Inputs.charGrid

  override def part1 = Expected(14, 240)

  override def part2 = Expected(34, 955)
}
