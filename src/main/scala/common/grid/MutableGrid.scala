package aoc2024
package common.grid

class MutableGrid[T](grid: Array[Array[T]]) extends Grid[T](grid) {
  @throws[IndexOutOfBoundsException]
  def update(point: Point, t: T): Unit = grid(point.row)(point.col) = t
}
