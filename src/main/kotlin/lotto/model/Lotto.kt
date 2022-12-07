package lotto.model

import lotto.util.Rank

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }
    private val matchCountList: MutableList<Int> = mutableListOf()
    private val winningMap: HashMap<Rank, Int> = HashMap()

    fun createMatchCountList(
        lotteriesMap: HashMap<Int, List<Int>>,
        bonusNumber: Int,
    ): HashMap<Rank, Int> {
        lotteriesMap.forEach { (_, lotteries) ->
            var count = 0
            repeat(lotteries.size) { index ->
                if (numbers.contains(lotteries[index])) count++
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
                Rank.FIRST -> Rank.FIRST.money * entry.value
            }
        }.sum()
    }

    fun createTotalReturn(purchase: Int): Double {
        val rewardTotal = updateTotalReturn()
        return (rewardTotal / (purchase).toDouble()) * 100
    }
}
