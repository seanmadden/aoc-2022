package year2022.day16

val testInput = """
    Valve AA has flow rate=0; tunnels lead to valves DD, II, BB
    Valve BB has flow rate=13; tunnels lead to valves CC, AA
    Valve CC has flow rate=2; tunnels lead to valves DD, BB
    Valve DD has flow rate=20; tunnels lead to valves CC, AA, EE
    Valve EE has flow rate=3; tunnels lead to valves FF, DD
    Valve FF has flow rate=0; tunnels lead to valves EE, GG
    Valve GG has flow rate=0; tunnels lead to valves FF, HH
    Valve HH has flow rate=22; tunnel leads to valve GG
    Valve II has flow rate=0; tunnels lead to valves AA, JJ
    Valve JJ has flow rate=21; tunnel leads to valve II
""".trimIndent()

val regex =
    Regex("Valve ([A-Z]+) has flow rate=([0-9]+)")

// 1 minute to open value
// 1 minute to follow any tunnel
// All valves begin closed

class Valve(val valveLabel: String,
            val flowRate: Int,
            var enabled: Boolean = false
) {
    val exits = mutableListOf<Valve>()

//    fun areAllExitsEnabled() {
//        return exits.map { it }
//    }
}

class Volcano() {
    private val valveMap = mutableMapOf<String, Valve>()

    fun addValve(valve: Valve) {
        valveMap[valve.valveLabel] = valve
    }

    fun addExitToValve(valveLabel: String, exitLabel: String) {
        valveMap[valveLabel]!!.exits.add(getValve(exitLabel))
    }

    fun getValve(label: String): Valve {
        return valveMap[label]!!
    }

    override fun toString(): String {
        val buffer = StringBuilder()

        for ((k, v) in valveMap) {
            println("Valve $k / flow ${v.flowRate} / exits: ${v.exits}")
        }

        return buffer.toString()
    }

    fun findBestPath(
        startingValve: String,
        currentFlow: Int = 0,
        minutesToGo: Int = 30
    ) {
        val currentValve = getValve(startingValve)
        var totalFlow = currentFlow

        if (!currentValve.enabled) {
            // enabled it and count
            totalFlow += (currentValve.flowRate * minutesToGo)
            currentValve.enabled = true
        }

        // check each exit, pick the one that gives the highest value
        for (exit in currentValve.exits) {
            if (exit.enabled) continue

        }
    }

}

fun main(args: Array<String>) {
    val volcano = Volcano()
    val valveToExitMap = mutableMapOf<Valve, List<String>>()

    for (line in testInput.lines()) {
        val splitLine = line.split(";")
        val matches = regex.find(splitLine[0])!!.groupValues
        val valve = matches[1]
        val flowRate = matches[2].toInt()

        val exits = splitLine[1].removePrefix(" tunnels lead to valves ")
            .removePrefix(" tunnel leads to valve ")
            .split(",").map { it.trim() }

        val v = Valve(valve, flowRate)
        volcano.addValve(v)

        valveToExitMap[v] = exits
    }
    for ((k, v) in valveToExitMap) {
        for (valveExit in v) {
            volcano.addExitToValve(k.valveLabel, valveExit)
        }
    }

    println(volcano)
}