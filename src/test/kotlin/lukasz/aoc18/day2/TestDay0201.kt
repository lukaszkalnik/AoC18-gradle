package lukasz.aoc18.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TestDay0201 {

    @Test
    fun solve01() {
        val ids =
            listOf(
                "abcdef",
                "bababc",
                "abbcde",
                "abcccd",
                "aabcdd",
                "abcdee",
                "ababab"
            )
        assertThat(checksum(ids)).isEqualTo(12)
    }
}