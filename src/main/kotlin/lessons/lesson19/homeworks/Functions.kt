package lessons.lesson19.homeworks

fun <T> getMiddleElement(elements: List<T>): T? =
    if (elements.size % 2 == 0) null else elements[elements.size / 2]

/** При совпадении значений сохраняется последний ключ в порядке обхода словаря. */
fun <K, V> transposition(entries: Map<K, V>): Map<V, K> =
    entries.entries.associate { (key, value) -> value to key }
