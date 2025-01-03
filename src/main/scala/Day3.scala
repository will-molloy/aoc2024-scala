package aoc2024

import common.*

/**
 * https://adventofcode.com/2024/day/3
 */
object Day3 extends Day(2024, 3) {

  override def part1(input: Input): Int = {
    val p = """mul\((\d+),(\d+)\)""".r
    val matches = p.findAllMatchIn(input.string())

    matches.map(m => {
      m.group(1).toInt * m.group(2).toInt
    }).sum
  }

  private def part1(line: String): Int = {
    val p = """mul\((\d+),(\d+)\)""".r
    val matches = p.findAllMatchIn(line)

    matches.map(m => {
      m.group(1).toInt * m.group(2).toInt
    }).sum
  }

  override def part2(input: Input): Int = {
    val p = """(?:do\(\)|^)(.*?)(?:don't\(\)|$)""".r
    val matches = p.findAllMatchIn(input.string())

    matches.map(m => {
      part1(m.group(1))
    }).sum
  }
}
