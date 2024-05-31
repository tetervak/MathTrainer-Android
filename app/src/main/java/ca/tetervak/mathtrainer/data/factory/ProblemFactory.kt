package ca.tetervak.mathtrainer.data.factory

import ca.tetervak.mathtrainer.domain.Problem
import kotlin.random.Random

class ProblemFactory(
    private val random: Random = Random.Default
) {
    fun createProblem(): Problem {
        val larger = random.nextInt(LARGER_VALUE_FROM, LARGER_VALUE_UNTIL)
        val smaller = random.nextInt(SMALLER_VALUE_FROM, larger)
        return if(random.nextBoolean()) {
            AdditionProblem(a = larger - smaller, b = smaller)
        } else {
            SubtractionProblem(a = larger, b = smaller)
        }
    }

    companion object{
        private const val LARGER_VALUE_UNTIL: Int = 50
        private const val LARGER_VALUE_FROM: Int = 12
        private const val SMALLER_VALUE_FROM: Int = 7
    }
}