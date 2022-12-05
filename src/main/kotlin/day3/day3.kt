package day3

import java.lang.Exception

val testInput = """
    vJrwpWtwJgWrhcsFMMfFFhFp
    jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
    PmmdzqPrVvPwwTWBwg
    wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
    ttgJtRGJQctTZtZT
    CrZsJsPPZsGzwwsLwLmpwMDw
""".trimIndent()

class Rucksack(contents: String) {

    private lateinit var compartment1: String
    private lateinit var compartment2: String

    init {
        val splitInput = contents.length / 2
        compartment1 = contents.substring(0, splitInput)
        compartment2 = contents.substring(splitInput)

//        println("Input: $contents | C1: $compartment1 | C2: $compartment2")
    }

    fun findIntersection(): HashSet<Char> {
        val set = HashSet<Char>()
        val overlap = HashSet<Char>()

        for (char in compartment1) {
            set.add(char)
        }

        for (char in compartment2) {
            if (set.contains(char)) {
                overlap.add(char)
            }
        }

        return overlap
    }
}

class ItemPrioritizer() {

    private val itemList = mutableListOf<Char>()

    init {
        for (c in 'a'.rangeTo('z')) {
            itemList.add(c)
        }
        for (c in 'A'.rangeTo('Z')) {
            itemList.add(c)
        }
    }

    fun getPriority(char: Char): Int {
        return (itemList.indexOf(char) + 1)
    }

}

fun part1() {
    val itemPrioritizer = ItemPrioritizer()
    var sum = 0

    for (line in puzzleInput.lines()) {
        val sack = Rucksack(line)
        sum += sack.findIntersection().sumOf {
            itemPrioritizer.getPriority(it)
        }
    }

    println(sum)
}

fun appearsInAllThree(str1: String, str2: String, str3: String): Char {
    val set = HashSet<Char>()
    val set2 = HashSet<Char>()

    for (c in str1) {
        set.add(c)
    }

    for (c in str2) {
        if (set.contains(c)) {
            set2.add(c)
        }
    }

    for (c in str3) {
        if (set2.contains(c)) {
            return c
        }
    }

    throw Exception()
}

fun part2() {
    val itemPrioritizer = ItemPrioritizer()
    var sum = 0

    for (lineList in puzzleInput.lines().windowed(3, 3)) {
        sum += itemPrioritizer.getPriority(appearsInAllThree(lineList[0], lineList[1], lineList[2]))
    }

    println(sum)
}

fun main(args: Array<String>) {
    part2()
}
