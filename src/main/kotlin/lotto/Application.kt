package lotto

import lotto.game.LottoGame
import lotto.model.Lotto
import lotto.view.InputView
import lotto.view.OutputView

fun main() {

    val lottoGame = LottoGame(inputView = InputView(), outputView = OutputView())
    lottoGame.play()
}
