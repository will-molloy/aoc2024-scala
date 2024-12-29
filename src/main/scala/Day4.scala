package aoc2024

import common.{Day, Direction, Input, Point}

import scala.annotation.tailrec

/**
 * https://adventofcode.com/2024/day/4
 */
object Day4 extends Day(2024, 4) {

  override def part1(input: Input): Int = {
    val grid = input.charGrid()
    var count = 0;

    @tailrec
    def dfs(point: Point, word: String, dir: Direction): Unit = {
      if (word == "XMAS") {
        count += 1
        return
      }

      if (word.length >= 4) {
        return
      }

      if (!grid.inBounds(point)) {
        return
      }

      dfs(point.move(dir, 1), word + grid(point), dir)
    }

    for (point <- grid.points) {
      // search all directions
      for (dir <- Direction.straightAndDiagonal) {
        dfs(point, "", dir)
      }
    }

    count
  }

  override def part2(input: Input): Int = {
    val grid = input.charGrid()
    grid.points
      // X-MAS must be centered on 'A'
      .filter(p => p.row >= 1 && p.col >= 1 && p.row < grid.height - 1 && p.col < grid.width - 1)
      .filter(p => grid(p) == 'A')
      .count(p => {
        val upLeft = grid(p.move(Direction.UP_LEFT, 1))
        val upRight = grid(p.move(Direction.UP_RIGHT, 1))
        val downLeft = grid(p.move(Direction.DOWN_LEFT, 1))
        val downRight = grid(p.move(Direction.DOWN_RIGHT, 1))

        List(Set(upLeft, downRight), Set(downLeft, upRight)).forall(_ == Set('M', 'S'))
      })
  }
}
