package lukasz.aoc18.day1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestDay0102 {

    @Test
    fun testSolveA() {
        assertThat(solve02(listOf(1, -2, 3, 1))).isEqualTo(2)
    }

    @Test
    fun testSolveB() {
        assertThat(solve02(listOf(1, -1))).isEqualTo(0)
    }

    @Test
    fun testSolveC() {
        assertThat(solve02(listOf(+3, +3, +4, -2, -4))).isEqualTo(10)
    }

    @Test
    fun testSolveD() {
        assertThat(solve02(listOf(-6, +3, +8, +5, -6))).isEqualTo(5)
    }

    @Test
    fun testSolveE() {
        assertThat(solve02(listOf(+7, +7, -2, -7, -4))).isEqualTo(14)
    }
}