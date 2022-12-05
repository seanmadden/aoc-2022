package day2

import java.lang.Exception

val testInput = """
    A Y
    B X
    C Z
""".trimIndent()
abstract class GameChoice(val score: Int) {

}

class Rock() : GameChoice(1) {
}

class Paper() : GameChoice(2) {
}

class Scissors() : GameChoice(3) {
}

enum class GameOutcome(val score: Int) {
    PLAYER_WIN(6),
    PLAYER_LOSS(0),
    DRAW(3)
}

class Round(
    val desiredOutcome: String,
    val opponentChoice: String
) {
    var playerChoice: GameChoice? = null // Me
    var cpuChoice: GameChoice? = null // Opponent

    init {
        when (opponentChoice) {
            "A" -> cpuChoice = Rock()
            "B" -> cpuChoice = Paper()
            "C" -> cpuChoice = Scissors()
        }
        when (desiredOutcome) {
            "X" -> { // lose
                when (cpuChoice) {
                    is Rock -> playerChoice = Scissors()
                    is Paper -> playerChoice = Rock()
                    is Scissors -> playerChoice = Paper()

                }
            }

            "Y" -> { // Draw
                when (cpuChoice) {
                    is Rock -> playerChoice = Rock()
                    is Paper -> playerChoice = Paper()
                    is Scissors -> playerChoice = Scissors()
                }
            }

            "Z" -> { // Win
                when (cpuChoice) {
                    is Rock -> playerChoice = Paper()
                    is Paper -> playerChoice = Scissors()
                    is Scissors -> playerChoice = Rock()
                }
            }
        }
    }

    fun getScore(): Int {
        val outcome = assessWinner()

        return playerChoice!!.score + outcome.score
    }

    fun assessWinner(): GameOutcome {
        if (playerChoice!!.score == cpuChoice!!.score) {
            return GameOutcome.DRAW
        }

        when (cpuChoice) {
            is Rock -> {
                if (playerChoice is Paper) {
                    return GameOutcome.PLAYER_WIN
                } else if (playerChoice is Scissors) {
                    return GameOutcome.PLAYER_LOSS
                }
            }

            is Paper -> {
                if (playerChoice is Scissors) {
                    return GameOutcome.PLAYER_WIN
                } else if (playerChoice is Rock) {
                    return GameOutcome.PLAYER_LOSS
                }
            }

            is Scissors -> {
                if (playerChoice is Rock) {
                    return GameOutcome.PLAYER_WIN
                } else if (playerChoice is Paper) {
                    return GameOutcome.PLAYER_LOSS
                }
            }
        }
        throw Exception()
    }
}

fun part1() {
    var totalScore = 0;

    for ((idx, line) in puzzleInput.lines().withIndex()) {
        val opChoice = line.split(" ")[0]
        val myChoice = line.split(" ")[1]

        val round = Round(myChoice, opChoice)
        totalScore += round.getScore()
//        println("********** Round $idx **********")
//        println("Round outcome: ${round.assessWinner()}")
//        println("Round score: ${round.getScore()}")
    }
    println("Total score is $totalScore")
}

fun main(args: Array<String>) {
    part1()
}