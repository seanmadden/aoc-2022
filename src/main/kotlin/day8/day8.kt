package day8

import kotlin.math.max

val testInput = """
    30373
    25512
    65332
    33549
    35390
""".trimIndent()

fun isVisibleFromTop(input: String, row: Int, column: Int): Boolean {
    if (row == 0) return true
    if (row == input.lines().size - 1) return true
    if (column == 0) return true
    if (column == input.lines()[0].length - 1) return true

    val value = input.lines()[row][column]
    var rowCounter = row - 1

    do {
        val valueAbove = input.lines()[rowCounter][column]
        if (value <= valueAbove) {
            return false
        }
        rowCounter--
    } while (rowCounter >= 0)

    return true
}

fun isVisibleFromBottom(input: String, row: Int, column: Int): Boolean {
    if (row == 0) return true
    if (row == input.lines().size - 1) return true
    if (column == 0) return true
    if (column == input.lines()[0].length - 1) return true

    val value = input.lines()[row][column]
    var rowCounter = row + 1

    do {
        val valueBelow = input.lines()[rowCounter][column]
        if (value <= valueBelow) {
            return false
        }
        rowCounter++
    } while (rowCounter <= input.lines().size - 1)

    return true
}

fun isVisibleFromLeft(input: String, row: Int, column: Int): Boolean {
    if (row == 0) return true
    if (row == input.lines().size - 1) return true
    if (column == 0) return true
    if (column == input.lines()[0].length - 1) return true

    val value = input.lines()[row][column]
    var colCounter = column - 1

    do {
        val valueBelow = input.lines()[row][colCounter]
        if (value <= valueBelow) {
            return false
        }
        colCounter--
    } while (colCounter >= 0)

    return true
}

fun isVisibleFromRight(input: String, row: Int, column: Int): Boolean {
    if (row == 0) return true
    if (row == input.lines().size - 1) return true
    if (column == 0) return true
    if (column == input.lines()[0].length - 1) return true

    val value = input.lines()[row][column]
    var colCounter = column + 1

    do {
        val valueBelow = input.lines()[row][colCounter]
        if (value <= valueBelow) {
            return false
        }
        colCounter++
    } while (colCounter <= input.lines()[0].length - 1)

    return true
}


fun part1(input: String) {

    // init all trees as visible
    var matrix = Array(input.lines().size) { CharArray(input.lines()[0].length) { 'T' } }

    for ((index, line) in input.lines().withIndex()) {
        for ((charIndex, char) in line.withIndex()) {
            if (matrix[index][charIndex] == 'F') {
                continue
            }
            // visibility from any of the 4 directions will leave the tree as visible
            val topViz = isVisibleFromTop(input, index, charIndex)
            val bottomViz = isVisibleFromBottom(input, index, charIndex)
            val leftViz = isVisibleFromLeft(input, index, charIndex)
            val rightViz = isVisibleFromRight(input, index, charIndex)
//            println("top viz is $topViz")

            if (!topViz && !bottomViz && !leftViz && !rightViz) {
                matrix[index][charIndex] = 'F'
            }

        }

    }

    var visibleCount = 0

    for (line in matrix) {
        println(line)
        for (char in line) {
            if (char == 'T') {
                visibleCount++
            }
        }
    }

    println("Trees visible $visibleCount")

}

fun getViewingScore(flag: Int, matrix: List<String>, startingRow: Int, startingCol: Int, dx: Int, dy: Int): Int {

    val nextRow = startingRow + dx
    val nextCol = startingCol + dy

    // bounds checking
    if (nextRow < 0 || nextRow >= matrix.size) {
        return 0
    }

    if (nextCol < 0 || nextCol >= matrix[0].length) {
        return 0
    }

    if (matrix[nextRow][nextCol].digitToInt() < flag) {
        return 1 + getViewingScore(flag, matrix, nextRow, nextCol, dx, dy)
    }

    return 1
}

fun part2(input: String) {
    val matrix = input.lines()
    var maxScore = 0

    for ((rowIndex, row) in matrix.withIndex()) {
        for ((colIndex, column) in row.withIndex()) {
            val flag = matrix[rowIndex][colIndex].digitToInt()

            val scoreUp = getViewingScore(flag, matrix, rowIndex, colIndex, -1, 0)
            val scoreDown = getViewingScore(flag, matrix, rowIndex, colIndex, 1, 0)
            val scoreLeft = getViewingScore(flag, matrix, rowIndex, colIndex, 0, -1)
            val scoreRight = getViewingScore(flag, matrix, rowIndex, colIndex, 0, 1)

            val scenicScore = (scoreUp * scoreDown * scoreLeft * scoreRight)

            print(scenicScore)
            maxScore = max(maxScore, scenicScore)
        }
        println()
    }
    println("max scenic score ${maxScore}")
}

fun main(args: Array<String>) {
    part2(puzzleInput)
}