package org.example.lessons.lessson08.homework

import java.nio.file.Path

fun main() {

    //Задание 1

    transformPhrase("Это невозможно выполнить за один день")
    transformPhrase("Я не уверен в успехе этого проекта")
    transformPhrase("Произошла катастрофа на сервере")
    transformPhrase("Этот код работает без проблем")
    transformPhrase("Удача")

    //Задание 2
    extractDateAndTime("Пользователь вошел в систему -> 2021-12-01 09:48:23")

    //Задание 3
    maskCardNumber("4539 1488 0343 6467")

    //Задание 4
    replaceEmail("username@example.com")

    //Задание 5
    extractFileName("C:/Пользователи/Документы/report.txt")

    //Задание 6
    createAbbreviation("Объектно ориентированное программирование")
}

fun transformPhrase(phrase: String) {

    val result = when {
        phrase.contains("невозможно") -> phrase.replace(
            "невозможно",
            "совершенно точно возможно, просто требует времени"
        )

        phrase.startsWith("Я не уверен", true) -> "$phrase, но моя интуиция говорит об обратном"
        phrase.contains("катастрофа") -> phrase.replace("катастрофа", "интересное событие")
        phrase.endsWith("без проблем") -> phrase.replace("без проблем", "с парой интересных вызовов на пути")
        phrase.isNotEmpty() -> "Иногда, $phrase , но не всегда"
        else -> phrase
    }
    println(result)
    println()
}

fun extractDateAndTime(log: String) {
    val arrowIndes = log.indexOf("->")
    val dateAndTime = log.substring(arrowIndes + 2).trim()
    val parts = dateAndTime.split(" ")

    val date = parts[0]
    val time = parts[1]

    println(date)
    println(time)
}

fun maskCardNumber(cardNumber: String) {

    val lastFourNumbers = cardNumber.substring(cardNumber.length - 4)
    val maskNumbers = "*".repeat(4)

    println("$maskNumbers $maskNumbers $maskNumbers $lastFourNumbers")
}

fun replaceEmail(email: String) {
    val formatEmail = email
        .replace("@", " [at] ")
        .replace(".", " [dot] ")
    println(formatEmail)
}

fun extractFileName(path: String) {
    val lastSlashIndex = path.lastIndexOf('/')
    val fileName = path.substring(lastSlashIndex + 1)

    println(fileName)
}

fun createAbbreviation(phrase: String) {
    val words = phrase.split(" ")
    var abbreviation = ""

    for (word in words) {
        if (word.isNotEmpty()) {
            abbreviation += word[0]
        }
    }
    println(abbreviation.uppercase())
}