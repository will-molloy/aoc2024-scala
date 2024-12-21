package aoc2024

import common.Day

import scala.collection.mutable
import scala.language.postfixOps

object Day9 extends Day[String, Long](2024, 9) {

  override def part1(input: String): Long = {
    val diskMap = input.split("").map(_.toInt)
    checkSum(compact(expand(diskMap)))
  }

  private def expand(diskMap: Array[Int]): Array[Char | Int] = {
    val disk = mutable.ArrayBuffer[Char | Int]()
    var id = 0
    var file = true
    for (i <- diskMap) {
      if (file) {
        disk.appendAll(Array.fill(i)(id))
        id += 1
      } else {
        disk.appendAll(Array.fill(i)('.'))
      }
      file = !file
    }
    disk.toArray
  }

  private def compact(disk: Array[Char | Int]): Array[Char | Int] = {
    var start = 0
    var end = disk.length - 1
    while (start <= end) {
      // need to check as 'Char' otherwise it treats 46 as '.'
      if (disk(start).isInstanceOf[Char] && disk(start) == '.') {
        val temp = disk(end)
        disk(end) = disk(start)
        disk(start) = temp
        end -= 1
      } else {
        start += 1
      }
    }
    disk
  }

  private def checkSum(disk: Array[Char | Int]): Long = {
    disk.takeWhile(_.isInstanceOf[Int])
      .zipWithIndex
      .foldLeft(0L) { case (sum, (id, i)) => sum + id.asInstanceOf[Int].toLong * i }
  }

  override def part2(input: String): Long = {
    0
  }
}
