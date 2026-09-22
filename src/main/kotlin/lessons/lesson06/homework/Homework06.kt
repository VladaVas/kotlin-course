package org.example.lessons.lesson06.homework

fun main() {
    determineSeason(3)

    calculatePetAge(5)

    chooseTransport(4.0)

    calculateBonusPoints(1500.0)

    determineDocumentType("jpg")

    convertTemperature(25.0, 'C')

    chooseClothes(15)

    println(selectMovieCategory(15))
}

// Задание 1
fun determineSeason(month: Int) {
    val season = when (month) {
        12, 1, 2 -> "Зима"
        3, 4, 5 -> "Весна"
        6, 7, 8 -> "Лето"
        9, 10, 11 -> "Осень"
        else -> "Некорректный номер месяца"
    }

    println(season)
}

// Задание 2
fun calculatePetAge(age: Int) {
    val humanAge = if (age <= 2) {
        age * 10.5
    } else {
        2 * 10.5 + (age - 2) * 4
    }

    println(humanAge)
}

// Задание 3
fun chooseTransport(distance: Double) {
    val transport = when {
        distance <= 1 -> "пешком"
        distance <= 5 -> "велосипед"
        else -> "автотранспорт"
    }

    println(transport)
}

// Задание 4
fun calculateBonusPoints(purchaseAmount: Double) {
    val bonusPoints = if (purchaseAmount <= 1000) {
        (purchaseAmount / 100 * 2).toInt()
    } else {
        (purchaseAmount / 100 * 3).toInt()
    }

    println(bonusPoints)
}

// Задание 5
fun determineDocumentType(extension: String) {
    val documentType = when (extension.lowercase()) {
        "txt", "doc", "docx" -> "Текстовый документ"
        "jpg", "jpeg", "png", "gif" -> "Изображение"
        "xls", "xlsx", "csv" -> "Таблица"
        else -> "Неизвестный тип"
    }

    println(documentType)
}

// Задание 6
fun convertTemperature(temperature: Double, unit: Char) {
    val result = if (unit == 'C') {
        temperature * 9 / 5 + 32
    } else {
        (temperature - 32) * 5 / 9
    }

    print(result)

    if (unit == 'C') {
        print("F")
    } else {
        print("C")
    }
}

// Задание 7
fun chooseClothes(temperature: Int) {
    val clothes = when {
        temperature < -30 || temperature > 35 -> "не выходить из дома"
        temperature < 10 -> "куртка и шапка"
        temperature <= 18 -> "ветровка"
        else -> "футболка и шорты"
    }

    println(clothes)
}

// Задание 8
fun selectMovieCategory(age: Int): String {
    val category = when {
        age in 0..9 -> "детские"
        age in 10..18 -> "подростковые"
        else -> "18+"
    }

    return category
}