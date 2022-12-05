package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Rank

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    private val rankHashMap: MutableMap<Rank, Int> = mutableMapOf()

    // 번호 비교
    fun compareNumber(bonusNumber: Int) {
        /*5등 조건 - FIFTH
        * 4등 조건 - FOURTH
        * 3등 조건 - THIRD
        * 2등 조건 - SECOND
        * 1등 조건 - FIRST
        * */
        var matchCount = 0
        val userLottery = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        userLottery.forEach { userNumber ->
            // 보너스 제외
            if (numbers.contains(userNumber)) matchCount++
            // 보너스 포함
            if (!numbers.contains(userNumber) && userNumber == bonusNumber) matchCount += 2
        }

        when (matchCount) {
            Rank.FIFTH.numberMatches -> rankHashMap[Rank.FIFTH] = Rank.FIFTH.money
            Rank.FOURTH.numberMatches -> rankHashMap[Rank.FOURTH] = Rank.FOURTH.money
            Rank.THIRD.numberMatches -> rankHashMap[Rank.THIRD] = Rank.THIRD.money
            Rank.SECOND.numberMatches -> rankHashMap[Rank.SECOND] = Rank.SECOND.money
            Rank.FIRST.numberMatches -> rankHashMap[Rank.FIRST] = Rank.FIRST.money
        }
    }
}
