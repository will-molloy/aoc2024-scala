package aoc2024
package common

import scala.io.Source

object Inputs {
  def lines(input: Source): Seq[String] = input.getLines().toSeq

  def charGrid(input: Source): Seq[Seq[Char]] = lines(input).map(_.toCharArray)

  def intGrid(input: Source): Seq[Seq[Int]] = lines(input).map(_.split("\\s+").map(_.toInt))
}
