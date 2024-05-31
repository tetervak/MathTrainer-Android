package ca.tetervak.mathtrainer.data.factory

data class AdditionProblem(
    private val a: Int,
    private val b: Int
) : AlgebraProblem() {
    override val answer: Int = a + b
    override val text: String = "$a + $b = ?"
}
