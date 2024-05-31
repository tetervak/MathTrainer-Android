package ca.tetervak.mathtrainer.domain

sealed class QuizProblem(
    val count: Int,
    val problem: Problem
)

class NotAnsweredProblem(
    count: Int,
    problem: Problem
) : QuizProblem(count, problem)

open class AnsweredProblem(
    count: Int,
    problem: Problem,
    val userAnswer: String
) : QuizProblem(count, problem) {
    constructor(quizProblem: QuizProblem, userAnswer: String) : this(
        quizProblem.count, quizProblem.problem, userAnswer
    )
}

class GradedProblem(
    count: Int,
    problem: Problem,
    userAnswer: String
) : AnsweredProblem(count, problem, userAnswer) {

    val problemGrade: ProblemGrade = problem.checkAnswer(userAnswer)

    constructor(quizProblem: QuizProblem, userAnswer: String) : this(
        quizProblem.count, quizProblem.problem, userAnswer
    )

    constructor(answeredProblem: AnsweredProblem) : this(
        answeredProblem.count, answeredProblem.problem, answeredProblem.userAnswer
    )
}