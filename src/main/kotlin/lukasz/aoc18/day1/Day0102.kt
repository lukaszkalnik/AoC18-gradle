package lukasz.aoc18.day1

import extensions.findDuplicate
import extensions.scan
import java.io.File

fun main() {
    File(ClassLoader.getSystemResource("input1.txt").file)
        .readLines()
        .map { it.toInt() }
        .let { solve02(it) }
        .let { println("Result: $it") }
}

fun solve02(input: List<Int>): Int? {
    var listNumber = 0

    val scannedList = mutableListOf(0)
    var duplicate: Int?

    do {
        println("List number: ${listNumber++}")

        scannedList.addAll(input.scan(scannedList.last()) { a, b -> a + b })
        duplicate = scannedList.findDuplicate()
    } while (duplicate == null)

    return duplicate
}