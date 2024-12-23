package aoc2024
package common

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.shouldBe

import scala.io.Source

trait DayTest[TInput, TOutput, TDay <: Day[TInput, TOutput]](day: TDay) extends AnyFunSuite {
  private val ci = sys.env.contains("CI")

  test("part1 - example") {
    day.part1(readInput(true)).shouldBe(part1.example)
  }

  test("part1 - real") {
    if (ci) {
      cancel()
    }
    day.part1(readInput(false)).shouldBe(part1.real)
  }

  test("part2 - example") {
    day.part2(readInput(true)).shouldBe(part2.example)
  }

  test("part2 - real") {
    if (ci) {
      cancel()
    }
    day.part2(readInput(false)).shouldBe(part2.real)
  }

  private def readInput(example: Boolean): TInput = {
    // TODO automate download and submit
    val fileName = s"input/${day.year}/${if example then "example_input" else "real_input"}/day${day.day}.txt"
    input(Source.fromResource(fileName))
  }

  // TODO move this to main code, keeps all logic in 1 place
  def input: Source => TInput

  def part1: Expected

  def part2: Expected

  class Expected(val example: TOutput, val real: TOutput)
}
