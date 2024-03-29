package year2022.day11

val puzzleInput = """
    Monkey 0:
      Starting items: 99, 63, 76, 93, 54, 73
      Operation: new = old * 11
      Test: divisible by 2
        If true: throw to monkey 7
        If false: throw to monkey 1

    Monkey 1:
      Starting items: 91, 60, 97, 54
      Operation: new = old + 1
      Test: divisible by 17
        If true: throw to monkey 3
        If false: throw to monkey 2

    Monkey 2:
      Starting items: 65
      Operation: new = old + 7
      Test: divisible by 7
        If true: throw to monkey 6
        If false: throw to monkey 5

    Monkey 3:
      Starting items: 84, 55
      Operation: new = old + 3
      Test: divisible by 11
        If true: throw to monkey 2
        If false: throw to monkey 6

    Monkey 4:
      Starting items: 86, 63, 79, 54, 83
      Operation: new = old * old
      Test: divisible by 19
        If true: throw to monkey 7
        If false: throw to monkey 0

    Monkey 5:
      Starting items: 96, 67, 56, 95, 64, 69, 96
      Operation: new = old + 4
      Test: divisible by 5
        If true: throw to monkey 4
        If false: throw to monkey 0

    Monkey 6:
      Starting items: 66, 94, 70, 93, 72, 67, 88, 51
      Operation: new = old * 5
      Test: divisible by 13
        If true: throw to monkey 4
        If false: throw to monkey 5

    Monkey 7:
      Starting items: 59, 59, 74
      Operation: new = old + 8
      Test: divisible by 3
        If true: throw to monkey 1
        If false: throw to monkey 3
""".trimIndent()