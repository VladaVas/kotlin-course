package lessons.lesson20.homeworks

fun main() {
    check(arrayOf(1, 2, 3).firstAndLast() == (1 to 3))
    check(arrayOf(0.5).firstAndLast() == (0.5 to 0.5))
    check(emptyArray<Int>().firstAndLast() == (null to null))

    val numbers = mutableListOf(3, 1, 2)
    val sortedView = numbers.sortAndView(ascending = true)
    check(numbers == listOf(1, 2, 3))
    numbers.sortAndView(ascending = false)
    check(sortedView == listOf(3, 2, 1))

    val lists = mapOf(1 to listOf("a", "b"), 2 to emptyList())
    check(lists.valuesAt(1) == mapOf("1" to "b", "2" to null))
    check(lists.valuesAt(-1) == mapOf("1" to null, "2" to null))
    val missingMap: Map<Int, List<String>>? = null
    check(missingMap.valuesAt(0) == null)

    check(10.within(12L, 2))
    check(!10L.within(12.5, 2F))
    check(3.5F.within(4.0, 0.5))
    check(!4.0.within(4, -1))

    val message = "Привет, Kotlin! 🌟"
    val encrypted = message.encrypt(7)
    check(encrypted.decrypt(7) == message)
    check(message.encrypt(-7).decrypt(-7) == message)

    println("Проверки пройдены.")
    "кот".printLetterThread(listOf("@anna", "@max", "@ira"))
}
