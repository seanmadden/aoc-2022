package year2022.day13

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

enum class ListOrder {
    CORRECT,
    INCORRECT,
    UNKNOWN
}

class PacketValue(val value: Int) : PacketData()

class PacketList(val list: MutableList<PacketData> = mutableListOf(), parent: PacketData? = null) :
    PacketData(parent) {

    fun addValue(packetData: PacketData) {
        list.add(packetData)
    }
}

abstract class PacketData(val parent: PacketData? = null) {

    // True if the nodes are in the right order, otherwise false
    fun compareTo(rightPacket: PacketData, depth: Int = 0): ListOrder {
//        println("${"\t".repeat(depth)}Comparing $this vs ${rightPacket}")

        if (this is PacketValue && rightPacket is PacketValue) {
            if (value < rightPacket.value) return ListOrder.CORRECT
            if (value > rightPacket.value) return ListOrder.INCORRECT
            if (value == rightPacket.value) ListOrder.UNKNOWN
        }

//        if (this is PacketList && this.list.isEmpty()) return ListOrder.CORRECT

        if (this is PacketList && rightPacket is PacketList) {

            list.mapIndexed { index, packetData ->
                if (index >= rightPacket.list.size) return ListOrder.INCORRECT
                val order = packetData.compareTo(rightPacket.list[index])
                if (order == ListOrder.CORRECT) return ListOrder.CORRECT
                if (order == ListOrder.INCORRECT) return ListOrder.INCORRECT
            }

            if (list.size < rightPacket.list.size) {
                return ListOrder.CORRECT
            }
            return ListOrder.UNKNOWN
        }

        //if left is list and right is data
        if (this is PacketList && rightPacket is PacketValue) {
            return compareTo(PacketList(mutableListOf(rightPacket)), depth + 1)
        }

        //if right is list and left is data
        if (this is PacketValue && rightPacket is PacketList) {
            return PacketList(mutableListOf(this)).compareTo(rightPacket, depth + 1)
        }

        return ListOrder.UNKNOWN
    }

    override fun toString(): String {
        val builder = StringBuilder()

        if (this is PacketValue) {
            return this.value.toString()
        } else if (this is PacketList) {
            builder.append("[")
            for (data in list) {
                builder.append(data)
                    .append(", ")
            }
            builder.append("]")
            return builder.toString()
        }

        return "<No packet data>"
    }

}

fun parseLists(line: String): PacketData {
    val iterator = line.iterator()

    // every packet is a list
    val topPacket = PacketList()

    iterator.next() // The first [
    var closestPacketData: PacketData = topPacket

    while (iterator.hasNext()) {
        var char = iterator.nextChar()
        val digitBuilder = StringBuilder()

        while (char.isDigit()) {
            digitBuilder.append(char)
            char = iterator.nextChar()
        }

        if (char == '[') {
            val newPacketData = PacketList(parent = closestPacketData)
            (closestPacketData as PacketList).addValue(newPacketData)
            closestPacketData = newPacketData
        }

        if (digitBuilder.isNotBlank()) {
            (closestPacketData as PacketList).addValue(PacketValue(digitBuilder.toString().toInt()))
        }

        if (char == ']') {
            if (closestPacketData.parent == null) {
                continue
            }

            closestPacketData = closestPacketData.parent!!
        }

    }

    return topPacket
}

fun main(args: Array<String>) {
    val iterator = puzzleInput.lines().iterator()

    var left = iterator.next()
    var right = iterator.next()

    var indexCounter = 1
    val correctOrder = mutableListOf<Int>()

    val packets = mutableListOf<PacketData>()

    do {

        val leftPacket = parseLists(left)
        val rightPacket = parseLists(right)
        packets.add(leftPacket)
        packets.add(rightPacket)

//        println()
//        println("== Pair $indexCounter ==")
//        val comparison = leftPacket.compareTo(rightPacket)

//        println("Comparing left to right: ${comparison}")
//        if (comparison == ListOrder.CORRECT) {
//            correctOrder.add(indexCounter)
//        }

        val blankSpace = iterator.next()
        left = iterator.next()
        right = iterator.next()
        indexCounter++
    } while (iterator.hasNext())

    val leftPacket = parseLists(left)
    val rightPacket = parseLists(right)
    packets.add(leftPacket)
    packets.add(rightPacket)
    val divider1 = PacketList(mutableListOf(PacketList(mutableListOf(PacketValue(2)))))
    val divider2 = PacketList(mutableListOf(PacketList(mutableListOf(PacketValue(6)))))
    packets.add(divider1)
    packets.add(divider2)

//    val comparison = leftPacket.compareTo(rightPacket)
//    println("Comparing left to right: ${comparison}")
//
//    println("Pairs in correct order: ${correctOrder}, sum is ${correctOrder.sum()}")

//    println(packets)

    val sorted = packets.sortedWith(Comparator { packet1, packet2 ->
        when (packet1.compareTo(packet2)) {
            ListOrder.CORRECT -> -1
            ListOrder.INCORRECT -> 1
            ListOrder.UNKNOWN -> 0
        }
    })

    val score = sorted
//        .filter { it == divider1 || it == divider2 }
        .mapIndexed { index, packetData ->
            if (packetData == divider1 || packetData == divider2)  index + 1 else 1
        }.reduce(Int::times)

    println(score)
}