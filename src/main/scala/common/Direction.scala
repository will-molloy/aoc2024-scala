package aoc2024
package common

enum Direction {
  case UP, DOWN, LEFT, RIGHT,
  UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT
}

object Direction {
  def straight: Seq[Direction] = Seq(UP, DOWN, LEFT, RIGHT)

  def straightAndDiagonal: Seq[Direction] = Direction.values
}
