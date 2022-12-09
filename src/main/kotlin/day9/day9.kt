package day9

import kotlin.math.abs

val testInput = """
    R 4
    U 4
    L 3
    D 1
    R 4
    D 1
    L 5
    R 2
""".trimIndent()

val testInput2 = """
    R 5
    U 8
    L 8
    D 3
    R 17
    D 10
    L 25
    U 20
""".trimIndent()

class Landscape(private val sizeOfEntireSnake: Int = 2) {
    private val tailVisited = HashSet<Pair<Int, Int>>()

//    var headPosition = Pair(0, 0)
    val tails = mutableListOf<Pair<Int, Int>>()

//    var tailPosition = Pair(0, 0)

    init {
        tailVisited.add(Pair(0, 0))

        for (i in 0 until sizeOfEntireSnake) {
            tails.add(Pair(0, 0))
        }
    }

    fun getVisitedCount(): Int {
        return tailVisited.size
    }

    fun moveHead(direction: String) {
        when (direction) {
            "U" -> {
                tails[0] = Pair(tails[0].first - 1, tails[0].second)
            }
            "D" -> {
                tails[0] = Pair(tails[0].first + 1, tails[0].second)
            }
            "L" -> {
                tails[0] = Pair(tails[0].first, tails[0].second - 1)
            }
            "R" -> {
                tails[0] = Pair(tails[0].first, tails[0].second + 1)
            }
        }

        checkTailRecursive()
    }

    private fun checkTailRecursive(tailStart: Int = 0) {
        if (tailStart == sizeOfEntireSnake - 1) {
            return
        }

        val head = tails[tailStart]
        var theTail = tails[tailStart + 1]

        val xDistance = abs(head.first - theTail.first)
        val yDistance = abs(head.second - theTail.second)

        if (xDistance + yDistance >= 3) {
            // move diagonally
            theTail = if (head.first - theTail.first > 0) {
                //move down
                Pair(theTail.first + 1, theTail.second)
            } else {
                //move up
                Pair(theTail.first - 1, theTail.second)
            }
            theTail = if (head.second - theTail.second > 0) {
                // move right
                Pair(theTail.first, theTail.second + 1)
            } else {
                //move left
                Pair(theTail.first, theTail.second - 1)
            }
            if (tailStart + 1 == sizeOfEntireSnake - 1) {
                tailVisited.add(theTail)
            }
        } else if (xDistance > 1) {
            // move in the x direction
            theTail = if (head.first - theTail.first > 0) {
                //move down
                Pair(theTail.first + 1, theTail.second)
            } else {
                //move up
                Pair(theTail.first - 1, theTail.second)
            }
            if (tailStart + 1 == sizeOfEntireSnake - 1) {
                tailVisited.add(theTail)
            }
        } else if (yDistance > 1) {
            // move in the y direction
            theTail = if (tails[0].second - theTail.second > 0) {
                // move right
                Pair(theTail.first, theTail.second + 1)
            } else {
                //move left
                Pair(theTail.first, theTail.second - 1)
            }
            if (tailStart + 1 == sizeOfEntireSnake - 1) {
                tailVisited.add(theTail)
            }
        }

        tails[tailStart + 1] = theTail

        checkTailRecursive(tailStart + 1)
    }

//    private fun checkTail() {
//        val xDistance = abs(headPosition.first - tailPosition.first)
//        val yDistance = abs(headPosition.second - tailPosition.second)
//
//        if (xDistance + yDistance >= 3) {
//            // move diagonally
//            tailPosition = if (headPosition.first - tailPosition.first > 0) {
//                //move down
//                Pair(tailPosition.first + 1, tailPosition.second)
//            } else {
//                //move up
//                Pair(tailPosition.first - 1, tailPosition.second)
//            }
//            tailPosition = if (headPosition.second - tailPosition.second > 0) {
//                // move right
//                Pair(tailPosition.first, tailPosition.second + 1)
//            } else {
//                //move left
//                Pair(tailPosition.first, tailPosition.second - 1)
//            }
//            tailVisited.add(tailPosition)
//        } else if (xDistance > 1) {
//            // move in the x direction
//            tailPosition = if (headPosition.first - tailPosition.first > 0) {
//                //move down
//                Pair(tailPosition.first + 1, tailPosition.second)
//            } else {
//                //move up
//                Pair(tailPosition.first - 1, tailPosition.second)
//            }
//            tailVisited.add(tailPosition)
//        } else if (yDistance > 1) {
//            // move in the y direction
//            tailPosition = if (headPosition.second - tailPosition.second > 0) {
//                // move right
//                Pair(tailPosition.first, tailPosition.second + 1)
//            } else {
//                //move left
//                Pair(tailPosition.first, tailPosition.second - 1)
//            }
//            tailVisited.add(tailPosition)
//        }

//    }

}

fun main(args: Array<String>) {

    val landscape = Landscape(10)

    for (line in puzzleInput.lines()) {
        val instruction = line.split(" ")

        var remainingMoves = instruction[1].toInt()

        while (remainingMoves > 0) {
            landscape.moveHead(instruction[0])

            remainingMoves--
        }

    }

    //5930
    println(landscape.getVisitedCount())
}