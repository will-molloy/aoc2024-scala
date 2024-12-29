package aoc2024

import common.{Day, Input}

import scala.annotation.tailrec

/**
 * https://adventofcode.com/2024/day/5
 */
object Day5 extends Day(2024, 5) {

  override def part1(input: Input): Int = {
    val lines = input.lines()
    val rules = lines.takeWhile(s => s.contains('|'))
      .map(_.split('|').map(_.toInt)).map(a => (a(0), a(1)))
      .toSet
    val updates = lines.dropWhile(s => s.contains('|')).drop(1)
      .map(_.split(',').map(_.toInt).toSeq)

    updates.filter(good.curried(rules)).map(update => {
      update(update.length / 2)
    }).sum
  }

  private def good(rules: Set[(Int, Int)], update: Seq[Int]): Boolean = {
    update.indices.forall(i => update.indices.drop(i + 1).forall(j => !rules.contains((update(j), update(i)))))
  }

  override def part2(input: Input): Int = {
    val lines = input.lines()
    val rules = lines.takeWhile(s => s.contains('|'))
      .map(_.split('|').map(_.toInt)).map(a => (a(0), a(1)))
      .toSet
    val updates = lines.dropWhile(s => s.contains('|')).drop(1)
      .map(_.split(',').map(_.toInt).toSeq)

    updates.filterNot(good.curried(rules)).map(update => {
      val fixed = untilGood(rules, update)
      fixed(update.length / 2)
    }).sum
  }

  @tailrec
  private def untilGood(rules: Set[(Int, Int)], update: Seq[Int]): Seq[Int] = {
    val pairs = update.indices.flatMap(i => update.indices.drop(i + 1).map(j => (i, j)))
    val badPair = pairs.find((i, j) => rules.contains((update(j), update(i))))

    badPair match
      case Some((i, j)) => untilGood(rules, swap(update, i, j))
      case None => update
  }

  private def swap[T](seq: Seq[T], index1: Int, index2: Int): Seq[T] = {
    seq.take(index1) ++ Seq(seq(index2)) ++ seq.slice(index1 + 1, index2) ++ Seq(seq(index1)) ++ seq.drop(index2 + 1)
  }
}
