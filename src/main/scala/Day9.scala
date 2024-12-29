package aoc2024

import common.*

import scala.collection.mutable

/**
 * https://adventofcode.com/2024/day/9
 */
object Day9 extends Day(2024, 9) {

  override def part1(input: Input): Long = {
    val diskMap = input.string().split("").map(_.toInt)
    checkSum(compact(expand(diskMap)))
  }

  private def expand(diskMap: Array[Int]): Array[Block] = {
    val disk = mutable.ArrayBuffer[Block]()
    var id = 0
    var file = true
    for (n <- diskMap) {
      if (file) {
        disk.appendAll(Array.fill(n)(Block(id)))
        id += 1
      } else {
        disk.appendAll(Array.fill(n)(Block('.')))
      }
      file = !file
    }
    disk.toArray
  }

  private def compact(disk: Array[Block]): Array[Block] = {
    var start = 0
    var end = disk.length - 1
    while (start <= end) {
      if (disk(start).isFile) {
        start += 1
      } else {
        // swap
        val temp = disk(end)
        disk(end) = disk(start)
        disk(start) = temp
        end -= 1
      }
    }
    disk
  }

  private def checkSum(disk: Array[Block]): Long = {
    disk.zipWithIndex
      .filter(_._1.isFile)
      .foldLeft(0L) { case (sum, (block, i)) => sum + block.fileId * i }
  }

  override def part2(input: Input): Long = {
    val diskMap = input.string().split("").map(_.toInt)
    checkSum2(compact2(expand2(diskMap)))
  }

  private def expand2(diskMap: Array[Int]): mutable.ArrayBuffer[(Block, Int)] = {
    val disk = mutable.ArrayBuffer[(Block, Int)]()
    var id = 0
    var file = true
    for (n <- diskMap) {
      if (file) {
        disk.addOne((Block(id), n))
        id += 1
      } else {
        disk.addOne((Block('.'), n))
      }
      file = !file
    }
    disk
  }

  private def compact2(disk: mutable.ArrayBuffer[(Block, Int)]): Array[(Block, Int)] = {
    var end = disk.length - 1
    while (end > 0) {
      val (block, fileSize) = disk(end)

      if (block.isFile) {
        val start = disk.indices
          .find(i => i < end && !disk(i)._1.isFile && disk(i)._2 >= fileSize)
          .getOrElse(-1)

        if (start > -1) {
          val freeSpace = disk(start)._2
          val leftOverSpace = freeSpace - fileSize

          if (leftOverSpace == 0) {
            // simply swap
            val temp = disk(end)
            disk(end) = disk(start)
            disk(start) = temp
          } else {
            disk(start) = disk(end)
            disk(end) = (Block('.'), fileSize)
            disk.insert(start + 1, (Block('.'), leftOverSpace))
            // compact any free space
            // (tests still pass without this... it speeds it up though)
            // TODO not needed or test doesn't cover it ???
            var i = 0
            while (i < disk.length - 1) {
              if (!disk(i)._1.isFile && !disk(i + 1)._1.isFile) {
                disk(i) = (Block('.'), disk(i)._2 + disk(i + 1)._2)
                disk.remove(i + 1)
              } else {
                i += 1
              }
            }
          }
        } else {
          // can't move this file
          end -= 1
        }
      } else {
        // not a file
        end -= 1
      }
    }
    disk.toArray
  }

  private def checkSum2(disk: Array[(Block, Int)]): Long = {
    val flattened = disk.flatMap((block, n) => Array.fill(n)(block))
    checkSum(flattened)
  }

  private case class Block(value: Int | '.') {
    def isFile: Boolean = value.isInstanceOf[Int]

    def fileId: Int = value.asInstanceOf[Int]

    override def toString: String = value.toString
  }
}
