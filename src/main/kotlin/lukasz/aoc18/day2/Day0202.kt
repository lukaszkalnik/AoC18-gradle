package lukasz.aoc18.day2

import java.io.File

fun main() {
    File(ClassLoader.getSystemResource("input02.txt").file)
        .readLines()
        .let { findMatching(it) }
        .let { println("Result: $it") }
}

fun findMatching(ids: List<String>): String {
    ids.forEachIndexed { index, id ->
        ids.subList(0, index).forEach {
            if (id.differsByOneChar(it)) return id.getIdenticalChars(it)
        }
    }
    return ""
}

/**
 * Checks if two Strings differ by exactly one char at the same position.
 */
fun String.differsByOneChar(other: String): Boolean {
    var diffCounter = 0
    forEachIndexed { index, char ->
        if (char != other[index]) ++diffCounter
        if (diffCounter > 1) return false
    }
    return diffCounter == 1
}

/**
 * Constructs a String containing all identical characters on identical positions
 * between two Strings.
 */
fun String.getIdenticalChars(other: String): String =
    mapIndexed { index, char ->
        if (char == other[index]) char.toString() else ""
    }.joinToString(separator = "")
