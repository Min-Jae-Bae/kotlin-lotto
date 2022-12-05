package lotto.game

import lotto.game.service.Game
import lotto.model.Lotto
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
        /*
        * 구입 금액 입력
        * 로또 갯수와 로또를 출력
        *
        * 당첨 번호 입력
        * 보너스 번호 입력
        *
        * 당첨 통계와 수익률 출력
        * */
        try {
            val purchaseMoney = inputView.createMoney()
            outputView.printPurchase(purchaseMoney)
            val winningNumber = inputView.createWinningNumber()
            val bonusNumber = inputView.createBonusNumber()

            println(Lotto(winningNumber).compareNumber(bonusNumber))

            outputView.printResult()
        } catch (e: NumberFormatException) {
            println("[ERROR]")
        }


    }
}