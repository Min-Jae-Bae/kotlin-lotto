package lotto.model.generator

import camp.nextstep.edu.missionutils.Randoms

class LottoRandomListGenerator : LottoNumberListGenerator {
    override fun generate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}