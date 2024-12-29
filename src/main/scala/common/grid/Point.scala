package aoc2024
package common.grid

case class Point(row: Int, col: Int) {

  def move(dRow: Int, dCol: Int): Point = Point(row + dRow, col + dCol)

  def move(direction: Direction, d: Int): Point = direction match
    case Direction.UP => move(-d, 0)
    case Direction.DOWN => move(d, 0)
    case Direction.LEFT => move(0, -d)
    case Direction.RIGHT => move(0, d)
    case Direction.UP_LEFT => move(-d, -d)
    case Direction.UP_RIGHT => move(-d, d)
    case Direction.DOWN_LEFT => move(d, -d)
    case Direction.DOWN_RIGHT => move(d, d)
}
