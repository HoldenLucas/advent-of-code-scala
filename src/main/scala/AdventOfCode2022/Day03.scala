package AdventOfCode2022

import scala.util.chaining._

object Day03:
  val valueMap: Map[Char, Int] =
    var lower = ('a' to 'z').zip(1 to 26)
    var upper = ('A' to 'Z').zip(27 to 52)
    (lower ++ upper).toMap

  def parse(input: String) =
    input
      .split("\n")

  def part1(input: String): Int =
    parse(input)
      .map(line =>
        line
          .grouped(line.length / 2)
          .map(_.toSet)
          .map(_.map(valueMap))
          .toSeq
      )
      // TODO: is there a way to turn the seq into a tuple2
      // so i can deconstruct it?
      .map(a => a(0).intersect(a(1)).head)
      .sum

  def part2(input: String): Int =
    parse(input)
      .grouped(3)
      .map(_.map(_.toSet))
      .map(_.reduce((a, b) => a.intersect(b)))
      // TODO: how do i get rid of this line?
      .map(_.map(valueMap).head)
      .sum

  def main(args: Array[String]): Unit =
    val data =
      io.Source.fromResource("AdventOfCode2022/Day03.txt").mkString

    println(part1(data))
    println(part2(data))
