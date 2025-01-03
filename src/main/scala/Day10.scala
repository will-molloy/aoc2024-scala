package aoc2024

import common.*
import common.grid.*

import scala.collection.mutable

/**
 * https://adventofcode.com/2024/day/10
 */
object Day10 extends Day(2024, 10) {

  override def part1(input: Input): Long = {
    val grid = input.charGrid()
    grid.points.filter(grid(_) == '0').map(score(grid, _)).sum
  }

  private def score(grid: Grid[Char], start: Point): Long = {
    val reach = mutable.Set[Point]()

    def dfs(current: Point): Unit = {
      if (grid(current) == '9') {
        reach.add(current)
        return
      }

      for (dir <- Direction.straight) {
        val next = current.move(dir, 1)
        if (grid.inBounds(next) && grid(next) == grid(current) + 1) {
          dfs(next)
        }
      }
    }

    dfs(start)
    reach.size
  }

  override def part2(input: Input): Long = {
    val grid = input.charGrid()
    grid.points.filter(grid(_) == '0').map(rating(grid, _)).sum
  }

  private def rating(grid: Grid[Char], start: Point): Long = {
    val paths = mutable.Set[Seq[Point]]()

    def dfs(path: Seq[Point]): Unit = {
      val current = path.last
      if (grid(current) == '9') {
        paths.add(path)
        return
      }

      for (dir <- Direction.straight) {
        val next = current.move(dir, 1)
        if (grid.inBounds(next) && grid(next) == grid(current) + 1) {
          dfs(path :+ next)
        }
      }
    }

    dfs(Seq(start))
    paths.size
  }
}
