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
 * Returns first found duplicate element in a [List].
 */
fun <T> List<T>.findDuplicate(): T? {
    forEachIndexed { index, element ->
        if (subList(0, index).contains(element)) return element
    }
    return null
}