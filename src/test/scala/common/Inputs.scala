package aoc2024
package common

import scala.io.Source

object Inputs {
  def lines(input: Source): Seq[String] = input.getLines().toSeq

  // join string WITHOUT newlines...!
  def string(input: Source): String = lines(input).mkString("")

  def nums(input: Source): Seq[Long] = string(input).split("\\s+").map(_.toLong)

  // TODO prob want to use Long over Int everywhere
  def numLines(input: Source): Seq[Seq[Int]] = lines(input).map(_.split("\\s+").map(_.toInt))

  def charGrid(input: Source): Grid[Char] = Grid(lines(input).toArray.map(_.toCharArray))
}
