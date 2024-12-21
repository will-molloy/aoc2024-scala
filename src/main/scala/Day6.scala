package aoc2024

import common.{Day, Direction, Grid, Point}

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.parallel.CollectionConverters.*

/**
 * https://adventofcode.com/2024/day/6
 */
object Day6 extends Day[Grid[Char], Int](2024, 6) {

  override def part1(grid: Grid[Char]): Int = {
    val visited = mutable.Set[Point]()

    @tailrec
    def dfs(point: Point): Unit = {
      visited.add(point)

      val dir = grid(point)
      val next = point.move(mapDir(dir), 1)

      if (!grid.inBounds(next)) {
        // out
        return
      }

      else if (grid(next) == '.') {
        // move forward
        grid(next) = dir
        grid(point) = '.'
        dfs(next)
      }

      else if (grid(next) == '#') {
        // turn 90deg
        grid(point) = nextDir(dir)
        dfs(point)
      }
    }

    // find start
    val start = grid.points
      .find(point => Set('>', '<', '^', 'V').contains(grid(point)))
      .get

    dfs(start)

    visited.size
  }

  override def part2(grid: Grid[Char]): Int = {
    // find start
    val start = grid.points
      .find(point => Set('>', '<', '^', 'V').contains(grid(point)))
      .get

    // try obstacle in all positions
    grid.points.filter(point => grid(point) == '.')
      .par
      .count(point => {
        val copy = grid.copy
        copy(point) = '#'
        looping(copy, start)
      })
  }

  private def looping(grid: Grid[Char], start: Point): Boolean = {
    // TODO how to define looping?
    // 1 - it passes through the starting position? No - it can still leave
    // 2 - it creates a square - 5th turn is in last 4 turns? No - it can loop NOT in a square
    // 3 - ??? how about if turns = grid size. That is at least an upper bound...
    val turns = mutable.Set[Point]()
    var turnsCount = 0

    @tailrec
    def dfs(point: Point): Boolean = {
      val dir = grid(point)
      val next = point.move(mapDir(dir), 1)

      if (!grid.inBounds(next)) {
        // out
        false
      }

      else if (grid(next) == '.') {
        // move forward
        grid(next) = dir
        grid(point) = '.'
        dfs(next)
      }

      else if (grid(next) == '#') {
        if (turnsCount == grid.size && turns.contains(point)) {
          return true
        }
        turns.add(point)
        turnsCount += 1

        // turn 90deg
        grid(point) = nextDir(dir)
        dfs(point)
      }

      else {
        false
      }
    }

    dfs(start)
  }

  private def mapDir(dir: Char): Direction = dir match {
    case '^' => Direction.UP
    case '>' => Direction.RIGHT
    case 'V' => Direction.DOWN
    case '<' => Direction.LEFT
  }

  private def nextDir(dir: Char): Char = dir match {
    case '^' => '>'
    case '>' => 'V'
    case 'V' => '<'
    case '<' => '^'
  }
}
