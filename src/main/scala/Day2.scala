package aoc2024

import common.{Day, Input}

import scala.annotation.tailrec

/**
 * https://adventofcode.com/2024/day/2
 */
object Day2 extends Day(2024, 2) {

  override def part1(input: Input): Int = {
    input.numLines().count(isSafe)
  }

  override def part2(input: Input): Int = {
    // try all combinations
    input.numLines().count(report => report.indices.exists(i => {
      val newReport = report.take(i) ++ report.drop(i + 1)
      isSafe(newReport)
    }))
  }

  private def isSafe(report: Seq[Int]): Boolean = {
    @tailrec
    def isSafe(list: Seq[Int], increasing: Boolean): Boolean = {
      list match
        case Seq() | Seq(_) => true
        case a +: b +: tail => {
          if (increasing && a >= b || !increasing && a <= b) {
            return false
          }

          val diff = math.abs(a - b)
          if (diff < 1 || diff > 3) {
            return false
          }

          isSafe(b +: tail, increasing)
        }
    }

    if (report.length < 2) true
    else isSafe(report, report(0) < report(1))
  }
}
