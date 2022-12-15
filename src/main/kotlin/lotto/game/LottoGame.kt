package lotto.game

import lotto.game.service.Game
import lotto.model.Lotto
import lotto.model.generator.LottoMaker
import lotto.util.GAME_START_MESSAGE
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoMaker: LottoMaker,
) : Game {
    private val money = inputView.createMoney()
    private val lotteries = lottoMaker.makeLotto(money)

    override fun play() {
        println(GAME_START_MESSAGE)
        process()
    }

    override fun process() {
        outputLotto()
        outputResult()
    }

    private fun outputLotto() = outputView.printLotto(lotteries)

    private fun outputResult() {
        val lotto = Lotto(inputView.createWinningNumber())

        outputView.printResult(
            lotto.createMatchCountList(
                lotteriesMap = lotteries,
                bonusNumber = inputView.createBonusNumber()),
            lotto.createTotalReturn(money))
    }
}