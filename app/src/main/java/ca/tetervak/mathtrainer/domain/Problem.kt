package ca.tetervak.mathtrainer.domain

interface Problem {
    val text: String
    fun checkAnswer(userAnswer: String): ProblemGrade
}