package aoc2024

import common.{DayTest, Grid, Inputs}

import org.scalatest.funsuite.AnyFunSuite

import scala.io.Source

class Day12Test extends DayTest(Day12) {
  override def input: Source => Grid[Char] = Inputs.charGrid

  override def part1 = Expected(1930, 1485656)

  override def part2 = Expected(1206, 0)
}
