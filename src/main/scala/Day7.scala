package aoc2024

object Day7 {

  def part1(lines: Seq[String]): Long = {
    lines.map(result(_, Seq('+', '*'))).sum
  }

  def part2(lines: Seq[String]): Long = {
    lines.map(result(_, Seq('+', '*', '|'))).sum
  }

  private def result(line: String, ops: Seq[Char]): Long = {
    val colon = line.indexOf(':')
    val target = line.take(colon).toLong
    val nums = line.drop(colon + 1).split(' ').filterNot(_.isBlank).map(_.toLong)

    def dfs(i: Int, op: Char, result: Long): Boolean = {
      if (result == target) {
        true
      } else if (i == nums.length) {
        false
      } else {
        op match
          case '+' => ops.exists(op => dfs(i + 1, op, result + nums(i)))
          case '*' => ops.exists(op => dfs(i + 1, op, result * nums(i)))
          case '|' => ops.exists(op => dfs(i + 1, op, (result.toString + nums(i).toString).toLong))
      }
    }

    if (ops.exists(op => dfs(1, op, nums.head))) {
      target
    } else {
      0
    }
  }
}
