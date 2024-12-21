package aoc2024
package common

class Grid[T](grid: Array[Array[T]]) {
  @throws[IndexOutOfBoundsException]
  def apply(point: Point): T = grid(point.row)(point.col)

  @throws[IndexOutOfBoundsException]
  def update(point: Point, t: T): Unit = grid(point.row)(point.col) = t

  def inBounds(point: Point): Boolean = grid.indices.contains(point.row) && grid.head.indices.contains(point.col)

  def points: Seq[Point] = grid.indices.flatMap(row => grid.head.indices.map(col => Point(row, col)))

  def height: Int = grid.length

  def width: Int = grid.head.length

  def size: Int = height * width

  def copy: Grid[T] = Grid[T](grid.transpose.transpose)
}
