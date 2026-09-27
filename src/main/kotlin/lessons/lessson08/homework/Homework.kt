package org.example.lessons.lessson08.homework

fun main() {
// Задание 1
    transformPhrase("Это невозможно выполнить за один день")
    transformPhrase("Я не уверен в успехе этого проекта")
    transformPhrase("Произошла катастрофа на сервере")
    transformPhrase("Этот код работает без проблем")
    transformPhrase("Удача")

// Задание 2
    extractDateAndTime("Пользователь вошел в систему -> 2021-12-01 09:48:23")

// Задание 3
    maskCardNumber("4539 1488 0343 6467")

// Задание 4
    formatEmail("username@example.com")

// Задание 5
    extractFileName("C:/Пользователи/Документы/report.txt")
    extractFileName("D:/good.themes/dracula.theme")

// Задание 6
    createAbbreviation("Котлин лучший язык программирования")}

// Задание 1: Преобразование строк
fun transformPhrase(phrase: String) {
var result = phrase

if (result.contains("невозможно")) {
    result = result.replace(
        "невозможно",
        "совершенно точно возможно, просто требует времени"
    )
}

if (result.startsWith("Я не уверен")) {
    result = "$result, но моя интуиция говорит об обратном"
}

if (result.contains("катастрофа")) {
    result = result.replace("катастрофа", "интересное событие")
}

if (result.endsWith("без проблем")) {
    result = result.replace(
        "без проблем",
        "с парой интересных вызовов на пути"
    )
}

if (!result.contains(" ") && result.isNotEmpty()) {
    result = "Иногда, $result, но не всегда"
}

println(result)}


// Задание 2: Извлечение даты из строки лога
fun extractDateAndTime(log: String) {
val arrowIndex = log.indexOf("->")
val dateAndTime = log.substring(arrowIndex + 2).trim()
val parts = dateAndTime.split(" ")

val date = parts[0]
val time = parts[1]

println(date)
println(time)}

// Задание 3: Маскирование личных данных
fun maskCardNumber(cardNumber: String) {
val lastFourDigits = cardNumber.takeLast(4)
val maskedNumber = "*".repeat(cardNumber.length - 4) + lastFourDigits

println(maskedNumber)}

// Задание 4: Форматирование адреса электронной почты
fun formatEmail(email: String) {
val formattedEmail = email
    .replace("@", " [at] ")
    .replace(".", " [dot] ")

println(formattedEmail)}

// Задание 5: Извлечение имени файла из пути
fun extractFileName(path: String) {
val fileName = path.substringAfterLast("/")

println(fileName)}

// Задание 6: Создание аббревиатуры из фразы
fun createAbbreviation(phrase: String) {
val words = phrase.split(" ")
var abbreviation = ""

for (word in words) {
    if (word.isNotEmpty()) {
        abbreviation += word[0]
    }
}

println(abbreviation)
}