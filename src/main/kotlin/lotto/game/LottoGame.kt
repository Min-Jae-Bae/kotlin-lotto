package lotto.game

import camp.nextstep.edu.missionutils.Randoms
import lotto.game.service.Game
import lotto.model.Lotto
import lotto.model.ReturnTotalProcessor
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame(
    private val inputView: InputView,
    private val outputView: OutputView,
) : Game {

    override fun play() {
        println("로또 게임을 시작 합니다.")
        process()
    }

    override fun process() {
        try {
            val money = inputView.createMoney()
            outputView.printLotto(ReturnTotalProcessor.createLotteries(money))
            val winningNumber = inputView.createWinningNumber()
            val bonusNumber = inputView.createBonusNumber()
            outputView.printResult(
                ReturnTotalProcessor.createMatchCountList(winningNumber = winningNumber,
                    bonusNumber = bonusNumber),
                ReturnTotalProcessor.createTotalReturn(money)
            )
        } catch (e: NumberFormatException) {
            println("[ERROR]")
        }
    }
}