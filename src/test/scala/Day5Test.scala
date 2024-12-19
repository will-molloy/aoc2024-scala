package aoc2024

import common.DayTest

import scala.io.Source

class Day5Test extends DayTest(Day5) {
  override def convertInput: Source => (Set[(Int, Int)], Seq[Seq[Int]]) = input => {
    val lines = input.getLines().toSeq

    val rules = lines.takeWhile(s => s.contains('|'))
      .map(_.split('|').map(_.toInt)).map(a => (a(0), a(1)))
      .toSet

    val updates = lines.dropWhile(s => s.contains('|')).drop(1)
      .map(_.split(',').map(_.toInt).toSeq)

    (rules, updates)
  }

  override def part1Expected = Expected(143, 6498)

  override def part2Expected = Expected(123, 5017)
}
