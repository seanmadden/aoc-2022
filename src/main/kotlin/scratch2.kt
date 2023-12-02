fun main() {
    val s1 = solution("abbab", listOf(-1, 0, 0, 0, 2).toIntArray())
    println(s1)

    val s2 = solution("ab", listOf(-1, 0).toIntArray())
    println(s2)

    val s3 = solution("abab", listOf(-1, 2, 0, 1).toIntArray())
    println(s3)
}

class Node(val letter: Char, val value: Int, val parentId: Int) {

    val children = mutableListOf<Node>()
    var parent: Node? = null

    fun addChild(node: Node) {
        children.add(node)
    }

    override fun toString(): String {
        return "[Node $letter/$value]"
    }
}

fun solution(s: String, a: IntArray): Int {
    // Implement your solution here
    // Maps the index to the node
    val nodeMap = mutableMapOf<Int, Node>()

    val rootNode: Node = Node(s[0], 0, -1)
    nodeMap[0] = rootNode

    for ((index, item) in a.withIndex()) {
        val nodeLetter = s[index]
        val nodeParent = a[index]

        if (nodeParent == -1) {
            // Root is set already
        } else {
            nodeMap[index] = Node(nodeLetter, index, nodeParent)
        }
    }

    for (node in nodeMap.values) {
        if (node.parentId != -1) {
            node.parent = nodeMap[node.parentId]!!
            nodeMap[node.parentId]?.addChild(node)
        }
    }

    val pathLists = mutableListOf<Int>()
    // There's probably a more efficient way of doing this, rather than checking every single node in the map?
    for (node in nodeMap) {
        pathLists.add(longestPathNoRepeatedLetters(node.value))
    }
    return pathLists.maxOrNull()!!

}

fun longestPathNoRepeatedLetters(rootNode: Node): Int {
    // BFS
    val queue = mutableListOf<Node>()
    val visited = mutableSetOf<Node>()
    queue.add(rootNode)
    var longestPath = 0

    while (queue.isNotEmpty()) {
        val inspectionNode = queue.removeFirst()
        if (visited.contains(inspectionNode)) continue
        longestPath++

        visited.add(inspectionNode)

        val thisLetter = inspectionNode.letter

        if (inspectionNode.parent != null && inspectionNode.parent!!.letter != thisLetter) {
            queue.add(inspectionNode.parent!!)
        }

        for (child in inspectionNode.children) {
            if (child.letter != thisLetter) {
                queue.add(child)
            }
        }
    }
    return longestPath
}