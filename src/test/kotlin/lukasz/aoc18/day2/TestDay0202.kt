package lukasz.aoc18.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestDay0202 {

    @Test
    fun testFindMatching() {
        val matching = findMatching(
            listOf(
                "abcde",
                "fghij",
                "klmno",
                "pqrst",
                "fguij",
                "axcye",
                "wvxyz"
            )
        )
        assertThat(matching).isEqualTo("fgij")
    }
}