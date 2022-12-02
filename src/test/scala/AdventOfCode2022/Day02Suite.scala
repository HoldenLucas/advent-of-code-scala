package AdventOfCode2022

import org.scalatest.funsuite.AnyFunSuite

class Day02Suite extends AnyFunSuite:
  val sample = """
    |A Y
    |B X
    |C Z
  """.stripMargin.trim

  test("Part 1 should handle sample input correctly") {
    assert(Day02.part1(sample) == 15)
  }

  test("Part 1 Extended") {
    assert(Day02.part1("A X") == 4)
    assert(Day02.part1("A Y") == 8)
    assert(Day02.part1("A Z") == 3)
    assert(Day02.part1("B X") == 1)
    assert(Day02.part1("B Y") == 5)
    assert(Day02.part1("B Z") == 9)
    assert(Day02.part1("C X") == 7)
    assert(Day02.part1("C Y") == 2)
    assert(Day02.part1("C Z") == 6)
  }

  test("Part 2 should handle sample input correctly") {
    assert(Day02.part2(sample) == 12)
  }
