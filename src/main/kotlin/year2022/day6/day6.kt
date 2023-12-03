package year2022.day6

val testInput = """
    mjqjpqmgbljsphdztnvjfqwrcgsmlb
    bvwbjplbgvbhsrlpgdmjqwftvncz
    nppdvjthqldpwncqszvftbrmjlhg
    nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg
    zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw
""".trimIndent()


fun part1(input: String) {
    for (line in input.lines()) {
        for ((index, str) in line.windowed(4).withIndex()) {
            val dupeChecker = HashSet<Char>()
            var counter = 0

            for (char in str) {
                if (dupeChecker.contains(char)) {
                    counter = 0
                    break
                }
                dupeChecker.add(char)
                counter++
            }
            if (counter == 4) {
                println("$line : starts at ${index + 4}")
                break
            }
        }
    }
}

fun part2(input: String) {
    for (line in input.lines()) {
        for ((index, str) in line.windowed(14).withIndex()) {
            val dupeChecker = HashSet<Char>()
            var counter = 0

            for (char in str) {
                if (dupeChecker.contains(char)) {
                    counter = 0
                    break
                }
                dupeChecker.add(char)
                counter++
            }
            if (counter == 14) {
                println("$line : starts at ${index + 14}")
                break
            }
        }
    }
}

fun main(args: Array<String>) {
    part2(puzzleInput)
}