package lotto.view

class InputView {

    // 금액 입력
    fun createMoney(): Int {
        println("구입 금액을 입력해 주세요.")
        val money = readLine()!!.toInt()
        require(money % 1000 == 0)
        return money
    }

    // 당첨 번호 입력
    fun createWinningNumber(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val winningNumber = readLine()!!.split(",")
        return winningNumber.map { number -> number.toInt() }
    }

    // 보너스 번호 입력
    fun createBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        val bonusNumber = readLine()!!
        return bonusNumber.toInt()
    }
}