package lessons.lesson21.homeworks

fun analyzeDataType(value: Any) {
    val message = when (value) {
        is String -> "Это строка: $value"
        is Number -> "Это число: $value"
        is List<*> -> "Это список, количество элементов: ${value.size}"
        is Map<*, *> -> "Это словарь, количество пар: ${value.size}"
        else -> "Неизвестный тип данных"
    }
    println(message)
}

fun safeCastToList(value: Any): Int = (value as? List<*>)?.size ?: -1

fun getStringLengthOrZero(value: Any?): Int = (value as? String)?.length ?: 0

fun Any.toSquare(): Double {
    val number = when (this) {
        is Number -> toDouble()
        is String -> toDouble()
        else -> throw IllegalArgumentException("Ожидалось число или строка с числом")
    }
    return number * number
}

fun sumIntOrDoubleValues(values: List<Any>): Double = values.sumOf { value ->
    when (value) {
        is Int -> value.toDouble()
        is Double -> value
        else -> 0.0
    }
}

fun tryCastToListAndPrint(value: Any) {
    val list = value as? List<*>
    if (list == null) {
        println("Ошибка: аргумент не является списком")
        return
    }

    for ((index, element) in list.withIndex()) {
        if (element is String) {
            println(element)
        } else {
            println("Предупреждение: элемент с индексом $index не является строкой")
        }
    }
}
