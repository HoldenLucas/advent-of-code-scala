package AdventOfCode2022

object Day02:

  val ROCK = 1
  val PAPER = 2
  val SCISSORS = 3

  val LOSE = 1
  val DRAW = 2
  val WIN = 3

  def parse(input: String): Seq[(Int, Int)] =
    input
      .split("\n")
      .map(_.split(" "))
      .map(Tuple.fromArray)
      .map(x => {
        val (theirs, mine) = x
        (
          (theirs match
            case "A" => ROCK
            case "B" => PAPER
            case "C" => SCISSORS
          ),
          (mine match
            case "X" => ROCK
            case "Y" => PAPER
            case "Z" => SCISSORS
          )
        )
      })

  def part1(input: String): Int =
    parse(input)
      .map((theirs, mine) => {
        val bonus = mine match
          case tie if mine == theirs => 3
          case ROCK => {
            theirs match
              case PAPER    => 0
              case SCISSORS => 6
          }
          case PAPER => {
            theirs match
              case SCISSORS => 0
              case ROCK     => 6
          }
          case SCISSORS => {
            theirs match
              case ROCK  => 0
              case PAPER => 6
          }

        mine + bonus
      })
      .sum

  def part2(input: String): Int =
    parse(input)
      .map((theirs, mine) => {
        mine match
          case LOSE => {
            theirs match
              case ROCK     => SCISSORS
              case PAPER    => ROCK
              case SCISSORS => PAPER
          }
          case DRAW => theirs + 3
          case WIN => {
            theirs match
              case ROCK     => PAPER + 6
              case PAPER    => SCISSORS + 6
              case SCISSORS => ROCK + 6
          }
      })
      .sum

  def main(args: Array[String]): Unit =
    val data =
      io.Source.fromResource("AdventOfCode2022/Day02.txt").mkString

    println(part1(data))
    println(part2(data))
