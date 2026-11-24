package org.example.lessons.lesson09.homework

fun main() {

    // 1. Массив из 5 целых чисел от 1 до 5
    val numbers = arrayOf(1, 2, 3, 4, 5)
    println("Результат: ${numbers.contentToString()}")

    // 2. Пустой массив строк размером 10 элементов
    val string = Array(10) { "" }
    string[0] = "Hello"
    string[1] = "Good bye"

    println(string.contentToString())

    // 3. Массив из 5 элементов Double с удвоенным индексом
    val doubleArray = DoubleArray(5) { index -> index * 2.0 }
    println(doubleArray.contentToString())

    // 4. Массив Int, каждому элементу присваиваем индекс * 3
    val intArray = IntArray(5)
    for (index in 0..4) {
        intArray[index] = index * 3
    }
    println(intArray.contentToString())

    // 5. Массив из 3 nullable строк
    val nullArray = Array<String?>(3) { null }
    nullArray[0] = null
    nullArray[1] = "String1"
    nullArray[2] = "String2"

    println(nullArray.contentToString())

    // 6. Копирование массива в цикле
    val originalArray = arrayOf(1, 2, 3, 4, 5)
    val copyArray = Array(originalArray.size) { 0 }
    for (i in originalArray.indices) {
        copyArray[i] = originalArray[i]
    }

    println(copyArray.contentToString())

    // 7. Два массива, вычитаем один из другого
    val array1 = arrayOf(1, 2, 3, 4, 5)
    val array2 = arrayOf(5, 6, 7, 8, 9)
    val array3 = IntArray(array1.size)

    for (i in array1.indices) {
        array3[i] = array2[i] - array1[i]
    }

    println(array3.contentToString())

    // 8. Найти индекс элемента со значением 5 (while цикл)
    val array4 = arrayOf(1, 2, 3, 4, 5)
    var index = 0
    var result = -1

    while (index < array4.size) {
        if (array4[index] == 5) {
            result = index
            break
        }
        index++
    }

    println(result)


    // 9. Перебор массива и определение чётности
    val array5 = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val number = 0

    for (number in array5) {
        if (number % 2 == 0) {
            println("$number is even")
        } else {
            println("$number is odd")
        }
    }

    // 10. Функция поиска подстроки в массиве
    val words = arrayOf("Hello", "Good bye", "Nice to meet", "How are you", "How are you")
    findString(words, "bye")


    // 11. Пустой неизменяемый список целых чисел
    val emptyList = emptyList<Int>()
    // 12. Неизменяемый список строк из трёх элементов
    val stringList = listOf("Hello", "World", "Kotlin")

    // 13. Изменяемый список целых чисел от 1 до 5
    val variableList = mutableListOf(1, 2, 3, 4, 5)

    // 14. Добавить в изменяемый список элементы 6, 7, 8
    variableList.addAll(listOf(6, 7, 8))

    // 15. Удалить элемент из списка строк
    val mutableStrings = stringList.toMutableList()
    mutableStrings.remove("Hello")
    println(mutableStrings)

    // 16. Вывести каждый элемент списка на экран
    val numbersList = listOf(1, 2, 3, 4, 5)
    for (number in numbersList) {
        println(number)
    }

    // 17. Получить второй элемент списка по индексу
    println(stringList[1])

    // 18. Изменить значение элемента на определённой позиции
    variableList[2] = 9
    println(variableList)

    // 19. Объединить два списка строк в один (цикл)

    val list1 = listOf("Nice", "Good", "Fine")
    val list2 = listOf("Cat", "Dog", "Watermelon")
    val list3 = mutableListOf<String>()

    // Добавляем элементы из первого списка
    for (word in list1) {
        list3.add(word)
    }

    // Добавляем элементы из второго списка
    for (word in list2) {
        list3.add(word)
    }

    println(list3)

    // 20. Найти минимальный и максимальный элементы (цикл)

    val values = listOf<Int>(6, 13, 94, 8, 0, 1)
    var min = values[0]
    var max = values[0]

    for (number in values) {
        if (number < min) {
            min = number
        }

        if (number > max) {
            max = number
        }
    }

    println("$min, $max")


    // 21. Создать новый список с только чётными числами (цикл)
    val evenList = mutableListOf<Int>()

    for (number in values) {
        if (number % 2 == 0) {
            evenList.add(number)
        }
    }
    println(evenList)

    // 22. Пустое неизменяемое множество целых чисел

    val emptySetNumbers = emptySet<Int>()

    // 23. Неизменяемое множество из трёх элементов
    val setNumbers = setOf<Int>(1, 2, 3)

    // 24. Изменяемое множество строк

    val mutableSet = mutableSetOf("Kotlin", "Java", "Scala")

    // 25. Добавить новые элементы в множество
    mutableSet.add("Swift")
    mutableSet.add("Go")

    // 26. Удалить элемент из множества

    val mutableSetNumbers = mutableSetOf(1, 2, 3, 4, 5)
    mutableSetNumbers.remove(5)


    // 27. Вывести каждый элемент множества (цикл)
    for (number in mutableSetNumbers) {
        println(number)
    }

    // 28. Функция для проверки наличия строки в множестве (цикл)
    println(findSetString(mutableSet, "Java"))

    // 29. Конвертировать неизменяемое множество в изменяемый список (цикл)

    val set1 = setOf("1", "2", "3", "4")
    val set2 = mutableListOf<String>()

    for (word in set1) {
        set2.add(word)
    }

    println(set2)
}

// Функция для поиска строки в массиве по подстроке
fun findString(words: Array<String>, search: String) {
    for (word in words) {
        if (word.contains(search)) {
            println(word)
            return
        }
    }
    println("Can't find word $search")
}
// Функция для проверки наличия строки в множестве

fun findSetString(mutableSet: Set<String>, search: String): Boolean {
    for (word in mutableSet) {
        if (word == search) {
            return true
        }
    }
    return false
}
