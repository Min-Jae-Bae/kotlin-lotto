package lotto.model.generator

import camp.nextstep.edu.missionutils.Randoms

class LottoRandomListGenerator : LottoNumberListGenerator {
    override fun generate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_LIST_SIZE)
    }

    companion object {
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
        const val LOTTO_LIST_SIZE = 6
    }
}