package lessons.lesson16.homework.task3

class LaserPrinter : Printer() {
    fun print(text: String) {
        val words = text.split(" ")

        for (word in words) {
            println(
                "${ConsoleColors.BLACK}${ConsoleColors.BG_WHITE}" +
                        word +
                ConsoleColors.RESET
            )
        }
    }
}
