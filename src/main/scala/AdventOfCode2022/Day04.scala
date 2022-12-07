package AdventOfCode2022

import scala.util.chaining._

object Day04:
  def parse(input: String): Array[Array[Set[Int]]] =
    input
      .split("\n")
      .map(_.split(","))
      .map(_.map(foo => {
        val bar = foo.split("-")
        (bar(0).toInt to bar(1).toInt).toSet
      }))

  def part1(input: String): Int =
    parse(input)
      .filter(foo => foo(0).subsetOf(foo(1)) || foo(1).subsetOf(foo(0)))
      .length

  def part2(input: String): Int =
    parse(input)
      .filter(foo => !foo(0).intersect(foo(1)).isEmpty)
      .length

  def main(args: Array[String]): Unit =
    val data = io.Source.fromResource("AdventOfCode2022/Day04.txt").mkString
    println(part1(data))
    println(part2(data))
