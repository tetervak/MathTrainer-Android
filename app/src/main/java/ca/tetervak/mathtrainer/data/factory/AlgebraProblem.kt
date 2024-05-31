package ca.tetervak.mathtrainer.data.factory

import ca.tetervak.mathtrainer.domain.Problem
import ca.tetervak.mathtrainer.domain.ProblemGrade
import kotlin.math.abs

abstract class AlgebraProblem: Problem {

    protected abstract val answer: Int

    override fun checkAnswer(userAnswer: String): ProblemGrade =
        try {
            val entered: Double = userAnswer.toDouble()
            if (abs(answer - entered) <= TOLERANCE) {
                ProblemGrade.RIGHT_ANSWER
            } else {
                ProblemGrade.WRONG_ANSWER
            }
        } catch (e: NumberFormatException) {
            ProblemGrade.INVALID_INPUT
        }

    companion object {
        const val TOLERANCE: Double = 0.000001
    }
}