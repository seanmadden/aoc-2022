package lib

import kotlin.system.exitProcess

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

class Cell(var letter: Char) {
    val exits = mutableMapOf<Direction, Cell>()

    fun addExit(direction: Direction, cell: Cell) {
        if (exits.contains(direction)) {
            error("Exit already exists, this shouldn't happen!")
            exitProcess(1)
        }

        exits.put(direction, cell)
    }

    fun traverse(direction: Direction): Cell {
        return exits[direction] ?: Cell(' ')
    }

    override fun toString(): String {
        return letter.toString()
    }
}
