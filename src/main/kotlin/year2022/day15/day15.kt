package year2022.day15

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

val testInput = """
    Sensor at x=2, y=18: closest beacon is at x=-2, y=15
    Sensor at x=9, y=16: closest beacon is at x=10, y=16
    Sensor at x=13, y=2: closest beacon is at x=15, y=3
    Sensor at x=12, y=14: closest beacon is at x=10, y=16
    Sensor at x=10, y=20: closest beacon is at x=10, y=16
    Sensor at x=14, y=17: closest beacon is at x=10, y=16
    Sensor at x=8, y=7: closest beacon is at x=2, y=10
    Sensor at x=2, y=0: closest beacon is at x=2, y=10
    Sensor at x=0, y=11: closest beacon is at x=2, y=10
    Sensor at x=20, y=14: closest beacon is at x=25, y=17
    Sensor at x=17, y=20: closest beacon is at x=21, y=22
    Sensor at x=16, y=7: closest beacon is at x=15, y=3
    Sensor at x=14, y=3: closest beacon is at x=15, y=3
    Sensor at x=20, y=1: closest beacon is at x=15, y=3
""".trimIndent()

val regex =
    Regex("Sensor at x=([-0-9]+), y=([-0-9]+): closest beacon is at x=([-0-9]+), y=([-0-9]+)")

abstract class CaveSpace(val x: Int, val y: Int) {
    fun getDistance(second: CaveSpace): Int {
        return abs(x - second.x) + abs(y - second.y)
    }
}

class Sensor(x: Int, y: Int, val closestBeacon: Beacon) : CaveSpace(x, y) {
    override fun toString(): String {
        return "S"
    }

    fun distanceToBeacon(): Int {
        return this.getDistance(closestBeacon)
    }
}

class Beacon(x: Int, y: Int) : CaveSpace(x, y) {
    override fun toString(): String {
        return "B"
    }
}

class EmptySpace(x: Int, y: Int) : CaveSpace(x, y) {
    override fun toString(): String {
        return "."
    }
}

class CantContainBeacon(x: Int, y: Int) : CaveSpace(x, y) {
    override fun toString(): String {
        return "#"
    }
}

class Grid() {
    private var initialized = false
    private val sensorsAndBeacons = mutableListOf<CaveSpace>()


    private var minX = Int.MAX_VALUE
    private var maxX = Int.MIN_VALUE
    private var minY = Int.MAX_VALUE
    private var maxY = Int.MIN_VALUE
    private var maxDistance = 0

    private val spaces = mutableMapOf<Int, MutableMap<Int, CaveSpace>>()

    fun addSensorAndBeacon(sensor: Sensor, beacon: Beacon) {
        minX = min(minX, sensor.x - maxDistance)
        maxX = max(maxX, sensor.x + maxDistance)
        minY = min(minY, sensor.y - maxDistance)
        maxY = max(maxY, sensor.y + maxDistance)
        sensorsAndBeacons.add(sensor)

        minX = min(minX, beacon.x - maxDistance)
        maxX = max(maxX, beacon.x + maxDistance)
        minY = min(minY, beacon.y - maxDistance)
        maxY = max(maxY, beacon.y + maxDistance)
        sensorsAndBeacons.add(beacon)
        maxDistance = max(maxDistance, sensor.getDistance(beacon))
    }

    fun countOccupedSpacesInCol(col: Int): Int {
        val matching = mutableSetOf<Pair<Int, Int>>()

        for (x in minX..maxX) {
            for (sensor in this.sensorsAndBeacons) {
                if (sensor is Sensor) {
                    val maxDistance = sensor.getDistance(sensor.closestBeacon)

                    if (spaces[x] != null && spaces[x]!![col] != null) {
                        continue
                    }
                    if (sensor.getDistance(EmptySpace(x, col)) <= maxDistance) {
                        matching.add(Pair(x, col))
                    }
                }
            }
        }
        matching.removeAll(sensorsAndBeacons.filter { it is Beacon }.map { Pair(it.x, it.y) }
            .toSet())
        return matching.size

    }

    fun generate() {
        initialized = true
        (minX..maxX).forEach { x ->
            val newList = mutableMapOf<Int, CaveSpace>()
//            (minY..maxY).forEach { y ->
//                newList[y] = EmptySpace(x, y)
//            }
            spaces[x] = newList
        }

        for (sensorOrBeacon in sensorsAndBeacons) {
            spaces[sensorOrBeacon.x]!![sensorOrBeacon.y] = sensorOrBeacon
        }
    }

    fun illuminate(sensor: Sensor) {
        val spot = spaces[sensor.x]!![sensor.y] as Sensor

        val distance = spot.getDistance(spot.closestBeacon)
        for (row in sensor.x - distance..sensor.x + distance) {
            for (col in sensor.y - distance..sensor.y + distance) {
                if (spot.getDistance(EmptySpace(row, col)) <= distance) {
                    if (spaces[row]!![col] == null) {
                        spaces[row]!![col] = CantContainBeacon(row, col)
                    }
                }
            }
        }
    }

    override fun toString(): String {
        val builder = StringBuilder()

//        builder.append("Grid from ($minX, $minY) to ($maxX, $maxY), with a max distance of $maxDistance")
        // We're going to transpose these because that's how they present it
        for (col in minY..maxY) {
            for (row in minX..maxX) {
                if (spaces[row]!![col] == null) builder.append('.') else builder.append(spaces[row]!![col])
            }
            builder.appendLine()
        }

        return builder.toString()
    }

    fun possibleBeaconSpot(xRange: IntRange, yRange: IntRange) {
        val sensorCoverage = mutableSetOf<Pair<Int, Int>>()

        for (sensor in sensorsAndBeacons) {
            if (sensor is Sensor) {
                val maxDistance = sensor.getDistance(sensor.closestBeacon)
                println("calculating sensor coverage from ${sensor.x - maxDistance .. sensor.x + maxDistance}")
                for (x in sensor.x - maxDistance .. sensor.x + maxDistance) {
                    for (y in sensor.y - maxDistance .. sensor.y + maxDistance) {
                        if (sensorCoverage.contains(Pair(x, y))) continue

                        if (spaces[x] != null && spaces[x]!![y] != null) {
                            continue
                        }
                        if (sensor.getDistance(EmptySpace(x, y)) <= maxDistance) {
                            sensorCoverage.add(Pair(x, y))
                        }
                    }
                }
            }
        }

        for (x in xRange) {
            if (x % 100_000 == 0) println("Checking $x")
            for (y in yRange) {
                if (!sensorCoverage.contains(Pair(x, y))) {
                    println("$x, $y " + sensorCoverage.contains(Pair(x, y)))
                    println("tuning frequency: ${(4000000 * x) + y}")
                    return
                }
            }
        }

    }
}

fun main(args: Array<String>) {

    val grid = Grid()

    val sensorList = mutableListOf<Sensor>()

    for (line in puzzleInput.lines()) {
        val match = regex.find(line)

        val x1 = match!!.groupValues[1].toInt()
        val y1 = match.groupValues[2].toInt()
        val x2 = match.groupValues[3].toInt()
        val y2 = match.groupValues[4].toInt()

        val beacon = Beacon(x2, y2)
        val sensor = Sensor(x1, y1, closestBeacon = beacon)
        sensorList.add(sensor)

        grid.addSensorAndBeacon(sensor, beacon)
    }

//    grid.generate()

//    sensorList.forEach { grid.illuminate(it) }

//    println(grid)
//    print(grid.countOccupedSpacesInCol(2000000))
//    print(grid.countOccupedSpacesInCol(11))
    grid.possibleBeaconSpot(0..4_000_000, 0..4_000_000)
}
