package aoc2024

import common.*

import scala.collection.mutable

/**
 * https://adventofcode.com/2024/day/11
 */
object Day11 extends Day(2024, 11) {
  private val dp = mutable.HashMap[(Long, Int), Long]()

  override def part1(input: Input): Long = {
    input.nums().map(amount(_, 25)).sum
  }

  override def part2(input: Input): Long = {
    input.nums().map(amount(_, 75)).sum
  }

  private def amount(stone: Long, blinks: Int): Long = {
    dp.getOrElseUpdate((stone, blinks), {
      if (blinks == 0) {
        1
      } else if (stone == 0) {
        amount(1, blinks - 1)
      } else {
        val digits = stone.toString
        if (digits.length % 2 == 0) {
          val (front, back) = digits.splitAt(digits.length / 2)
          amount(front.toLong, blinks - 1) + amount(back.toLong, blinks - 1)
        } else {
          amount(stone * 2024, blinks - 1)
        }
      }
    })
  }
}
