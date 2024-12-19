package aoc2024

import common.{DayTest, Inputs}

import scala.io.Source

class Day7Test extends DayTest(Day7) {
  override def input: Source => Seq[String] = Inputs.lines

  override def part1 = Expected(3749, 5837374519342L)

  override def part2 = Expected(11387, 492383931650959L)
}
