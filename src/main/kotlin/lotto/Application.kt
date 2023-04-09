package lotto

import lotto.game.LottoGame
import lotto.model.generator.LottoMaker
import lotto.model.generator.LottoRandomListGenerator
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lottoMaker = LottoMaker(LottoRandomListGenerator())
    val lottoGame = LottoGame(
        inputView = InputView(),
        outputView = OutputView(),
        lottoMaker = lottoMaker
    )
    lottoGame.play()
}
