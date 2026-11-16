package lessons.lesson19.homeworks

interface Mapper<T, R> {
    fun map(element: T): R
    fun mapList(elements: List<T>): List<R>
}
