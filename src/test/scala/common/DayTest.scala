package aoc2024
package common

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.shouldBe

import scala.io.Source

trait DayTest[TInput, TOutput, TDay <: Day[TInput, TOutput]](day: TDay) extends AnyFunSuite {
  private val ci = sys.env.contains("CI")

  test("part1 - example") {
    day.part1(readInput(true)).shouldBe(part1Expected.example)
  }

  test("part1 - real") {
    if (!ci) {
      day.part1(readInput(false)).shouldBe(part1Expected.real)
    }
  }

  test("part2 - example") {
    day.part2(readInput(true)).shouldBe(part2Expected.example)
  }

  test("part2 - real") {
    if (!ci) {
      day.part2(readInput(false)).shouldBe(part2Expected.real)
    }
  }

  private def readInput(example: Boolean): TInput = {
    // TODO automate download and submit
    val fileName = s"input/${day.year}/${if example then "example_input" else "real_input"}/day${day.day}.txt"
    val input = Source.fromResource(fileName)
    convertInput(input)
  }

  def convertInput: Source => TInput

  def part1Expected: Expected

  def part2Expected: Expected

  class Expected(val example: TOutput, val real: TOutput)
}
