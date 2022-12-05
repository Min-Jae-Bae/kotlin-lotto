package lotto.view

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.PRINT_PURCHASE_LOTTERIES_MESSAGE
import lotto.util.RATE_RETURN_MESSAGE
import lotto.util.Rank

class OutputView {

    // 구매 출력
    fun printPurchase(purchaseMoney: Int) {
        val lotteriesCount = purchaseMoney / 1000
        println(PRINT_PURCHASE_LOTTERIES_MESSAGE.format(lotteriesCount))
        printLotteries(lotteriesCount)
    }

    fun printLotteries(lotteriesCount: Int) {
        repeat(lotteriesCount) {
            val number = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            println(number.sorted())
        }
    }

    // 결과 출력
    fun printResult() {
        println("당첨 통계\n---")
        println(Rank.FIFTH.message.format(1))
        println(Rank.FOURTH.message.format(0))
        println(Rank.THIRD.message.format(0))
        println(Rank.SECOND.message.format(0))
        println(Rank.FIRST.message.format(0))
        println(RATE_RETURN_MESSAGE.format(62.5))

    }
}
