package aoc2024
package day6

import scala.annotation.tailrec
import scala.collection.mutable

/**
 * https://adventofcode.com/2024/day/6
 */
object Day6 {

  def part1(grid: mutable.Seq[mutable.Seq[Char]]): Int = {
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
