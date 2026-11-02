package lessons.lesson16.homework.task3

private val colors = listOf(
    ConsoleColors.WHITE to ConsoleColors.BG_RED,
    ConsoleColors.BLACK to ConsoleColors.BG_YELLOW,
    ConsoleColors.WHITE to ConsoleColors.BG_BLUE,
    ConsoleColors.BLACK to ConsoleColors.BG_GREEN,
    ConsoleColors.WHITE to ConsoleColors.BG_MAGENTA,
    ConsoleColors.BLACK to ConsoleColors.BG_CYAN
)

fun print(text: String) {
    val words = text.split(" ")

    words.forEachIndexed { index, word ->
        val (textColor, backgroundColor) = colors[index % colors.size]

        println(
            "$textColor$backgroundColor$word{ ConsoleColors.RESET }"
        )
    }
}