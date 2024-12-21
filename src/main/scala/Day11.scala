package aoc2024

import common.Day

import scala.collection.mutable

/**
 * https://adventofcode.com/2024/day/11
 */
object Day11 extends Day[Seq[Long], Long](2024, 11) {

  override def part1(input: Seq[Long]): Long = {
    var stones = input.toBuffer
    for (_ <- 1 to 25) {
      stones = blink(stones)
    }
    stones.size
  }

  private def blink(line: mutable.Buffer[Long]): mutable.Buffer[Long] = {
    val buffer = mutable.ArrayBuffer[Long]()
    for (e <- line) {
      if (e == 0) {
        buffer.addOne(1)
      } else {
        val digits = e.toString
        if (digits.length % 2 == 0) {
          val (front, back) = digits.splitAt(digits.length / 2)
          buffer.addOne(front.toLong)
          buffer.addOne(back.toLong)
        } else {
          buffer.addOne(e * 2024)
        }
      }
    }
    buffer
  }

  override def part2(input: Seq[Long]): Long = {
    var stones = input.toBuffer
    for (_ <- 1 to 75) {
      stones = blink(stones)
    }
    stones.size
  }
}
