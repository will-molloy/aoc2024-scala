package aoc2024

import common.{Day, Direction, Grid, Point}

import scala.collection.mutable

/**
 * https://adventofcode.com/2024/day/12
 */
object Day12 extends Day[Grid[Char], Long](2024, 12) {

  override def part1(grid: Grid[Char]): Long = {
    regions(grid)
      .toSeq.sortBy(region => grid(region.head))
      .map(region => {
        val a = region.size
        val p = perimeter(region)
        println(s"${grid(region.head)} = $a * $p")
        a * p
      }).sum
  }

  override def part2(input: Grid[Char]): Long = ???

  private def perimeter(region: Set[Point]): Long = {
    // idea: perimeter = area * 4 - inner_edges
    val area = region.size
    val edges = mutable.Set[(Point, Point)]()

    for (point <- region) {
      for (dir <- Direction.straight) {
        val next = point.move(dir, 1)
        if (region(next)) {
          edges.add((point, next))
        }
      }
    }
    area * 4 - edges.size
  }

  private def regions(grid: Grid[Char]): Set[Set[Point]] = {
    val visited = mutable.Set[Point]()

    def dfs(current: Point, region: mutable.Set[Point]): Unit = {
      visited.add(current)
      region.add(current)

      for (dir <- Direction.straight) {
        val next = current.move(dir, 1)
        if (grid.inBounds(next) && !visited(next) && grid(next) == grid(current)) {
          dfs(next, region)
        }
      }
    }

    val regions = mutable.Set[Set[Point]]()
    for (point <- grid.points) {
      if (!visited.contains(point)) {
        val region = mutable.Set[Point]()
        dfs(point, region)
        regions.add(region.toSet)
      }
    }
    regions.toSet
  }
}
