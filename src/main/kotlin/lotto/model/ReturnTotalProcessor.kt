package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Rank

object ReturnTotalProcessor {
    private val lotteriesMap: HashMap<Int, List<Int>> = HashMap()
    private val matchCountList: MutableList<Int> = mutableListOf()
    private val winningMap: HashMap<Rank, Int> = HashMap()

    fun createLotteries(money: Int): HashMap<Int, List<Int>> {
        val lotteriesCount = money / 1000
        repeat(lotteriesCount) { index ->
            val numberList = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lotteriesMap[index] = numberList.sorted()
        }
        return lotteriesMap
    }

    fun createMatchCountList(winningNumber: List<Int>, bonusNumber: Int): HashMap<Rank, Int> {
        lotteriesMap.forEach { (_, lotteries) ->
            var count = 0
            repeat(lotteries.size) { index ->
                if (winningNumber.contains(lotteries[index])) count++
            }
            if (count == 5 && lotteries.contains(bonusNumber)) count += 2
            matchCountList.add(count)
        }
        return updateWinningMap()
    }


    private fun updateWinningMap(): HashMap<Rank, Int> {
        winningMap[Rank.FIFTH] = matchCountList.count { it == Rank.FIFTH.matchCount }
        winningMap[Rank.FOURTH] = matchCountList.count { it == Rank.FOURTH.matchCount }
        winningMap[Rank.THIRD] = matchCountList.count { it == Rank.THIRD.matchCount }
        winningMap[Rank.SECOND] = matchCountList.count { it == Rank.SECOND.matchCount }
        winningMap[Rank.FIRST] = matchCountList.count { it == Rank.FIRST.matchCount }
        return winningMap
    }

    private fun updateTotalReturn(): Int {
        return winningMap.map { entry ->
            when (entry.key) {
                Rank.FIFTH -> Rank.FIFTH.money * entry.value
                Rank.FOURTH -> Rank.FOURTH.money * entry.value
                Rank.THIRD -> Rank.THIRD.money * entry.value
                Rank.SECOND -> Rank.SECOND.money * entry.value
                else -> Rank.FIRST.money * entry.value
            }
        }.sum()
    }

    fun createTotalReturn(purchase: Int): Double {
        val rewardTotal = updateTotalReturn()
        return (rewardTotal / (purchase).toDouble()) * 100
    }
}