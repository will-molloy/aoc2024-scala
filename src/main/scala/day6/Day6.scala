package aoc2024
package day6

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.parallel.CollectionConverters._

/**
 * https://adventofcode.com/2024/day/6
 */
object Day6 {

  def part1(grid: Seq[Seq[Char]]): Int = {
    val mutableGrid = mutable.Seq.from(grid.map(mutable.Seq.from))
    part1(mutableGrid)
  }

  private def part1(grid: mutable.Seq[mutable.Seq[Char]]): Int = {
    val visited = mutable.Set[(Int, Int)]()

    @tailrec
    def dfs(row: Int, col: Int): Unit = {
      visited.add((row, col))

      val dir = grid(row)(col)
      val move = dirMove(dir)

      val nextRow = row + move._1
      val nextCol = col + move._2

      if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid(row).length) {
        // out
        return
      }

      else if (grid(nextRow)(nextCol) == '.') {
        // move forward
        grid(nextRow)(nextCol) = dir
        grid(row)(col) = '.'
        dfs(nextRow, nextCol)
      }

      else if (grid(nextRow)(nextCol) == '#') {
        // turn 90deg
        grid(row)(col) = nextDir(dir)
        dfs(row, col)
      }
    }

    // find start
    val start = grid.indices.flatMap(row => grid(row).indices.map(col => (row, col)))
      .find((row, col) => Set('>', '<', '^', 'V').contains(grid(row)(col)))
      .get

    dfs.tupled(start)

    visited.size
  }

  def part2(grid: Seq[Seq[Char]]): Int = {
    val points = grid.indices.flatMap(row => grid(row).indices.map(col => (row, col)))

    // find start
    val start = points.find((row, col) => Set('>', '<', '^', 'V').contains(grid(row)(col))).get

    // try obstacle in all positions
    points.filter((row, col) => grid(row)(col) == '.')
      .par
      .count((row, col) => {
        val mutableGrid = mutable.Seq.from(grid.map(mutable.Seq.from))
        mutableGrid(row)(col) = '#'
        looping(mutableGrid, start)
      })
  }

  private def looping(grid: mutable.Seq[mutable.Seq[Char]], start: (Int, Int)): Boolean = {
    // TODO how to define looping?
    // 1 - it passes through the starting position? No - it can still leave
    // 2 - it creates a square - 5th turn is in last 4 turns? No - it can loop NOT in a square
    // 3 - ??? how about if turns = grid size. That is at least an upper bound...
    val gridSize = grid.length * grid.head.length

    val turns = mutable.Set[(Int, Int)]()
    var turnsCount = 0

    @tailrec
    def dfs(row: Int, col: Int): Boolean = {
      val dir = grid(row)(col)
      val move = dirMove(dir)

      val nextRow = row + move._1
      val nextCol = col + move._2

      if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid(row).length) {
        // out
        false
      }

      else if (grid(nextRow)(nextCol) == '.') {
        // move forward
        grid(nextRow)(nextCol) = dir
        grid(row)(col) = '.'
        dfs(nextRow, nextCol)
      }

      else if (grid(nextRow)(nextCol) == '#') {
        if (turnsCount == gridSize && turns.contains((row, col))) {
          return true
        }
        turns.add((row, col))
        turnsCount += 1

        // turn 90deg
        grid(row)(col) = nextDir(dir)
        dfs(row, col)
      }

      else {
        false
      }
    }

    dfs.tupled(start)
  }

  private def dirMove(dir: Char): (Int, Int) = dir match {
    case '^' => (-1, 0)
    case '>' => (0, 1)
    case 'V' => (1, 0)
    case '<' => (0, -1)
  }

  private def nextDir(dir: Char): Char = dir match {
    case '^' => '>'
    case '>' => 'V'
    case 'V' => '<'
    case '<' => '^'
  }
}
