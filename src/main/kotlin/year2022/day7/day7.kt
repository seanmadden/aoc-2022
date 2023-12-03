package year2022.day7

import java.io.File
import java.nio.file.Path

val testInput = """
    ${'$'} cd /
    ${'$'} ls
    dir a
    14848514 b.txt
    8504156 c.dat
    dir d
    ${'$'} cd a
    ${'$'} ls
    dir e
    29116 f
    2557 g
    62596 h.lst
    ${'$'} cd e
    ${'$'} ls
    584 i
    ${'$'} cd ..
    ${'$'} cd ..
    ${'$'} cd d
    ${'$'} ls
    4060174 j
    8033020 d.log
    5626152 d.ext
    7214296 k
""".trimIndent()

val allSizes = mutableListOf<Int>()

enum class NodeType {
    DIRECTORY,
    FILE
}

class Node(
    private val type: NodeType,
    val name: String,
    val parent: Node? = null,
    private val size: Int = 0
) {
    val children = mutableListOf<Node>()

    fun size(): Int {
        return if (type == NodeType.FILE) {
            size
        } else {
            sizeOfChildren()
        }
    }

    fun addChild(node: Node) {
        if (type == NodeType.DIRECTORY) {
            children.add(node)
        }
    }

    fun sizeOfChildren(): Int {
        if (type == NodeType.DIRECTORY) {
            return children.sumOf { it.sizeOfChildren() }
        }
        if (type == NodeType.FILE) {
            return size
        }

        return 0
    }

    override fun toString(): String {
        if (type == NodeType.DIRECTORY) {
            return "${name} (dir, sizeOfChildren=${sizeOfChildren()})"
        }

        if (type == NodeType.FILE) {
            return "${name} (file, size=${size})"
        }

        return ""
    }

    fun printTree(depth: Int = 0) {
        if (type == NodeType.DIRECTORY) {
            allSizes.add(sizeOfChildren())
            println("\t".repeat(depth) + "- ${name} (dir, sizeOfChildren=${sizeOfChildren()})")
        }

        if (type == NodeType.FILE) {
            println("\t".repeat(depth) + "- ${name} (file, size=${size})")
        }

        if (children.isEmpty()) return

        for (child in children) {
            child.printTree(depth + 1)
        }
    }

    fun getAllChildDirectories(): List<Node> {
        val nodes = mutableListOf<Node>()

        if (type == NodeType.DIRECTORY) {
            nodes.add(this)
        }

        for (child in children) {
            nodes.addAll(child.getAllChildDirectories())
        }

        return nodes
    }

    fun sumChildrenUnder(target: Int = 100000): Int {
        var total = 0;
        if (type == NodeType.DIRECTORY) {
            if (sizeOfChildren() <= target) {
                total += sizeOfChildren()
            }
        }

        for (child in children) {
            total += child.sumChildrenUnder(target)
        }

        return total
    }
}

fun part1(input: String): Node {
    val rootNode = Node(NodeType.DIRECTORY, "/")
    var currentNode: Node = rootNode

    val iterator = input.lines().listIterator()

    while (iterator.hasNext()) {
        var line = iterator.next()

        if (line.startsWith("$")) {
            // command
            val command = line.split(" ")
            if (command[1] == "cd") {
                if (command[2] == "/") {
                    currentNode = rootNode
                    continue // root node already exists
                }

                if (command[2] == "..") {
                    currentNode = currentNode.parent!!
                    continue
                }

                currentNode = currentNode.children.find { it.name == command[2] }!!

            } else if (command[1] == "ls") {
                //next set of input is directory listing
                while (iterator.hasNext() && !input.lines().get(iterator.nextIndex())
                        .startsWith("$")
                ) {
                    line = iterator.next()
                    if (line[0].isDigit()) {
                        // file
                        val splitInput = line.split(" ")
                        currentNode.addChild(
                            Node(
                                NodeType.FILE,
                                splitInput[1],
                                currentNode,
                                splitInput[0].toInt()
                            )
                        )
                    } else if (line.startsWith("dir")) {
                        // dir
                        val splitInput = line.split(" ")
                        currentNode.addChild(Node(NodeType.DIRECTORY, splitInput[1], currentNode))
                    }
                }
            }
        }
    }

    rootNode.printTree()
    println(rootNode.sumChildrenUnder())

    return rootNode
}

fun part2(rootNode: Node) {
    val totalSpace = 70000000 // total disk
    val spaceRequired = 30000000 // required for update

    val totalSpaceUsed = rootNode.sizeOfChildren() // size of all files on disk

    val totalFreeSpace = totalSpace - totalSpaceUsed // total free space currently

    val maxSizeOfDisk = totalSpace - spaceRequired

    val spaceToFreeUp = totalSpaceUsed - maxSizeOfDisk

    val map = mutableMapOf<String, Int>()

    // This has a bug that doesn't appear when I use a global list and add the sizes as I walk the tree!
    // probably won't fix it :shrug:
//    println(rootNode.getAllChildDirectories())
//    for (node in rootNode.getAllChildDirectories()) {
//        map[node.name] = node.sizeOfChildren()
//        println("${node.name} size=${node.sizeOfChildren()}")
//    }

    var theValue = 0

    for (value in allSizes.sorted()) {
//        println(value)
        if (value < spaceToFreeUp) {
            continue
        }

        theValue = value
        break
    }

    println("need to free up ${spaceToFreeUp}, deleting dir with size ${theValue}")
}

fun main(args: Array<String>) {
    val rootNode = part1(puzzleInput)
    part2(rootNode)
}