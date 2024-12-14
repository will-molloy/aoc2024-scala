package aoc2024

object Day7 {

  def part1(lines: Seq[String]): Long = {
    lines.map(result).sum
  }

  private def result(line: String) : Long = {
    val colon = line.indexOf(':')
    val target = line.take(colon).toLong
    val nums = line.drop(colon + 1).split(' ').filterNot(_.isBlank).map(_.toLong)

    def dfs(i: Int, op: Char, result: Long): Long = {
      if (result == target) {
        result
      } else if (i == nums.length) {
        0
      } else {
        op match
          case '+' => Math.max(dfs(i + 1, '+', result + nums(i)), dfs(i + 1, '*', result + nums(i)))
          case '*' => Math.max(dfs(i + 1, '+', result * nums(i)), dfs(i + 1, '*', result * nums(i)))
          case _ => 0
      }
    }

    Math.max(dfs(1, '+', nums.head), dfs(1, '*', nums.head))
  }
}
