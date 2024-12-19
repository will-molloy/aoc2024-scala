package aoc2024
package common

trait Day[TInput, TOutput](val year: Int, val day: Int) {

  def part1(input: TInput): TOutput

  def part2(input: TInput): TOutput
}
