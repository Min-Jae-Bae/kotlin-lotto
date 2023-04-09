package lotto.view

import lotto.util.PRINT_PURCHASE_LOTTERIES_MESSAGE
import lotto.util.RETURN_TOTAL_MESSAGE
import lotto.util.Rank
import lotto.util.WINNING_STATICS_OUTPUT_MESSAGE

class OutputView {

    fun printLotto(lotto: HashMap<Int, List<Int>>) {
        println(PRINT_PURCHASE_LOTTERIES_MESSAGE.format(lotto.size))
        lotto.forEach { (_, lottoList) -> println(lottoList) }
    }

    // 결과 출력
    fun printResult(winningList: HashMap<Rank, Int>, returnTotal: Double) {
        println(WINNING_STATICS_OUTPUT_MESSAGE)
        println(Rank.FIFTH.message.format(winningList[Rank.FIFTH]))
        println(Rank.FOURTH.message.format(winningList[Rank.FOURTH]))
        println(Rank.THIRD.message.format(winningList[Rank.THIRD]))
        println(Rank.SECOND.message.format(winningList[Rank.SECOND]))
        println(Rank.FIRST.message.format(winningList[Rank.FIRST]))
        println(RETURN_TOTAL_MESSAGE.format(returnTotal))
    }
}
