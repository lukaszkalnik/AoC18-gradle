package lukasz.aoc18.day1

import java.io.File

fun main() {
    File(ClassLoader.getSystemResource("input01.txt").file)
            .readLines()
            .map { it.toInt() }
            .sum()
            .let { print(it) }
}
