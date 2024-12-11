package aoc2024
package day3

import scala.util.matching.Regex

/**
 * https://adventofcode.com/2024/day/3
 */
object Day3 {

  def part1(line: String): Int = {
    val p: Regex = """mul\((\d+),(\d+)\)""".r
    val matches = p.findAllMatchIn(line)

    matches.map(m => {
      println(m.matched)
      m.group(1).toInt * m.group(2).toInt
    }).sum
  }

  def part2(line: String): Int = {
    val p: Regex = """(?:do\(\)|^)(.*?)(?:don't\(\)|$)""".r
    val matches = p.findAllMatchIn(line)

    matches.map(m => {
      println(m.matched)
      part1(m.group(1))
    }).sum
  }
}
