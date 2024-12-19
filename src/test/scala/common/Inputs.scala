package aoc2024
package common

import scala.io.Source

object Inputs {
  def lines(input: Source): Seq[String] = input.getLines().toSeq

  def grid(input: Source): Seq[Seq[Char]] = lines(input).map(_.toCharArray)
}
