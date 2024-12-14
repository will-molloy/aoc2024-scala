package aoc2024
package day3

/**
 * https://adventofcode.com/2024/day/3
 */
object Day3 {

  def part1(line: String): Int = {
    val p = """mul\((\d+),(\d+)\)""".r
    val matches = p.findAllMatchIn(line)

    matches.map(m => {
      m.group(1).toInt * m.group(2).toInt
    }).sum
  }

  def part2(line: String): Int = {
    val p = """(?:do\(\)|^)(.*?)(?:don't\(\)|$)""".r
    val matches = p.findAllMatchIn(line)

    matches.map(m => {
      part1(m.group(1))
    }).sum
  }
}
