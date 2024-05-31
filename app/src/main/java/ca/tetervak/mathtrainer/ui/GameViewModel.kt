
package ca.tetervak.mathtrainer.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ca.tetervak.mathtrainer.data.factory.ProblemFactory
import ca.tetervak.mathtrainer.domain.ProblemGrade
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * ViewModel containing the app data and methods to process the data
 */
class GameViewModel : ViewModel() {

    val numberOfProblems: Int = 10

    private val problemFactory: ProblemFactory = ProblemFactory()

    private val uiInitState: GameUiState
        get() = GameUiState(
            problem = problemFactory.createProblem(),
            problemCount = 1
        )

    // Game UI state
    private val _uiState: MutableStateFlow<GameUiState> = MutableStateFlow(uiInitState)
    val uiState: StateFlow<GameUiState> = _uiState

    var answerInput by mutableStateOf("")
        private set

    fun updateAnswerInput(input: String){
        answerInput = input
    }

    fun resetGame() {
        _uiState.value = uiInitState
    }

    fun onSkip() {
        updateAnswerInput("")
        _uiState.update { state ->
            if (state.problemCount == numberOfProblems) {
                state.copy(
                    isGameOver = true
                )
            } else {
                state.copy(
                    problem = problemFactory.createProblem(),
                    problemCount = state.problemCount + 1,
                    isWrongAnswer = false
                )
            }
        }
    }

    fun onSubmit() {
        val problem = uiState.value.problem
        _uiState.update { state ->
            if (problem.checkAnswer(answerInput) == ProblemGrade.RIGHT_ANSWER) {
                if (state.problemCount == numberOfProblems) {
                    state.copy(
                        score = state.score + 1,
                        isWrongAnswer = false,
                        isGameOver = true
                    )
                } else {
                    state.copy(
                        score = state.score + 1,
                        isWrongAnswer = false,
                        problem = problemFactory.createProblem(),
                        problemCount = state.problemCount + 1
                    )
                }
            } else {
                state.copy(
                    isWrongAnswer = true
                )
            }
        }
        updateAnswerInput("")
    }

}
