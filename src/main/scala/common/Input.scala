package aoc2024
package common

import common.grid.Grid

import scala.io.Source

// TODO automate download and submit
class Input private(private val day: Day, private val inputDir: String) {

  private def source(): Source = {
    val fileName = s"input/${day.year}/$inputDir/day${day.day}.txt"
    Source.fromResource(fileName)
  }

  def lines(): Seq[String] = source().getLines().toSeq

  // join string WITHOUT newlines...!
  def string(): String = lines().mkString("")

  def nums(): Seq[Long] = string().split("\\s+").map(_.toLong)

  // TODO prob want to use Long over Int everywhere
  def numLines(): Seq[Seq[Int]] = lines().map(_.split("\\s+").map(_.toInt))

  def charGrid(): Grid[Char] = Grid(lines().toArray.map(_.toCharArray))
}

object Input {
  def example(day: Day) = Input(day, "example_input")

  def real(day: Day) = Input(day, "real_input")
}
