package aoc2024

import common._

import scala.collection.mutable
import scala.util.boundary
import scala.util.boundary.break

/**
 * https://adventofcode.com/2024/day/8
 */
object Day8 extends Day[Grid[Char], Long](2024, 8) {

  override def part1(grid: Grid[Char]): Long = {
    val nodes = mutable.Set[Point]()
    grid.points.foreach(point => grid.points.foreach(point2 => {
      // 2 antenna
      if (point != point2
        && grid(point) == grid(point2)
        && grid(point) != '.') {

        // math
        val dRow = Math.abs(point.row - point2.row)
        val dCol = Math.abs(point.col - point2.col)

        val row3 = if point.row < point2.row then point.row - dRow else point.row + dRow
        val col3 = if point.col < point2.col then point.col - dCol else point.col + dCol
        nodes.add(Point(row3, col3))
      }
    }))
    nodes.count(grid.inBounds)
  }

  override def part2(grid: Grid[Char]): Long = {
    val nodes = mutable.Set[Point]()
    grid.points.foreach(point => grid.points.foreach(point2 => {
      // 2 antenna
      if (point != point2
        && grid(point) == grid(point2)
        && grid(point) != '.') {

        // math
        val dRow = Math.abs(point.row - point2.row)
        val dCol = Math.abs(point.col - point2.col)

        var m = 0
        boundary {
          while (true) {
            val row3 = if point.row < point2.row then point.row - dRow * m else point.row + dRow * m
            val col3 = if point.col < point2.col then point.col - dCol * m else point.col + dCol * m
            val point3 = Point(row3, col3)
            m += 1
            if (grid.inBounds(point3)) {
              nodes.add(point3)
            } else {
              break()
            }
          }
        }
      }
    }))
    nodes.size
  }
}
