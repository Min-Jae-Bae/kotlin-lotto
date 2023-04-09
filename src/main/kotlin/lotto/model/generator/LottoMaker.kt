package lotto.model.generator

import lotto.util.LOTTERY_PRICE

class LottoMaker(private val lottoNumberListGenerator: LottoNumberListGenerator) {

    fun makeLotto(money: Int): HashMap<Int, List<Int>> {
        val lotteriesMap: HashMap<Int, List<Int>> = HashMap()
        val lotteriesCount = money / LOTTERY_PRICE
        repeat(lotteriesCount) { index ->
            val lottery = lottoNumberListGenerator.generate()
            lotteriesMap[index] = lottery.sorted()
        }
        return lotteriesMap
    }
}