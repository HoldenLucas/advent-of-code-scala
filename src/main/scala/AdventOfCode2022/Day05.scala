package AdventOfCode2022

import scala.util.chaining._

object Day05:
  def stacks(input: Seq[String]) =
    input
      // take everything before the column indexes and the line that is ""
      .take(input.indexOf("") - 1)
      // go to the 4th element of every line, i.e. the center of each box
      .map(line => (1 to line.length by 4).map(line))
      // we care about the columns, not the rows
      .transpose
      .map(_.mkString.trim)

  def instructions(input: Seq[String]) =
    input
      // drop everything before the empty line
      // TODO: why +1?
      .drop(input.indexOf("") + 1)
      .map { line =>
        val Array(amount, from, to) =
          line
            // split on everything that ISN'T a digit
            .split("\\D+")
            // first element of that split will always be an empty string
            .tail
            .map(_.toInt)
        // `from` and `to` are 1 indexed in the instructions,
        // but our array elements are 0 indexed
        (amount, from - 1, to - 1)
      }

  def run(input: Seq[String], reverse: Boolean) =
    instructions(input)
      .foldLeft(stacks(input)) { case (stack_state, (amount, from, to)) =>
        val (grabbed, remaining) = stack_state(from).splitAt(amount)

        // 'reverse' can also be thought of like "move crates one at a time"
        val res = if (reverse) grabbed.reverse else grabbed

        stack_state
          .updated(from, remaining)
          .updated(to, res + stack_state(to))
      }
      // only the top boxes
      .map(_.head)
      .mkString

  def part1(input: Seq[String]): String =
    run(input, true)

  def part2(input: Seq[String]): String =
    run(input, false)

  def main(args: Array[String]): Unit =
    val data =
      io.Source.fromResource("AdventOfCode2022/Day05.txt").getLines().toSeq
    println(part1(data))
    println(part2(data))
