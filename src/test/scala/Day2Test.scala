package aoc2024

import common.DayTest

import scala.io.Source

class Day2Test extends DayTest(Day2) {
  override def convertInput: Source => Seq[Seq[Int]] = input => {
    input.getLines().toSeq.map(_.split("\\s+").map(_.toInt))
  }

  override def part1Expected = Expected(2, 606)

  override def part2Expected = Expected(4, 644)
}
