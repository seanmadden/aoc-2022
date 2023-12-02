//import kotlin.math.abs
//
//fun main() {
//    val s1 = solution("BAABA", listOf(2, 4, 1, 1, 2).toIntArray())
//    println("${s1[0]}/${s1[1]}")
//
//    val s2 = solution("ABAB", listOf(10, 5, 10, 15).toIntArray())
//    println("${s2[0]}/${s2[1]}")
//
//    val s3 = solution("B", listOf(100).toIntArray())
//    println("${s3[0]}/${s3[1]}")
//
//    val s4 = solution("BBB", listOf(100, 200, 300).toIntArray())
//    println("${s4[0]}/${s4[1]}")
//}
//
////that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
//fun solution(r: String, v: IntArray): IntArray {
//    // Implement your solution here
//    // v is transfer TO
//    // v is VALUE TRANSFERRED
//
//    // inputs are both the same length
//    val accounts = IntArray(2) { 0 } // start both with a balance of 0
//
//    var aMinValue = 0
//    var bMinValue = 0
//
//    for ((index, value) in r.withIndex()) {
//        val transferTo = r[index]
//        val amount = v[index]
//
//        val transferFrom = if (transferTo == 'B') 'A' else 'B'
//
//        println("\tTransfer $amount from $transferFrom to $transferTo")
//        if (transferTo == 'A') {
//            // from b to A
//            accounts[1] -= amount
//            accounts[0] += amount
//
//            if (accounts[1] < 0) {
//                println("\tB goes negative! ${accounts[1]}")
//                bMinValue += abs(accounts[1])
//                accounts[1] = 0
//            }
//        } else {
//            // from A to B
//            accounts[0] -= amount
//            accounts[1] += amount
//            if (accounts[0] < 0) {
//                println("\tA goes negative! ${accounts[0]}")
//                aMinValue += abs(accounts[0])
//                accounts[0] = 0
//            }
//        }
//    }
//    return intArrayOf(aMinValue, bMinValue)
//}
