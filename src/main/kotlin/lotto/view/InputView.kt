package lotto.view

import lotto.util.COMMA_STRING
import lotto.util.ENTER_BONUS_NUMBER_MESSAGE
import lotto.util.ENTER_WINNING_NUMBER_MESSAGE
import lotto.view.validator.InputValidator

class InputView {

    // 금액 입력
    fun createMoney(): Int {
        return InputValidator.validateInvalidMoney()
    }

    // 당첨 번호 입력
    fun createWinningNumber(): List<Int> {
        println(ENTER_WINNING_NUMBER_MESSAGE)
        val winningNumber = readLine()!!.split(COMMA_STRING)
        return winningNumber.map { number -> number.toInt() }
    }

    // 보너스 번호 입력
    fun createBonusNumber(): Int {
        println(ENTER_BONUS_NUMBER_MESSAGE)
        val bonusNumber = readLine()!!
        return bonusNumber.toInt()
    }
}