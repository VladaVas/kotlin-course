package org.example.lessons.lesson10.homework

fun main() {

    // Задание 1. Пустой неизменяемый словарь Int -> Int
    val dictionary1: Map<Int, Int> = emptyMap()
    println(dictionary1)


    // Задание 2. Словарь Float -> Double
    val dictionary2 = mapOf(
        1.5f to 10.5,
        2.5f to 20.5,
        3.5f to 30.5
    )
    println(dictionary2)


    // Задание 3. Изменяемый словарь Int -> String
    val dictionary3 = mutableMapOf(
        1 to "Анна",
        2 to "Иван"
    )
    println(dictionary3)


    // Задание 4. Добавление новых пар
    dictionary3[3] = "Мария"
    dictionary3[4] = "Пётр"
    println(dictionary3)


    // Задание 5. Получение значения по ключу
    val value = dictionary3[2]
    val missingValue = dictionary3[10]

    println(value)
    println(missingValue)


    // Задание 6. Удаление элемента по ключу
    dictionary3.remove(1)
    println(dictionary3)


    // Задание 7. Деление ключа на значение
    val dictionary7 = mapOf(
        10.0 to 2,
        15.0 to 3,
        20.0 to 0,
        25.0 to 5
    )

    for ((key, value) in dictionary7) {
        if (value == 0) {
            println("бесконечность")
        } else {
            println(key / value)
        }
    }


    // Задание 8. Изменение значения существующего ключа
    dictionary3[2] = "Алексей"
    println(dictionary3)


    // Задание 9. Объединение двух словарей через циклы
    val dictionary9a = mapOf(
        1 to "Один",
        2 to "Два"
    )

    val dictionary9b = mapOf(
        3 to "Три",
        4 to "Четыре"
    )

    val combinedDictionary = mutableMapOf<Int, String>()

    for ((key, value) in dictionary9a) {
        combinedDictionary[key] = value
    }

    for ((key, value) in dictionary9b) {
        combinedDictionary[key] = value
    }

    println(combinedDictionary)


    // Задание 10. Словарь String -> List<Int>
    val dictionary10 = mapOf(
        "Чётные" to listOf(2, 4, 6, 8),
        "Нечётные" to listOf(1, 3, 5, 7),
        "Простые" to listOf(2, 3, 5, 7)
    )

    println(dictionary10)


    // Задание 11. Словарь Int -> MutableSet<String>
    val dictionary11 = mutableMapOf(
        1 to mutableSetOf("Кotlin", "Java"),
        2 to mutableSetOf("Python", "JavaScript")
    )

    val languages = dictionary11[1]
    languages?.add("Scala")

    println(languages)


    // Задание 12. Словарь с парой чисел в качестве ключа
    val dictionary12 = mapOf(
        (1 to 2) to "Первое значение",
        (5 to 3) to "Второе значение",
        (4 to 5) to "Третье значение",
        (7 to 8) to "Четвёртое значение"
    )

    for ((key, value) in dictionary12) {
        if (key.first == 5 || key.second == 5) {
            println(value)
        }
    }


    // Задачи на подбор оптимального типа для словаря

    // 1. Библиотека: автор -> список книг
    val library = mapOf(
        "Пушкин" to listOf("Евгений Онегин", "Капитанская дочка"),
        "Толстой" to listOf("Война и мир", "Анна Каренина")
    )
    println(library)


    // 2. Справочник растений: тип -> список растений
    val plants = mapOf(
        "Цветы" to listOf("Роза", "Тюльпан"),
        "Деревья" to listOf("Берёза", "Дуб")
    )
    println(plants)


    // 3. Четвертьфинала: команда -> список игроков
    val teams = mapOf(
        "Команда А" to listOf("Иван", "Пётр"),
        "Команда Б" to listOf("Анна", "Мария")
    )
    println(teams)


    // 4. Курс лечения: дата -> список препаратов
    val treatment = mapOf(
        "2026-10-09" to listOf("Препарат А", "Препарат Б"),
        "2026-10-10" to listOf("Препарат В")
    )
    println(treatment)


    // 5. Путешественник: страна -> город -> список мест
    val travelDictionary = mapOf(
        "Япония" to mapOf(
            "Нара" to listOf("Парк Нары", "Тодай-дзи"),
            "Осака" to listOf("Замок Осаки", "Дотонбори")
        ),
        "Южная Корея" to mapOf(
            "Сеул" to listOf("Кёнбоккун", "Намсан")
        )
    )
    println(travelDictionary)
}