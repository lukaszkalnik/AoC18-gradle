package lukasz.aoc18.day2

import java.io.File

fun main() {
    File(ClassLoader.getSystemResource("input02.txt").file)
        .readLines()
        .let { checksum(it) }
        .let { println("Result: $it") }
}

/**
 * Calculates a rudimentary checksum of a list of strings by counting words containing exactly 2 (or 3)
 * repetitions of any character and then multiplying these values.
 */
fun checksum(ids: List<String>): Int {
    val twoChars = ids.map { it.hasRepetitions(2) }.count { it }
    val threeChars = ids.map { it.hasRepetitions(3) }.count { it }
    return twoChars * threeChars
}

/**
 * Tells if [String] contains any characters which are repeated *exactly* [count] times.
 */
private fun String.hasRepetitions(count: Int): Boolean {
    groupBy { it }
        .forEach { if (it.value.size == count) return true }
    return false
}