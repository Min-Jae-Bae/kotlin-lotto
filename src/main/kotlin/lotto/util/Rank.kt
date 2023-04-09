package lotto.util

enum class Rank(val matchCount: Int, val money: Int, val message: String) {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개"),
    SECOND(7, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - %d개"),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - %d개"),
}