package year2024.day4

import kotlin.system.exitProcess

val testInput = """
    MMMSXXMASM
    MSAMXMSMSA
    AMXSXMAAMM
    MSAMASMSMX
    XMASAMXAMM
    XXAMMXXAMA
    SMSMSASXSS
    SAXAMASAAA
    MAMMMXMMMM
    MXMXAXMASX
""".trimIndent()

enum class Direction {
    NORTH,
    NORTHEAST,
    EAST,
    SOUTHEAST,
    SOUTH,
    SOUTHWEST,
    WEST,
    NORTHWEST
}

class Cell(val letter: Char) {
    val exits = mutableMapOf<Direction, Cell>()

    fun addExit(direction: Direction, cell: Cell) {
        if (exits.contains(direction)) {
            error("Exit already exists, this shouldn't happen!")
            exitProcess(1)
        }

        exits.put(direction, cell)
    }

    fun traverse(direction: Direction): Cell {
        return exits[direction] ?: Cell('.')
    }

    fun canGetToXmasByDirection(): Int {
        var count = 0
        if (letter == 'X') {
            for (entry in exits) {
                if (entry.value.letter == 'M') {
                    val nextLetter = entry.value.traverse(entry.key)
                    if (nextLetter.letter == 'A') {
                        val nextLetter = nextLetter.traverse(entry.key)
                        if (nextLetter.letter == 'S') {
                            count++
                        }
                    }
                }
            }
        }
        return count
    }

    fun canGetXCross(): Boolean {
        if (letter == 'A') {
            val exitLetter = "" + traverse(Direction.NORTHWEST).letter +
                    letter +
                    traverse(Direction.SOUTHEAST).letter +
                    traverse(Direction.SOUTHWEST).letter +
                    letter +
                    traverse(Direction.NORTHEAST).letter
            val firstHalf = exitLetter.substring(0, 3)
            val secondHalf = exitLetter.substring(3, 6)
            if ((firstHalf == "MAS" || firstHalf == "SAM") && (secondHalf == "MAS" || secondHalf == "SAM")) {
                return true
            }
        }
        return false
    }

    override fun toString(): String {
        return letter.toString()
    }
}

fun part1(cells: List<List<Cell>>) {
    var count = 0
    for (row in cells) {
        for (cell in row) {
            count += cell.canGetToXmasByDirection()
        }
    }
    println("$count ways to get xmas in grid")
}

fun part2(cells: List<List<Cell>>) {
    var count = 0
    for (row in cells) {
        for (cell in row) {
            count += if (cell.canGetXCross()) 1 else 0
        }
    }
    println("$count ways to get xmas in grid")
}

fun main(args: Array<String>) {
    val board = puzzleInput.lines()

    val cells = mutableListOf<MutableList<Cell>>()

    board.forEachIndexed { rowIndex, row ->
        val cellsInRow = mutableListOf<Cell>()
        row.forEachIndexed { colIndex, letter ->
            val c = Cell(letter)
            cellsInRow.add(c)
        }
        cells.add(cellsInRow)
    }

    board.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { colIndex, letter ->
            val c = cells[rowIndex][colIndex]

            val westColValid = (colIndex - 1 >= 0)
            val eastColValid = (colIndex + 1 < cells[0].size)
            val northColValid = (rowIndex - 1 >= 0)
            val southColValid = (rowIndex + 1 < cells.size)

            if (northColValid) {
                // Add the cells to the north
                c.addExit(Direction.NORTH, cells[rowIndex - 1][colIndex])
                if (eastColValid) {
                    c.addExit(Direction.NORTHEAST, cells[rowIndex - 1][colIndex + 1])
                }
                if (westColValid) {
                    c.addExit(Direction.NORTHWEST, cells[rowIndex - 1][colIndex - 1])
                }
            }
            if (westColValid) {
                c.addExit(Direction.WEST, cells[rowIndex][colIndex - 1])
            }
            if (eastColValid) {
                c.addExit(Direction.EAST, cells[rowIndex][colIndex + 1])
            }
            if (southColValid) {
                c.addExit(Direction.SOUTH, cells[rowIndex + 1][colIndex])
                if (eastColValid) {
                    c.addExit(Direction.SOUTHEAST, cells[rowIndex + 1][colIndex + 1])
                }
                if (westColValid) {
                    c.addExit(Direction.SOUTHWEST, cells[rowIndex + 1][colIndex - 1])
                }
            }
        }
    }

    for (row in cells) {
        for (cell in row) {
            print(cell)
        }
        println()
    }

    part2(cells)
}
