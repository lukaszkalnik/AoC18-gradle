package extensions

/**
 * Iterates over a [List] while performing an accumulating [operation] on consecutive elements.
 *
 * Returns a List containing all intermediate results of the operation.
 */
fun <T> List<T>.scan(initial: T, operation: (T, T) -> T): List<T> {
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
fun <T> List<T>.findDuplicate(start: Int): T? {
    forEachIndexed { index, element ->
        if (index >= start && subList(0, index).contains(element)) return element
    }
    return null
}