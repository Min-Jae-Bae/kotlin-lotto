package lotto.game

import lotto.game.service.Game
import lotto.model.generator.LottoMaker
import lotto.model.processor.ReturnTotalProcessor
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoMaker: LottoMaker
) : Game {

    override fun play() {
        println("로또 게임을 시작 합니다.")
        process()
    }

    override fun process() {
        try {
            val money = inputView.createMoney()
            val makeLotto = lottoMaker.makeLotto(money)
            outputView.printLotto(makeLotto)
            outputView.printResult(
                ReturnTotalProcessor.createMatchCountList(
                    makeLotto,
                    winningNumber = inputView.createWinningNumber(),
                    bonusNumber = inputView.createBonusNumber()),
                ReturnTotalProcessor.createTotalReturn(money))
        } catch (e: NumberFormatException) {
            println("[ERROR]")
        }
    }
}