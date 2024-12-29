package aoc2024

import common.*

/**
 * https://adventofcode.com/2024/day/7
 */
object Day7 extends Day(2024, 7) {

  override def part1(input: Input): Long = {
    input.lines().map(result(_, Seq('+', '*'))).sum
  }

  override def part2(input: Input): Long = {
    input.lines().map(result(_, Seq('+', '*', '|'))).sum
  }

  private def result(line: String, ops: Seq[Char]): Long = {
    val colon = line.indexOf(':')
    val target = line.take(colon).toLong
    val nums = line.drop(colon + 1).split(' ').filterNot(_.isEmpty).map(_.toLong)

    def dfs(i: Int, current: Long): Boolean = {
      if (i == nums.length) {
        current == target
      } else {
        ops.exists(op => {
          val next = op match
            case '+' => current + nums(i)
            case '*' => current * nums(i)
            case '|' => (current.toString + nums(i).toString).toLong
          dfs(i + 1, next)
        })
      }
    }

    if (dfs(1, nums.head)) target else 0
  }
}
