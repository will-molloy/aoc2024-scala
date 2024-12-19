package aoc2024

import common.{DayTest, Inputs}

import scala.io.Source

class Day6Test extends DayTest(Day6) {
  override def input: Source => Seq[Seq[Char]] = Inputs.charGrid

  override def part1 = Expected(41, 5409)

  override def part2 = Expected(6, 2022)
}
