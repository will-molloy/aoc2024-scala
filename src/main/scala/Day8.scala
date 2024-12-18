package aoc2024

import scala.collection.mutable
import scala.util.boundary
import scala.util.boundary.break

/**
 * https://adventofcode.com/2024/day/8
 */
object Day8 {

  def part1(grid: Seq[Seq[Char]]): Long = {
    val nodes = mutable.Set[(Int, Int)]()
    val points = grid.indices.flatMap(row => grid.head.indices.map(col => (row, col)))
    points.foreach((row, col) => points.foreach((row2, col2) => {
      // 2 antenna
      if (!(row == row2 && col == col2)
        && grid(row)(col) == grid(row2)(col2)
        && grid(row)(col) != '.') {

        // math
        val dCol = Math.abs(col - col2)
        val dRow = Math.abs(row - row2)

        val row3 = if row < row2 then row - dRow else row + dRow
        val col3 = if col < col2 then col - dCol else col + dCol
        nodes.add((row3, col3))
      }
    }))
    nodes.filterNot((row, col) => oob(grid, row, col)).size
  }

  def part2(grid: Seq[Seq[Char]]): Long = {
    val nodes = mutable.Set[(Int, Int)]()
    val points = grid.indices.flatMap(row => grid.head.indices.map(col => (row, col)))
    points.foreach((row, col) => points.foreach((row2, col2) => {
      // 2 antenna
      if (!(row == row2 && col == col2)
        && grid(row)(col) == grid(row2)(col2)
        && grid(row)(col) != '.') {

        // math
        val dCol = Math.abs(col - col2)
        val dRow = Math.abs(row - row2)

        var m = 0
        boundary {
          while (true) {
            val row3 = if row < row2 then row - dRow * m else row + dRow * m
            val col3 = if col < col2 then col - dCol * m else col + dCol * m
            m += 1
            if (oob(grid, row3, col3)) {
              break()
            } else {
              nodes.add(row3, col3)
            }
          }
        }
      }
    }))
    nodes.size
  }

  private def oob(grid: Seq[Seq[Char]], row: Int, col: Int): Boolean = {
    row < 0 || col < 0 || row >= grid.length || col >= grid.head.length
  }
}
