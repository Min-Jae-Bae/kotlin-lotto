package lotto.model.generator

class LottoMaker(private val lottoNumberListGenerator: LottoNumberListGenerator) {

    fun makeLotto(money: Int): HashMap<Int, List<Int>> {
        val lotteriesMap: HashMap<Int, List<Int>> = HashMap()
        val lotteriesCount = money / 1000
        repeat(lotteriesCount) { index ->
            val lottery = lottoNumberListGenerator.generate()
            lotteriesMap[index] = lottery.sorted()
        }
        return lotteriesMap
    }
}