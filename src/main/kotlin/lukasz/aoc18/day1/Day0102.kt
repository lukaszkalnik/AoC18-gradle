package lukasz.aoc18.day1

import java.io.File

fun main() {
    File(ClassLoader.getSystemResource("input01.txt").file)
        .readLines()
        .map { it.toInt() }
        .let { solve02(it) }
        .let { println("Result: $it") }
}

/**
 * Finds first duplicate sum in a repeatedly [scan]ned [input] [List].
 */
fun solve02(input: List<Int>): Int? {
    var listNumber = 0

    val scannedList = mutableListOf(0)
    var start: Int
    var duplicate: Int?

    do {
        println("List number: ${listNumber++}")

        start = scannedList.size
        scannedList.addAll(input.scan(scannedList.last()) { a, b -> a + b })
        duplicate = scannedList.findDuplicate(start)
    } while (duplicate == null)

    return duplicate
}

/**
 * Iterates over a [List] while performing an accumulating [operation] on consecutive elements.
 *
 * Returns a List containing all intermediate results of the operation.
 */
private fun <T> List<T>.scan(initial: T, operation: (T, T) -> T): List<T> {
    var accumulator = operation(initial, first())

    return mapIndexed { index, element ->
        if (index != 0) accumulator = operation(accumulator, element)
        accumulator
    }
}

/**
 * Finds first duplicate element in a [List].
 *
 * Searches for duplicates of elements located between [start] index and the end of the list.
 * Returns first such element which is a duplicate of one of the elements located between
 * beginning of the list and `start - 1`. Returns `null` if no such element has been found.
 */
private fun <T> List<T>.findDuplicate(start: Int): T? {
    forEachIndexed { index, element ->
        if (index >= start && subList(0, index).contains(element)) return element
    }
    return null
}