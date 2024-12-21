package aoc2024
package common

import scala.io.Source

object Inputs {
  def lines(input: Source): Seq[String] = input.getLines().toSeq

  // join string WITHOUT newlines...!
  def string(input: Source): String = lines(input).mkString("")

  def intLines(input: Source): Seq[Seq[Int]] = lines(input).map(_.split("\\s+").map(_.toInt))

  def charGrid(input: Source): Grid[Char] = Grid(lines(input).toArray.map(_.toCharArray))
}
