package lessons.lesson16.homework.task5

import lessons.lesson16.homework.task3.ConsoleColors

class Logger {
    fun log(message: String) {
        println("[INFO] $message")
    }

    fun log(level: LogLevel, message: String) {
        when (level) {
            LogLevel.INFO -> println("[INFO] $message")

            LogLevel.WARNING -> println(
                "
                { ConsoleColors.RESET }"
            )

            LogLevel.ERROR -> println(
                "
                { ConsoleColors.BG_RED }" +
                "[ERROR]
                { ConsoleColors.RESET }"
            )

            LogLevel.DEBUG -> println("[DEBUG] $message")
        }
    }

    fun log(messages: List<String>) {
        for (message in messages) {
            log(message)
        }
    }

    fun log(exception: Exception) {
        log(LogLevel.ERROR, exception.message ?: "Unknown error")
    }
}