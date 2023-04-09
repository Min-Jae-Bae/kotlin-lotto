package lotto.view.validator

import lotto.util.ERROR_INVALID_NUMBER_MESSAGE
import lotto.util.LOTTERY_PRICE
import lotto.util.PURCHASE_LOTTO_INPUT_MESSAGE

object InputValidator {

    fun validateInvalidMoney(): Int {
        while (true) {
            try {
                println(PURCHASE_LOTTO_INPUT_MESSAGE)
                val money = readLine()!!.toInt()
                require(money % LOTTERY_PRICE == 0)
                return money
            } catch (e: NumberFormatException) {
                println(ERROR_INVALID_NUMBER_MESSAGE)
                continue
            }
        }
    }
}