package lessons.lesson22.homework

// Задача 1
fun causeNullPointerException(): Int {
    val text: String? = null
    return text!!.length
}

// Задача 2
fun causeIndexOutOfBoundsException(): Int = listOf(1, 2, 3)[3]

// Задача 3
fun causeClassCastException(): String {
    val number: Any = 42
    return number as String
}

// Задача 4
fun causeIllegalArgumentException() {
    val age = -1
    require(age >= 0) { "Возраст должен быть неотрицательным" }
}

// Задача 5
fun causeNumberFormatException(): Int = "abc".toInt()

// Задача 6
fun causeIllegalStateException() {
    val connectionOpen = false
    check(connectionOpen) { "Соединение закрыто" }
}

// Задача 7
fun causeOutOfMemoryError(): ByteArray {
    // Такой размер превышает предел JVM для массива.
    return ByteArray(Int.MAX_VALUE)
}

// Задача 8
fun causeStackOverflowError() {
    causeStackOverflowError()
}

// Задача 9
fun catchAllExamples() {
    val examples = listOf<() -> Unit>(
        { causeNullPointerException() },
        { causeIndexOutOfBoundsException() },
        { causeClassCastException() },
        { causeIllegalArgumentException() },
        { causeNumberFormatException() },
        { causeIllegalStateException() },
        { causeOutOfMemoryError() },
        { causeStackOverflowError() },
    )

    for (example in examples) {
        try {
            example()
        } catch (_: NullPointerException) {
            println("NullPointerException")
        } catch (_: IndexOutOfBoundsException) {
            println("IndexOutOfBoundsException")
        } catch (_: ClassCastException) {
            println("ClassCastException")
        } catch (_: NumberFormatException) {
            // NumberFormatException наследуется от IllegalArgumentException.
            println("NumberFormatException")
        } catch (_: IllegalArgumentException) {
            println("IllegalArgumentException")
        } catch (_: IllegalStateException) {
            println("IllegalStateException")
        } catch (_: OutOfMemoryError) {
            println("OutOfMemoryError")
        } catch (_: StackOverflowError) {
            println("StackOverflowError")
        }
    }
}

// Задача 10
fun validateArgument(argument: Any?) {
    try {
        // Принимаем строку или берём первый элемент списка.
        val value = argument!!
        val first = if (value is List<*>) value[0] else value
        val text = first as String
        require(text.isNotBlank()) { "Строка должна содержать число" }
        val number = text.toInt()
        check(number > 0) { "Число должно быть положительным" }
        println("Переданный аргумент фантастически хорош!")
    } catch (error: Throwable) {
        when (error) {
            is NullPointerException -> println("NullPointerException")
            is IndexOutOfBoundsException -> println("IndexOutOfBoundsException")
            is ClassCastException -> println("ClassCastException")
            is NumberFormatException -> println("NumberFormatException")
            is IllegalArgumentException -> println("IllegalArgumentException")
            is IllegalStateException -> println("IllegalStateException")
            else -> println(error.javaClass.simpleName)
        }
        throw error
    }
}

// Задача 12
fun wrapIndexError() {
    try {
        causeIndexOutOfBoundsException()
    } catch (error: IndexOutOfBoundsException) {
        println("Индекс за пределами списка: ${error.message}")
        throw HomeworkIndexException(error)
    }
}

fun main(args: Array<String>) {
    when (args.firstOrNull() ?: "9") {
        "9" -> catchAllExamples()
        "10" -> validateArgument(args.getOrNull(1))
        // Задача 11
        "11" -> throw HomeworkAssertionError("Проверка завершилась ошибкой")
        "12" -> wrapIndexError()
        else -> println("Укажи номер задания: 9, 10, 11 или 12")
    }
}
