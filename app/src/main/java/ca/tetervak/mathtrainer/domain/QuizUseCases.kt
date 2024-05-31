package ca.tetervak.mathtrainer.domain

import ca.tetervak.mathtrainer.data.factory.ProblemFactory

private val problemFactory: ProblemFactory = ProblemFactory()

var problemCount: Int = 0
    private set

fun resetQuizData(){
    problemCount = 0
}

fun newQuizProblem(): NotAnsweredProblem =
    NotAnsweredProblem(++problemCount, problemFactory.createProblem())

fun QuizProblem.toAnsweredProblem(userAnswer: String) =
    AnsweredProblem(this, userAnswer)

fun QuizProblem.toGradedProblem(userAnswer: String) = GradedProblem(this, userAnswer)

fun AnsweredProblem.toGradedProblem() = GradedProblem(this)