package lessons.lesson19.homeworks

import java.util.Collections

class ListHolder<T> {
    private val elements = mutableListOf<T>()

    fun add(element: T) {
        elements.add(element)
    }

    fun getAll(): List<T> = Collections.unmodifiableList(elements.toList())
}
