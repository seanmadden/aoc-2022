package year2024.day9

val testInput = """
    2333133121414131402
""".trimIndent()

fun part1(mapping: List<Int>) {
    val defragedMapping = mapping.toMutableList()
    var indexToMove = defragedMapping.indexOfLast { it != -1 }
    var destination = defragedMapping.indexOfFirst { it == -1 }

    do {
        defragedMapping[destination] = defragedMapping[indexToMove]
        defragedMapping[indexToMove] = -1

        indexToMove = defragedMapping.indexOfLast { it != -1 }
        destination = defragedMapping.indexOfFirst { it == -1 }
    } while (indexToMove > destination)

    println(defragedMapping)
    val sum = defragedMapping.mapIndexed { index, i ->
        if (i == -1) 0 else (i * index).toLong()
    }.sum()
    println("Checksum is $sum")
}

fun findFreeSpace(memory: List<Int>): Pair<Int, Int> {
    var openStart = memory.indexOfFirst { it == -1 }
    var openSize = memory.subList(openStart, memory.size).takeWhile { it == -1 }

    return Pair(openStart, openSize.size)
}

fun part2(mapping: List<Int>) {
    val defragedMapping = mapping.toMutableList()

    var lastFileNumIndex = defragedMapping.indexOfLast { it != 1 }
    var lengthToMove = defragedMapping.takeLastWhile { it == defragedMapping[lastFileNumIndex] }

    var openStart = defragedMapping.indexOfFirst { it == -1 }
    var openSize = defragedMapping.subList(openStart, defragedMapping.size).takeWhile { it == -1 }

    do {
        println("Size of input to move: ${lengthToMove.size}")
        println("Free space starts at index $openStart and has ${openSize.size} spaces")

        if (lengthToMove.size <= openSize.size) {
            //move it
            for (i in openStart until openStart + lengthToMove.size) {
                defragedMapping[i] = defragedMapping[lastFileNumIndex]
            }
            for (i in lastFileNumIndex-lengthToMove.size+1..lastFileNumIndex) {
                defragedMapping[i] = -1
            }
        } else {
            // try to find different spot
        }
    } while (lastFileNumIndex > openStart)
//    var indexToMove = defragedMapping.indexOfLast { it != -1 }
//    var destination = defragedMapping.indexOfFirst { it == -1 }
//
//    do {
//        defragedMapping[destination] = defragedMapping[indexToMove]
//        defragedMapping[indexToMove] = -1
//
//        indexToMove = defragedMapping.indexOfLast { it != -1 }
//        destination = defragedMapping.indexOfFirst { it == -1 }
//    } while (indexToMove > destination)
//
    println(defragedMapping)
//    val sum = defragedMapping.mapIndexed { index, i ->
//        if (i == -1) 0 else (i * index).toLong()
//    }.sum()
//    println("Checksum is $sum")
}

fun main(args: Array<String>) {
    var fileBlock = true
    var fileId = 0

    val mapping = mutableListOf<Int>()

    for (char in testInput.lines()[0]) {
        for (i in 1..char.digitToInt()) {
            mapping.add(if (fileBlock) fileId else -1)
        }
        if (fileBlock) {
            fileId++
        }
        fileBlock = !fileBlock
    }

    println(mapping)
    part2(mapping)
}
