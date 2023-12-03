package year2022.day5

import java.util.*

val testInput = """
    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2
""".trimIndent()

val COLUMN_STEP = 4
val STARTING_COLUMN = 1

class Shipyard(val crateStack: List<Stack<Char>>, private val instructions: List<String>) {

    fun followInstructions() {
        for (instruction in instructions) {
            val splitInput = instruction.split(" ")
            // 1, 3, 5 should correspond to # crates, FROM, TO
            val cratesToMove = splitInput[1].toInt()
            val from = splitInput[3].toInt() - 1
            val to = splitInput[5].toInt() - 1

            for (i in 1..cratesToMove) {
                val movedCrate = crateStack[from].pop()
                crateStack[to].push(movedCrate)
            }

        }
    }

    fun followInstructions9001() {
        for (instruction in instructions) {
            val splitInput = instruction.split(" ")
            // 1, 3, 5 should correspond to # crates, FROM, TO
            val cratesToMove = splitInput[1].toInt()
            val from = splitInput[3].toInt() - 1
            val to = splitInput[5].toInt() - 1

            val tempStack = Stack<Char>()
            for (i in 1..cratesToMove) {
                val movedCrate = crateStack[from].pop()
                tempStack.push(movedCrate)
            }
            for (i in 1..cratesToMove) {
                crateStack[to].push(tempStack.pop())
            }
        }
    }

    fun topOfEachStack(): String {
        val returnValue = StringBuilder()
        for (stack in crateStack) {
            returnValue.append(stack.peek())
        }

        return returnValue.toString()
    }
}

fun parseInput(input: String): Shipyard {
    var tophalf = true
    val top = mutableListOf<String>()
    val bottom = mutableListOf<String>()

    for (line in input.lines()) {
        if (line.isBlank()) {
            tophalf = false
            continue
        }

        when (tophalf) {
            true -> {
                top.add(line)
            }
            false -> {
                bottom.add(line)
            }
        }
    }

    // now parse out the stacks
    val numberOfStacks = top.last().split("   ").last().trim().toInt()
//    println(top)
//    println(numberOfStacks)

    val startingStacks = mutableListOf<Stack<Char>>()

    for (i in 0 until numberOfStacks) {
        val currentStack = Stack<Char>()
        val crates = StringBuilder()

        for (line in top) {
            val crate = line[(COLUMN_STEP * i) + STARTING_COLUMN]
            if (crate.isDigit() || crate.isWhitespace()) {
                // bottom of the row or no crate here
                continue
            }
            // top to bottom
            crates.append(crate)
        }

        for (crate in crates.reverse()) {
            currentStack.push(crate)
        }

        startingStacks.add(currentStack)
    }

    return Shipyard(startingStacks, bottom)
}

fun main(args: Array<String>) {
    val shipyard = parseInput(puzzleInput)
    shipyard.followInstructions9001()
    println(shipyard.topOfEachStack())
}