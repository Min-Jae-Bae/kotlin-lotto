package lotto.view.validator

object InputValidator {

    fun validateInvalidMoney(): Int {
        while (true) {
            try {
                println("구입 금액을 입력해 주세요.")
                val money = readLine()!!.toInt()
                require(money % 1000 == 0)
                return money
            } catch (e: NumberFormatException) {
                println("[ERROR] 숫자만 가능합니다. 다시 입력해 주세요")
                continue
            }
        }
    }
}