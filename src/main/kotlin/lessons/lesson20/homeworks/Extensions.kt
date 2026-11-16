package lessons.lesson20.homeworks

import java.util.Collections
import kotlin.math.absoluteValue

fun <T : Number> Array<out T>.firstAndLast(): Pair<T?, T?> =
    firstOrNull() to lastOrNull()

fun <T : Comparable<T>> MutableList<T>.sortAndView(ascending: Boolean): List<T> {
    if (ascending) sort() else sortDescending()
    return Collections.unmodifiableList(this)
}

fun <K, V> Map<K, List<V>>?.valuesAt(index: Int): Map<String, V?>? =
    this?.entries?.associate { (key, values) -> key.toString() to values.getOrNull(index) }

fun Number.within(other: Number, deviation: Number): Boolean =
    (toDouble() - other.toDouble()).absoluteValue <= deviation.toDouble()

fun String.encrypt(base: Int): String = map { it + base }.joinToString("")

fun String.decrypt(base: Int): String = map { it - base }.joinToString("")

fun String.printLetterThread(usernames: List<String>) {
    require(usernames.size == length) { "Нужно указать по одному имени на каждый символ." }
    forEachIndexed { index, character ->
        println(usernames[index])
        println(character.uppercase())
    }
}
