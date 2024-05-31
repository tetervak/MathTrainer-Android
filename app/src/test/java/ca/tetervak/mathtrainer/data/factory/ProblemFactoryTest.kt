package ca.tetervak.mathtrainer.data.factory

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.random.Random

class ProblemFactoryTest {

    private val random: Random = Random(2)
    private val factory: ProblemFactory = ProblemFactory(random)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun createProblem() {
        println("making 25 problems")
        repeat(25){
            println("problem: ${factory.createProblem().text}")
        }
    }
}