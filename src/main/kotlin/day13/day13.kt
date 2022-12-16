package day13

val testInput = """
    [1,1,3,1,1]
    [1,1,5,1,1]

    [[1],[2,3,4]]
    [[1],4]

    [9]
    [[8,7,6]]

    [[4,4],4,4]
    [[4,4],4,4,4]

    [7,7,7,7]
    [7,7,7]

    []
    [3]

    [[[]]]
    [[]]

    [1,[2,[3,[4,[5,6,7]]]],8,9]
    [1,[2,[3,[4,[5,6,0]]]],8,9]
""".trimIndent()

class PacketData(val nodeValue: Int? = null, val parent: PacketData? = null) {
    private var nodeData: MutableList<PacketData>? = null

    // True if the nodes are in the right order, otherwise false
    fun compareTo(rightPacket: PacketData, depth: Int = 0): Boolean {
        println("${"\t".repeat(depth)}Comparing $this vs ${rightPacket}")

        if (nodeValue != null && rightPacket.nodeValue != null) {
            if (nodeValue < rightPacket.nodeValue) return true
            if (nodeValue == rightPacket.nodeValue) return true
            if (nodeValue > rightPacket.nodeValue) return false
        }


        if (nodeData != null && rightPacket.nodeData != null) {
//            println("Comparing $nodeData to ${rightPacket.nodeData}")
            return List(nodeData!!.size) { index ->
                if (index >= rightPacket.nodeData!!.size) return false
                nodeData!![index].compareTo(rightPacket.nodeData!![index], depth + 1)
            }
                .reduce { acc, b -> acc && b }
        }

        //if left is list and right is data
        if (nodeData != null && rightPacket.nodeValue != null) {
            return nodeData!![0].compareTo(rightPacket, depth + 1)
            // right side ran out of items, not in correct order
//            return false
        }

        //if right is list and left is data
        if (nodeValue != null && rightPacket.nodeData != null) {
            // Only have to compare the first element (if left runs out, inputs are in correct order)
            return compareTo(rightPacket.nodeData!![0], depth + 1)
        }

        if ((nodeValue != null || nodeData != null) && rightPacket.nodeValue == null) {
//             Right side ran out, so no go
            return false
        }

        if ((rightPacket.nodeValue != null || rightPacket.nodeData != null) && nodeValue == null) {
            // Left side ran out
            return true
        }

        if (rightPacket.nodeValue == null) {
            return false
        }

        return false
    }

    override fun toString(): String {
        val builder = StringBuilder()

        if (nodeValue != null) {
            return nodeValue.toString()
        } else if (nodeData != null) {
            builder.append("[")
            for (node in nodeData!!) {
                builder.append(node)
                    .append(", ")
            }
            builder.append("]")
            return builder.toString()
        }

        return "<No packet data>"
    }

    fun addValue(value: Int) {
        if (nodeValue != null) {
            throw RuntimeException("Packet data cannot have a node value and a list of values!")
        }
        if (nodeData == null) {
            nodeData = mutableListOf(PacketData(value))
        } else if (nodeData != null) {
            nodeData!!.add(PacketData(value))
        }
    }

    fun addValue(packetData: PacketData) {
        if (nodeData == null) {
            nodeData = mutableListOf(packetData)
        } else {
            nodeData!!.add(packetData)
        }

    }
}

fun parseLists(line: String): PacketData {
    val iterator = line.iterator()

    // every packet is a list
    val topPacket = PacketData()

    iterator.next() // The first [
    var listsDeep = 0
    var closestPacketData = topPacket

    while (iterator.hasNext()) {
        var char = iterator.nextChar()
        val digitBuilder = StringBuilder()

        while (char.isDigit()) {
            digitBuilder.append(char)
            char = iterator.nextChar()
        }

//        if (char == ',') continue

        if (char == '[') {
            val newPacketData = PacketData(parent = closestPacketData)
            closestPacketData.addValue(newPacketData)
            closestPacketData = newPacketData
//            closestPacketData.add(newClosestList)
//            listsDeep++

        }

        if (digitBuilder.isNotBlank()) {
            closestPacketData.addValue(digitBuilder.toString().toInt())
        }

        if (char == ']') {
            if (closestPacketData.parent == null) {
//                println("End of the packet")
                continue
            }

            closestPacketData = closestPacketData.parent!!
        }


    }

    return topPacket

//    println(line.split("]"))
//    println(line.split(","))
//    val parsedLine = listOf<Any>()

//    var workingList = mutableListOf<Int>()

//    for (char in line) {
//        if (char == '[') {
//            workingList = mutableListOf()
//            continue
//        }

//        workingList.add(char.digitToInt())
//    }
}

fun main(args: Array<String>) {
    val iterator = puzzleInput.lines().iterator()

    var left = iterator.next()
    var right = iterator.next()

    var indexCounter = 1
    val correctOrder = mutableListOf<Int>()

    do {

        val leftPacket = parseLists(left)
        val rightPacket = parseLists(right)

        println()
        println("== Pair $indexCounter ==")
        val comparison = leftPacket.compareTo(rightPacket)

        println("Comparing left to right: ${comparison}")
        if (comparison) {
            correctOrder.add(indexCounter)
        }

        val blankSpace = iterator.next()
        left = iterator.next()
        right = iterator.next()
        indexCounter++
    } while (iterator.hasNext())

    val leftPacket = parseLists(left)
    val rightPacket = parseLists(right)

    val comparison = leftPacket.compareTo(rightPacket)
    println("Comparing left to right: ${comparison}")

    println("Pairs in correct order: ${correctOrder}, sum is ${correctOrder.sum()}")
}