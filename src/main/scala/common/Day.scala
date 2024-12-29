package aoc2024
package common

trait Day(val year: Int, val day: Int) {

  def part1(input: Input): Any

  def part2(input: Input): Any
}
