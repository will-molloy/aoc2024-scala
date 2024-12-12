package aoc2024
package day4

import scala.annotation.tailrec

/**
 * https://adventofcode.com/2024/day/4
 */
object Day4 {

  def part1(grid: Seq[Seq[Char]]): Int = {
    var count = 0;

    @tailrec
    def dfs(row: Int, col: Int, word: String, dRow: Int, dCol: Int): Unit = {
      if (word == "XMAS") {
        count += 1
        return
      }

      if (word.length >= 4) {
        return
      }

      if (row < 0 || row >= grid.length || col < 0 || col >= grid(row).length) {
        return
      }

      dfs(row + dRow, col + dCol, word + grid(row)(col), dRow, dCol)
    }

    for (row <- grid.indices) {
      for (col <- grid(row).indices) {
        // search all directions
        for (dRow <- -1 to 1) {
          for (dCol <- -1 to 1) {
            if (!(dRow == 0 && dCol == 0)) {
              dfs(row, col, "", dRow, dCol)
            }
          }
        }
      }
    }

    count
  }

  def part2(grid: Seq[Seq[Char]]): Int = {
    var count = 0

    for (row <- 1 until grid.length - 1) {
      for (col <- 1 until grid(row).length - 1) {
        // X-MAS must be centered on 'A'
        if (grid(row)(col) == 'A') {
          val topLeft = grid(row - 1)(col - 1)
          val topRight = grid(row - 1)(col + 1)
          val bottomLeft = grid(row + 1)(col - 1)
          val bottomRight = grid(row + 1)(col + 1)

          if (Set(topLeft, bottomRight) == Set('M', 'S')
            && Set(bottomLeft, topRight) == Set('M', 'S')) {
            count += 1
          }
        }
      }
    }

    count
  }
}
