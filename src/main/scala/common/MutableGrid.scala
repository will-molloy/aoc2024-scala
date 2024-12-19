package aoc2024
package common

import scala.collection.mutable

class MutableGrid[T](grid: Seq[Seq[T]]) {
  private val mutableGrid = mutable.Seq.from(grid.map(mutable.Seq.from))

  @throws[IndexOutOfBoundsException]
  def apply(point: Point): T = mutableGrid(point.row)(point.col)

  @throws[IndexOutOfBoundsException]
  def update(point: Point, t: T): Unit = mutableGrid(point.row)(point.col) = t

  def inBounds(point: Point): Boolean = mutableGrid.indices.contains(point.row) && mutableGrid.head.indices.contains(point.col)

  def points: Seq[Point] = mutableGrid.indices.flatMap(row => mutableGrid.head.indices.map(col => Point(row, col)))

  def height: Int = mutableGrid.length

  def width: Int = mutableGrid.head.length

  def size: Int = height * width

  def copy: MutableGrid[T] = MutableGrid(mutableGrid.map(_.toSeq).toSeq)
}
