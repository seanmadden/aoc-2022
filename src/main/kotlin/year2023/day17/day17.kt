//package year2023.day17
//
//import Direction
//import java.awt.Point
//
//val testInput = """
//    2413432311323
//    3215453535623
//    3255245654254
//    3446585845452
//    4546657867536
//    1438598798454
//    4457876987766
//    3637877979653
//    4654967986887
//    4564679986453
//    1224686865563
//    2546548887735
//    4322674655533
//""".trimIndent()
//
//val puzzleInput = """
//""".trimIndent()
//
//val part2TestInput = """
//""".trimIndent()
//
//val test2Input = """
//""".trimIndent()
//
//fun part1() {
//}
//
//fun part2(values: List<Long>) {
//}
//
//data class Crucible(
//    val direction: Direction?,
//    val timesMovedForward: Int,
//    val x: Int,
//    val y: Int
//)
//
//fun heatLostToEnd(crucible: Crucible, end: Point, grid: List<String>): Int {
//    if (crucible.x == 0 && crucible.y == 0 && crucible.timesMovedForward == 0) {
//        // Very first move
//
//
//    }
//
//    if (crucible.x == end.x && crucible.y == end.y) {
//        return grid[end.x][end.y].digitToInt()
//    }
//
//    val possibleExits = mutableSetOf<Direction>()
//
//    if (crucible.timesMovedForward == 3) {
//        // we can't move forward again
//    }
//
//}
//
//fun main(args: Array<String>) {
//    val startTime = System.currentTimeMillis()
//
//    val input = testInput.lines()
//
//    val start = Point(0, 0)
//    val end = Point(input.size, input[input.size - 1].length)
//
//    val eastCrucible = Crucible(Direction.EAST, 0, 0, 0)
//    val southCrucible = Crucible(Direction.SOUTH, 0, 0, 0)
//
//
//    val endTime = System.currentTimeMillis()
//    println("millis elapsed ${endTime - startTime}")
//}
