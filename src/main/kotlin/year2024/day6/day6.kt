package year2024.day6

import lib.Cell
import lib.Direction
import kotlin.system.exitProcess

val testInput = """
    ....#.....
    .........#
    ..........
    ..#.......
    .......#..
    ..........
    .#..^.....
    ........#.
    #.........
    ......#...
""".trimIndent()

fun Cell.lookForward(): Cell {
    val directionToLook = if (letter == '^') {
        Direction.NORTH
    } else if (letter == 'v') {
        Direction.SOUTH
    } else if (letter == '>') {
        Direction.EAST
    } else if (letter == '<') {
        Direction.WEST
    } else {
        error("Invalid cell. Can't look forward.")
        exitProcess(1)
    }

    return traverse(directionToLook)
}

fun Cell.rotate90() {
    if (letter == '^') {
        letter = '>'
    } else if (letter == 'v') {
        letter = '<'
    } else if (letter == '>') {
        letter = 'v'
    } else if (letter == '<') {
        letter = '^'
    }
}

fun part1(startingCell: Cell) {
    var currentCell = startingCell
    val visitedCells = mutableSetOf(startingCell)

    while (currentCell.letter != ' ') {
        if (currentCell.lookForward().letter == ' ') {
            // If forward is the void, stop
            break
        }
        if (currentCell.lookForward().letter != '#') {
            val nextCell = currentCell.lookForward()
            val currentDirection = currentCell.letter

            currentCell.letter = '.'
            nextCell.letter = currentDirection

            currentCell = nextCell
            visitedCells.add(currentCell)
        } else {
            currentCell.rotate90()
        }
    }
    println("Visited ${visitedCells.size} unique cells")
}

fun part2() {
}

fun main(args: Array<String>) {
    val board = puzzleInput.lines()

    val cells = mutableListOf<MutableList<Cell>>()
    var startingCell = Cell('.')

    board.forEachIndexed { rowIndex, row ->
        val cellsInRow = mutableListOf<Cell>()
        row.forEachIndexed { colIndex, letter ->
            val c = Cell(letter)
            cellsInRow.add(c)
            if (letter == '^') startingCell = c
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
            }
            if (westColValid) {
                c.addExit(Direction.WEST, cells[rowIndex][colIndex - 1])
            }
            if (eastColValid) {
                c.addExit(Direction.EAST, cells[rowIndex][colIndex + 1])
            }
            if (southColValid) {
                c.addExit(Direction.SOUTH, cells[rowIndex + 1][colIndex])
            }
        }
    }

    for (row in cells) {
        for (cell in row) {
            print(cell)
        }
        println()
    }

    part1(startingCell)
}
