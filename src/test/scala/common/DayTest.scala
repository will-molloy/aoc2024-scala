package aoc2024
package common

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.shouldBe

trait DayTest(day: Day) extends AnyFunSuite {
  private val ci = sys.env.contains("CI")

  test("part1 - example") {
    day.part1(Input.example(day)).shouldBe(part1.example)
  }

  test("part1 - real") {
    assume(!ci)
    day.part1(Input.real(day)).shouldBe(part1.real)
  }

  test("part2 - example") {
    day.part2(Input.example(day)).shouldBe(part2.example)
  }

  test("part2 - real") {
    assume(!ci)
    day.part2(Input.real(day)).shouldBe(part2.real)
  }

  def part1: Expected

  def part2: Expected

  class Expected(val example: Any, val real: Any)
}
