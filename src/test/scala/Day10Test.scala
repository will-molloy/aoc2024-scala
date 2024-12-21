package aoc2024

import common.{DayTest, Grid, Inputs}

import org.scalatest.funsuite.AnyFunSuite

import scala.io.Source

class Day10Test extends DayTest(Day10) {
  override def input: Source => Grid[Char] = Inputs.charGrid

  override def part1: Expected = Expected(36, 489)

  override def part2: Expected = Expected(81, 1086)
}
